package wyu.xwen.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
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
import wyu.xwen.userservice.entity.EsUserInfo;
import wyu.xwen.userservice.entity.UserInfoQuery;
import wyu.xwen.userservice.mapper.EsUserInfoMapper;
import wyu.xwen.userservice.service.EsUserInfoService;
import wyu.xwen.userservice.service.EsVehicleService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@Service
public class EsUserInfoServiceImpl extends ServiceImpl<EsUserInfoMapper, EsUserInfo> implements EsUserInfoService {
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EsVehicleService esVehicleService;



    @Override
    public boolean addUserInfo(EsUserInfo userInfo) {
        int insert = 0;
        try {
            /*存入数据库*/
            insert = baseMapper.insert(userInfo);
            EsUserInfo esUserInfo = baseMapper.selectById(userInfo.getId());

            /*同步到es*/
            IndexRequest request = new IndexRequest("userinfo").id(esUserInfo.getId().toString());

            String userinfoJson = objectMapper.writeValueAsString(esUserInfo);
            request.source(userinfoJson, XContentType.JSON);
            client.index(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0 < insert;
    }

    @Override
    public boolean updateUserInfo(EsUserInfo userInfo) {

        int insert = 0;
        try {
            /*存入数据库*/
            insert = baseMapper.updateById(userInfo);
            /*同步到es*/
            userInfo = baseMapper.selectById(userInfo.getId());
            IndexRequest request = new IndexRequest("userinfo").id(userInfo.getId().toString());

            String userinfoJson = objectMapper.writeValueAsString(userInfo);
            request.source(userinfoJson, XContentType.JSON);
            client.index(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0 < insert;
    }

    @Override
    public boolean deleteUserInfo(Integer id) {
        int i = 0;
        try {
            /*删除用户信息*/
            EsUserInfo esUserInfo = baseMapper.selectById(id);
            if (null!=esUserInfo.getVehicleId()){
                /*删除车辆信息*/
                /*消息队列通知删除*/
                esVehicleService.removeById(esUserInfo.getVehicleId());
                DeleteRequest userVehicleRequest = new DeleteRequest("uservehicle").id(esUserInfo.getVehicleId().toString());
                client.delete(userVehicleRequest,RequestOptions.DEFAULT);
            }

            DeleteRequest userInfoRequest = new DeleteRequest("userinfo").id(id.toString());
            client.delete(userInfoRequest,RequestOptions.DEFAULT);

            i = baseMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i>0;
    }

    /*分页条件查询*/
    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, UserInfoQuery userInfo) {

        Map<String,Object> resultMap = null;
        try {
            /*准备查询的request*/
            SearchRequest searchRequest = new SearchRequest("userinfo");
            searchRequest.source()
                    .query(QueryBuilders.matchAllQuery())
                    .from((current-1)*limit)
                    .size(limit);
            /*判断查询条件*/
            if (ObjectUtils.isEmpty(userInfo)){

                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }else {
               // System.out.println(userInfo.getBeginDate().toString());
                //SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                buildBoolQuery(userInfo, searchRequest);
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

    private void buildBoolQuery(UserInfoQuery userInfo, SearchRequest searchRequest) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(userInfo.getName())){
            boolQuery.must(QueryBuilders.matchQuery("all", userInfo.getName()));
        }
        if (!StringUtils.isEmpty(userInfo.getIdentityId())){
            boolQuery.must(QueryBuilders.termQuery("identityId", userInfo.getIdentityId()));
        }
        if (!StringUtils.isEmpty(userInfo.getJob())){
            boolQuery.must(QueryBuilders.matchQuery("all", userInfo.getJob()));
        }
        if (!StringUtils.isEmpty(userInfo.getHouseCode())){
            boolQuery.filter(QueryBuilders.termQuery("houseCode", userInfo.getHouseCode()));
        }
        if (!StringUtils.isEmpty(userInfo.getPhone())){
            boolQuery.must(QueryBuilders.termQuery("phone", userInfo.getPhone()));
        }
        if (!ObjectUtils.isEmpty(userInfo.getBeginDate())&&!ObjectUtils.isEmpty(userInfo.getEndDate())){

            //System.out.println(userInfo.getBeginDate().toString());
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .gte(simpleDateFormat.format(userInfo.getBeginDate()))
                    .lte(simpleDateFormat.format(userInfo.getEndDate())));
        }else if (!ObjectUtils.isEmpty(userInfo.getBeginDate())&&ObjectUtils.isEmpty(userInfo.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .gte(simpleDateFormat.format(userInfo.getBeginDate())));
        }else if (ObjectUtils.isEmpty(userInfo.getBeginDate())&&!ObjectUtils.isEmpty(userInfo.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("createTime")
                    .lte(simpleDateFormat.format(userInfo.getEndDate())));
        }
        searchRequest.source().query(boolQuery);
    }


    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<EsUserInfo> userInfoList = new ArrayList<>();
        for (SearchHit hit :hitsArray
                ) {
            /*获取json字符串*/
            String userinfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsUserInfo esUserInfo = objectMapper.readValue(userinfoJson, EsUserInfo.class);
            /*根据社区id和房产id查找名称*/
            /*-----------------------*/
            /*封装*/
            /*---------------------*/
            userInfoList.add(esUserInfo);
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("items",userInfoList);
        return resultMap;
    }

    @Override
    public boolean batchDelete(List<Integer> ids) {

        try {
            for (Integer id:ids
                 ) {
                EsUserInfo esUserInfo = baseMapper.selectById(id);
                if (null!=esUserInfo.getVehicleId()){
                    /*删除车辆信息*/
                    esVehicleService.removeById(esUserInfo.getVehicleId());
                    DeleteRequest userVehicleRequest = new DeleteRequest("uservehicle").id(esUserInfo.getVehicleId().toString());
                    client.delete(userVehicleRequest,RequestOptions.DEFAULT);
                }
                DeleteRequest userInfoRequest = new DeleteRequest("userinfo").id(id.toString());
                client.delete(userInfoRequest,RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*删除用户信息*/
        return baseMapper.deleteBatchIds(ids)==ids.size();
    }

    @Override
    public EsUserInfo getUserInfoById(Integer id) {
        EsUserInfo userInfo = null;
        try {
            GetRequest request = new GetRequest("userinfo", id.toString());
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            String userInfoJson = response.getSourceAsString();
            userInfo = objectMapper.readValue(userInfoJson, EsUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

 /*   @Override
    public boolean updateVehicleId(Integer id, Integer vehicleId) {
        int i = 0;
        try {
            EsUserInfo userInfo = baseMapper.selectById(id);
            userInfo.setVehicleId(vehicleId);
            i = baseMapper.updateById(userInfo);
            IndexRequest request = new IndexRequest("userinfo").id(userInfo.getId().toString());
            String userinfoJson = objectMapper.writeValueAsString(userInfo);
            request.source(userinfoJson, XContentType.JSON);
            client.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return i>0;
    }*/
}
