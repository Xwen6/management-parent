package wyu.xwen.communityService.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsBuilding;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.vo.BuildingVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.mapper.EsBuildingMapper;
import wyu.xwen.communityService.service.EsBuildingService;
import wyu.xwen.communityService.service.EsCommunityService;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 栋数信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Service
public class EsBuildingServiceImpl extends ServiceImpl<EsBuildingMapper, EsBuilding> implements EsBuildingService {

    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EsCommunityService esCommunityService;


    @Override
    public List<EsBuilding>  getBuildingByCCode(String code)  {

            QueryWrapper<EsBuilding> wrapper = new QueryWrapper<>();
            wrapper.eq("community_code",code);
            List<EsBuilding> esBuildings = baseMapper.selectList(wrapper);
        return esBuildings;
    }

    @Override
    public boolean addBuilding(EsBuilding esBuilding) {
        int insert = 0;
        try {
            if (!ObjectUtils.isEmpty(esBuilding)){
                /*生成code*/
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String d = simpleDateFormat.format(date);
                String d2 = "BD"+d;
                esBuilding.setCode(d2);
                insert = baseMapper.insert(esBuilding);
                EsBuilding building = baseMapper.selectById(esBuilding.getId());
                IndexRequest request = new IndexRequest("building").id(building.getId().toString());
                request.source(objectMapper.writeValueAsString(building), XContentType.JSON);
                client.index(request, RequestOptions.DEFAULT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return insert>0;
    }

    @Override
    public boolean deleteBuildingByCode(String code) {
        QueryWrapper<EsBuilding> wrapper = new QueryWrapper<>();
        wrapper.eq("code",code);
        EsBuilding building = baseMapper.selectOne(wrapper);
        int d = 0;
        try {
            if (!ObjectUtils.isEmpty(building)) {
                DeleteRequest request = new DeleteRequest("building").id(building.getId().toString());
                client.delete(request,RequestOptions.DEFAULT);
                d = baseMapper.deleteById(building);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return d>0;
    }

    @Override
    public boolean updateBuilding(EsBuilding building) {
        int update = baseMapper.updateById(building);
        try {
            EsBuilding building1 = baseMapper.selectById(building);
            if (!ObjectUtils.isEmpty(building1)) {
                IndexRequest request = new IndexRequest("building").id(building1.getId().toString());
                request.source(objectMapper.writeValueAsString(building1),XContentType.JSON);
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
            SearchRequest searchRequest = new SearchRequest("building");
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

    @Override
    public EsBuilding getBuildingByCode(String code) {
        EsBuilding esBuilding = null;
        try {
            if (!StringUtils.isEmpty(code)) {
                SearchRequest searchRequest = new SearchRequest("building");
                searchRequest.source().query(QueryBuilders.termQuery("code", code));
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                SearchHits hits = response.getHits();
                for (SearchHit hit : hits) {
                    String json = hit.getSourceAsString();
                    esBuilding = objectMapper.readValue(json,EsBuilding.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return esBuilding;
    }

    /*处理条件查询结果*/
    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<BuildingVo> buildingInfo = new ArrayList<>();
        for (SearchHit hit :hitsArray
        ) {
            /*获取json字符串*/
            String petInfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsBuilding esBuilding = objectMapper.readValue(petInfoJson, EsBuilding.class);
            BuildingVo buildingVo = new BuildingVo();
            buildingVo.setId(esBuilding.getId());
            buildingVo.setCode(esBuilding.getCode());
            buildingVo.setName(esBuilding.getName());
            buildingVo.setHouse(esBuilding.getHouse());
            buildingVo.setCreateTime(esBuilding.getCreateTime());
            buildingVo.setDescription(esBuilding.getDescription());
            EsCommunity esCommunity = esCommunityService.getByCCode(esBuilding.getCommunityCode());
            if (!ObjectUtils.isEmpty(esCommunity)) {
                buildingVo.setCommunityName(esCommunity.getName());
            }
            buildingInfo.add(buildingVo);
        }
        /*封装查询结果*/
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("items",buildingInfo);
        return resultMap;
    }

    private void buildBoolQuery(QueryCondition queryCondition, SearchRequest searchRequest) throws IOException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(queryCondition.getCondition())){
            SearchRequest request = new SearchRequest();
            request.indices("community").source().query(QueryBuilders.matchQuery("name",queryCondition.getCondition()));
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            if (hits.length>0){
                for (SearchHit hit : hits) {
                    String sourceAsString = hit.getSourceAsString();
                    String code = JSONObject.parseObject(sourceAsString).getString("code");
                    boolQuery.should(QueryBuilders.matchQuery("communityCode",code));
                }
            }else{
                boolQuery.must(QueryBuilders.matchQuery("all", queryCondition.getCondition()));
            }
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
