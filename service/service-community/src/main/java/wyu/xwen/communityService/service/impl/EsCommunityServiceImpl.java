package wyu.xwen.communityService.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsBuilding;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.vo.*;
import wyu.xwen.communityService.mapper.EsCommunityMapper;
import wyu.xwen.communityService.service.EsBuildingService;
import wyu.xwen.communityService.service.EsCommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 小区信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Service
public class EsCommunityServiceImpl extends ServiceImpl<EsCommunityMapper, EsCommunity> implements EsCommunityService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private EsCommunityMapper esCommunityMapper;
    @Autowired
    private EsBuildingService esBuildingService;

    /*删除社区信息*/
    @Override
    public boolean deleteById(Integer id) {

        int i = 0;
        try {

            DeleteRequest userPetRequest = new DeleteRequest("community").id(id.toString());
            client.delete(userPetRequest, RequestOptions.DEFAULT);
            i = baseMapper.deleteById(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return i>0;

    }

    @Override
    public List<EsCommunity> getListByName(String name){
        QueryWrapper<EsCommunity> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        List<EsCommunity> list = new ArrayList<>();
        list =  baseMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<EsCommunity> getList() {
        List<EsCommunity> list = baseMapper.selectList(null);
        return list;
    }

    /*根据社区代码查询社区信息*/
    @Override
    public EsCommunity getByCCode(String code) {
        String communityJson = "";
        EsCommunity community = null;
        try {
            /*es查询*/
            SearchRequest request = new SearchRequest("community");
            request.source()
                    .query(QueryBuilders.termQuery("code",code));
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHits hit = response.getHits();
            SearchHit[] hits = hit.getHits();
            for (SearchHit documentFields : hits) {
               communityJson = documentFields.getSourceAsString();
            }

            if (!StringUtils.isEmpty(communityJson)) {
                community = objectMapper.readValue(communityJson, EsCommunity.class);
                /**/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return community;
    }

    /*更新社区的信息*/
    @Override
    public boolean updateCommunity(EsCommunity esCommunity) {
        try {
            /*更新社区信息*/
            UpdateWrapper<EsCommunity> wrapper = new UpdateWrapper<>();
            wrapper.eq("code",esCommunity.getCode());
            baseMapper.update(esCommunity,wrapper);
            EsCommunity community = baseMapper.selectOne(wrapper);
            /*更新到es*/
            IndexRequest request = new IndexRequest("community").id(community.getId().toString());
            request.source(objectMapper.writeValueAsString(community),XContentType.JSON);
            client.index(request,RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*分页条件查询*/
    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, QueryCondition queryCondition) {

        Map<String, Object> resultMap = new HashMap<>();
        try {
            SearchRequest searchRequest = new SearchRequest("community");
            searchRequest.source()
                    .query(QueryBuilders.matchAllQuery())
                    .from((current-1)*limit)
                    .size(limit);
            if (ObjectUtils.isEmpty(queryCondition)) {
                SearchResponse response = client.search(searchRequest,RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }else {
                buildBoolQuery(queryCondition,searchRequest);
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;

    }

    /*添加社区*/
    @Override
    public boolean addCommunity(EsCommunity community) {
        int insert = 0;
        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String d = simpleDateFormat.format(date);
            String d2 = "CM"+d;
            community.setCode(d2);
            /*更新到数据库*/
            insert = baseMapper.insert(community);
            /*同步更新到es*/
            EsCommunity community1 = baseMapper.selectById(community.getId());
            IndexRequest request = new IndexRequest("community").id(community1.getId().toString());
            String json = objectMapper.writeValueAsString(community1);
            request.source(json, XContentType.JSON);
            client.index(request,RequestOptions.DEFAULT);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return insert>0;
    }

    /*获取社区以及该社区下的楼栋信息*/
    @Override
    public CommunityVo getList(String code) {
        /*获取社区列表*/
        CommunityVo communityVo =  esCommunityMapper.getCommunityList(code);

        /*如果社区列表不为空*/
        if (!(ObjectUtils.isEmpty(communityVo))){
            /*获取楼栋信息列表*/
            List<EsBuilding> buildings = esBuildingService.getBuildingByCCode(communityVo.getCode());
            List<BuildingVo> buildingVos= new ArrayList<>();
            /*如果楼栋信息列表不为空则封装成vo类*/
            if (!(buildings.size()==0)){
                for (EsBuilding esBuilding : buildings) {
                    BuildingVo buildingVo = new BuildingVo();
                    buildingVo.setId(esBuilding.getId());
                    buildingVo.setCode(esBuilding.getCode());
                    buildingVo.setName(esBuilding.getName());
                    buildingVos.add(buildingVo);
                }/*将楼栋vo封装进社区列表*/communityVo.setChildren(buildingVos);
            }
        }

        return communityVo;
    }

    @Override
    public List<CommunityVo> getCommunityList() {
        List<CommunityVo> communityVos = new ArrayList<>();
        try {
            /*获取社区列表*/
            SearchRequest request = new SearchRequest("community");
            request.source().query(QueryBuilders.matchAllQuery());
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            if (hits.length>0){
                for (SearchHit hit : hits) {
                    CommunityVo communityVo = new CommunityVo();
                    communityVo.setId(Integer.parseInt(JSONObject.parseObject(hit.getSourceAsString()).getString("id")));
                    communityVo.setName(JSONObject.parseObject(hit.getSourceAsString()).getString("name"));
                    communityVo.setCode(JSONObject.parseObject(hit.getSourceAsString()).getString("code"));
                    /*获取楼栋信息列表*/
                    String code = JSONObject.parseObject(hit.getSourceAsString()).getString("code");
                    SearchRequest searchRequest = new SearchRequest("building");
                    searchRequest
                            .source()
                            .query(QueryBuilders.termQuery("communityCode", code));
                    SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                    SearchHit[] searchHits = searchResponse.getHits().getHits();
                    List<BuildingVo> buildingVos= new ArrayList<>();
                    if (searchHits.length>0) {
                        for (SearchHit searchHit : searchHits) {
                            /*反序列化*/
                            BuildingVo buildingVo = new BuildingVo();
                            buildingVo.setId(Integer.parseInt(JSONObject.parseObject(searchHit.getSourceAsString()).getString("id")));
                            buildingVo.setCode(JSONObject.parseObject(searchHit.getSourceAsString()).getString("code"));
                            buildingVo.setName(JSONObject.parseObject(searchHit.getSourceAsString()).getString("name"));
                            buildingVos.add(buildingVo);
                        }
                        communityVo.setChildren(buildingVos);
                    }
                    /*获取停车位列表*/
                    SearchRequest parkingRequest = new SearchRequest("parking");
                    searchRequest
                            .source()
                            .query(QueryBuilders.termQuery("communityCode", code));
                    SearchResponse parkingResponse = client.search(parkingRequest, RequestOptions.DEFAULT);
                    SearchHit[] parkingHits = parkingResponse.getHits().getHits();
                    List<ParkingSpaceVo> parkingSpaceVos = new ArrayList<>();
                    if (parkingHits.length>0){
                        for (SearchHit parkingHit : parkingHits) {
                            /*反序列化*/
                            ParkingSpaceVo parkingSpaceVo = new ParkingSpaceVo();
                            parkingSpaceVo.setId(Integer.parseInt(JSONObject.parseObject(parkingHit.getSourceAsString()).getString("id")));
                            parkingSpaceVo.setCode(JSONObject.parseObject(parkingHit.getSourceAsString()).getString("code"));
                            parkingSpaceVo.setName(JSONObject.parseObject(parkingHit.getSourceAsString()).getString("name"));
                            parkingSpaceVos.add(parkingSpaceVo);
                        }
                        communityVo.setParkingSpaceVoList(parkingSpaceVos);
                    }

                    communityVos.add(communityVo);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return communityVos;
    }

    /*处理条件查询结果*/
    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<EsCommunity> communityInfo = new ArrayList<>();
        for (SearchHit hit :hitsArray
        ) {
            /*获取json字符串*/
            String petInfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsCommunity community = objectMapper.readValue(petInfoJson, EsCommunity.class);
            communityInfo.add(community);
        }
        /*封装查询结果*/
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("items",communityInfo);
        return resultMap;
    }

    private void buildBoolQuery(QueryCondition queryCondition, SearchRequest searchRequest) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(queryCondition.getCondition())){
            boolQuery.must(QueryBuilders.matchQuery("all", queryCondition.getCondition()));
        }

        /*时间段查询*/
        if (!ObjectUtils.isEmpty(queryCondition.getBeginDate())&&!ObjectUtils.isEmpty(queryCondition.getEndDate())){
            //System.out.println(userInfo.getBeginDate().toString());
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .gte(simpleDateFormat.format(queryCondition.getBeginDate()))
                    .lte(simpleDateFormat.format(queryCondition.getEndDate())));
        }else if (!ObjectUtils.isEmpty(queryCondition.getBeginDate())&&ObjectUtils.isEmpty(queryCondition.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .gte(simpleDateFormat.format(queryCondition.getBeginDate())));
        }else if (ObjectUtils.isEmpty(queryCondition.getBeginDate())&&!ObjectUtils.isEmpty(queryCondition.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .lte(simpleDateFormat.format(queryCondition.getEndDate())));
        }
        searchRequest.source().query(boolQuery);
    }


}
