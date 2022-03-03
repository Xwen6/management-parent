package wyu.xwen.communityService.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsBuilding;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsHouse;
import wyu.xwen.communityService.entity.vo.HouseVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.mapper.EsHouseMapper;
import wyu.xwen.communityService.service.EsBuildingService;
import wyu.xwen.communityService.service.EsCommunityAdminService;
import wyu.xwen.communityService.service.EsCommunityService;
import wyu.xwen.communityService.service.EsHouseService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 房产信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-22
 */
@Service
public class EsHouseServiceImpl extends ServiceImpl<EsHouseMapper, EsHouse> implements EsHouseService {

    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EsCommunityService esCommunityService;
    @Autowired
    private EsBuildingService esBuildingService;



    @Override
    public boolean addHouse(EsHouse house) {
        int insert = 0;
        try {
            if (!StringUtils.isEmpty(house)) {

                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String d = simpleDateFormat.format(date);
                String d2 = "HS"+d;
                house.setCode(d2);
                insert = baseMapper.insert(house);
                EsHouse esHouse = baseMapper.selectById(house);
                IndexRequest request = new IndexRequest("house").id(esHouse.getId().toString());
                request.source(objectMapper.writeValueAsString(esHouse), XContentType.JSON);
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return insert>0;
    }

    @Override
    public boolean deleteHouseByCode(String code) {
        QueryWrapper<EsHouse> wrapper = new QueryWrapper<>();
        wrapper.eq("code",code);
        EsHouse esHouse = baseMapper.selectOne(wrapper);
        try {
            if (!ObjectUtils.isEmpty(esHouse)) {
                DeleteRequest request = new DeleteRequest("house").id(esHouse.getId().toString());
                client.delete(request,RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int delete = baseMapper.delete(wrapper);
        return delete>0;
    }

    @Override
    public boolean updateHouse(EsHouse house) {
        int update = baseMapper.updateById(house);
        try {
            EsHouse esHouse = baseMapper.selectById(house);
            if (!ObjectUtils.isEmpty(esHouse)) {
                IndexRequest request = new IndexRequest("house").id(esHouse.getId().toString());
                request.source(objectMapper.writeValueAsString(esHouse),XContentType.JSON);
                client.index(request,RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return update>0;
    }

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, QueryCondition queryCondition) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            SearchRequest searchRequest = new SearchRequest("house");
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @Override
    public EsHouse getHouseByCode(String code) {

        EsHouse house = null;
        try {
            if (!StringUtils.isEmpty(code)) {
                SearchRequest searchRequest = new SearchRequest("house");
                searchRequest.source().query(QueryBuilders.termQuery("code", code));
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                SearchHits hits = response.getHits();
                for (SearchHit hit : hits) {
                    String json = hit.getSourceAsString();
                    house = objectMapper.readValue(json,EsHouse.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return house;

    }

    @Override
    public List<EsHouse> selectListByCommunityCode(String communityCode) {
        QueryWrapper<EsHouse> wrapper = new QueryWrapper<>();
        wrapper.eq("community_code",communityCode);
        List<EsHouse> r = baseMapper.selectList(wrapper);
        return r;
    }

    /*处理条件查询结果*/
    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<HouseVo> houseInfo = new ArrayList<>();
        for (SearchHit hit :hitsArray
        ) {
            /*获取json字符串*/
            String petInfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsHouse esHouse = objectMapper.readValue(petInfoJson, EsHouse.class);
            /*封装社区、楼栋名称*/
            HouseVo houseVo = new HouseVo();
            houseVo.setId(esHouse.getId());
            houseVo.setCode(esHouse.getCode());
            houseVo.setDescription(esHouse.getDescription());
            houseVo.setFloor(esHouse.getFloor());
            houseVo.setName(esHouse.getName());
            houseVo.setRooms(esHouse.getRooms());
            houseVo.setEnterTime(esHouse.getEnterTime());
            houseVo.setOwnerTel(esHouse.getOwnerTel());
            houseVo.setOwnerName(esHouse.getOwnerName());
            houseVo.setUnit(esHouse.getUnit());
            EsCommunity community = esCommunityService.getByCCode(esHouse.getCommunityCode());
            EsBuilding building = esBuildingService.getBuildingByCode(esHouse.getBuildingCode());
            if (!ObjectUtils.isEmpty(community)) {
                houseVo.setCommunityName(community.getName());
            }
            if (!ObjectUtils.isEmpty(building)) {
                houseVo.setBuildingName(building.getName());
            }
            houseInfo.add(houseVo);
        }
        /*封装查询结果*/
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("items",houseInfo);
        return resultMap;
    }

    private void buildBoolQuery(QueryCondition queryCondition, SearchRequest searchRequest) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(queryCondition.getCondition())){
            SearchRequest request = new SearchRequest("building", "community");
            request.source().query(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name",queryCondition.getCondition())));
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            if (hits.length!=0){
                for (SearchHit hit : hits) {
                    String sourceAsString = hit.getSourceAsString();
                    String code = JSONObject.parseObject(sourceAsString).getString("code");
                    boolQuery.should(QueryBuilders.matchQuery("buildingCode",code));
                    boolQuery.should(QueryBuilders.matchQuery("communityCode",code));
                }
            }
            else {
            boolQuery.must(QueryBuilders.matchQuery("all", queryCondition.getCondition()));
            }
        }
        /*时间段查询*/
        if (!ObjectUtils.isEmpty(queryCondition.getBeginDate())&&!ObjectUtils.isEmpty(queryCondition.getEndDate())){
            //System.out.println(userInfo.getBeginDate().toString());
            boolQuery.filter(QueryBuilders.rangeQuery("enterTime")
                    .gte(simpleDateFormat.format(queryCondition.getBeginDate()))
                    .lte(simpleDateFormat.format(queryCondition.getEndDate())));
        }else if (!ObjectUtils.isEmpty(queryCondition.getBeginDate())&&ObjectUtils.isEmpty(queryCondition.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("enterTime")
                    .gte(simpleDateFormat.format(queryCondition.getBeginDate())));
        }else if (ObjectUtils.isEmpty(queryCondition.getBeginDate())&&!ObjectUtils.isEmpty(queryCondition.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("enterTime")
                    .lte(simpleDateFormat.format(queryCondition.getEndDate())));
        }
        searchRequest.source().query(boolQuery);
    }
}
