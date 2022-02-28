package wyu.xwen.userservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.userservice.entity.*;
import wyu.xwen.userservice.mapper.EsVehicleMapper;
import wyu.xwen.userservice.service.EsUserInfoService;
import wyu.xwen.userservice.service.EsVehicleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@Service
public class EsVehicleServiceImpl extends ServiceImpl<EsVehicleMapper, EsVehicle> implements EsVehicleService {

    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EsUserInfoService esUserInfoService;

    @Override
    public boolean addCar(EsVehicle vehicle) {
        int insert = 0;
        try {
            /*新增车辆信息*/
            insert = baseMapper.insert(vehicle);
            Integer userId = vehicle.getUserId();

            IndexRequest userVehicleRequest = new IndexRequest("uservehicle").id(vehicle.getId().toString());
            String carJson = objectMapper.writeValueAsString(vehicle);
            userVehicleRequest.source(carJson, XContentType.JSON);
            client.index(userVehicleRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return insert>0;
    }

    @Override
    public boolean updateCarInfo(EsVehicle vehicle) {
        int update = 0;
        try {
            update = baseMapper.updateById(vehicle);
            vehicle = baseMapper.selectById(vehicle.getId());
            IndexRequest userVehicleRequest = new IndexRequest("uservehicle").id(vehicle.getId().toString());
            String carJson = objectMapper.writeValueAsString(vehicle);
            userVehicleRequest.source(carJson, XContentType.JSON);
            client.index(userVehicleRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return update>0;
    }

    @Override
    public boolean deleteById(Integer id) {

        try {

            DeleteRequest userVehicleRequest = new DeleteRequest("uservehicle").id(id.toString());
            client.delete(userVehicleRequest,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseMapper.deleteById(id)>0;
    }

    @Override
    public boolean batchDelete(List<Integer> ids) {
        try {
            for (Integer id:ids
                 ) {
                DeleteRequest userVehicleRequest = new DeleteRequest("uservehicle").id(id.toString());
                client.delete(userVehicleRequest,RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseMapper.deleteBatchIds(ids)== ids.size();
    }

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, CarQuery carQuery) {
        Map<String,Object> resultMap = null;
        try {
            /*准备查询的request*/
            SearchRequest searchRequest = new SearchRequest("uservehicle");
            searchRequest.source()
                    .query(QueryBuilders.matchAllQuery())
                    .from((current-1)*limit)
                    .size(limit);
            /*判断查询条件*/
            if (ObjectUtils.isEmpty(carQuery)){
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }else {
                // System.out.println(userInfo.getBeginDate().toString());
                //SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                buildBoolQuery(carQuery, searchRequest);
                searchRequest.source()
                        .from((current - 1) * limit).size(limit);
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public EsVehicleVO getCarById(Integer id) {
        EsVehicleVO vehicleVo = null;
        try {
            GetRequest request = new GetRequest("uservehicle").id(id.toString());
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            String carJson = response.getSourceAsString();
            EsVehicle vehicle = objectMapper.readValue(carJson, EsVehicle.class);
            Integer userId = vehicle.getUserId();
            EsUserInfo userInfo = esUserInfoService.getUserInfoById(userId);
            vehicleVo = new EsVehicleVO(vehicle);
            vehicleVo.setUserName(userInfo.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicleVo;
    }

    private void buildBoolQuery(CarQuery carQuery, SearchRequest searchRequest) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(carQuery.getName())){
            boolQuery.must(QueryBuilders.matchQuery("all", carQuery.getName()));
        }
        if (!StringUtils.isEmpty(carQuery.getColo())){
            boolQuery.must(QueryBuilders.matchQuery("all", carQuery.getColo()));
        }
        if (!StringUtils.isEmpty(carQuery.getLicensePlate())){
            boolQuery.must(QueryBuilders.termQuery("licensePlate", carQuery.getLicensePlate()));
        }
        if (!StringUtils.isEmpty(carQuery.getUserId())){
            boolQuery.must(QueryBuilders.termQuery("userId", carQuery.getUserId()));
        }
        if (!ObjectUtils.isEmpty(carQuery.getBeginDate())&&!ObjectUtils.isEmpty(carQuery.getEndDate())){
            //System.out.println(userInfo.getBeginDate().toString());
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .gte(simpleDateFormat.format(carQuery.getBeginDate()))
                    .lte(simpleDateFormat.format(carQuery.getEndDate())));
        }else if (!ObjectUtils.isEmpty(carQuery.getBeginDate())&&ObjectUtils.isEmpty(carQuery.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .gte(simpleDateFormat.format(carQuery.getBeginDate())));
        }else if (ObjectUtils.isEmpty(carQuery.getBeginDate())&&!ObjectUtils.isEmpty(carQuery.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .lte(simpleDateFormat.format(carQuery.getEndDate())));
        }
        searchRequest.source().query(boolQuery);
    }

    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<EsVehicleVO> carInfoList = new ArrayList<>();
        for (SearchHit hit :hitsArray
        ) {
            /*获取json字符串*/
            String userinfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsVehicle esVehicle = objectMapper.readValue(userinfoJson, EsVehicle.class);
            /*根据user_id查找名称*/
            /*-----------------------*/
            Integer userId = esVehicle.getUserId();
            EsUserInfo userInfoById = esUserInfoService.getUserInfoById(userId);
            /*封装*/
            /*---------------------*/
            EsVehicleVO vehicle = new EsVehicleVO(esVehicle);
            vehicle.setUserName(userInfoById.getName());
            carInfoList.add(vehicle);
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("items",carInfoList);
        return resultMap;
    }
}
