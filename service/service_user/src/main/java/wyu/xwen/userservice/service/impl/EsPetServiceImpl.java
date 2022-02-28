package wyu.xwen.userservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.lucene.search.TotalHits;
import org.checkerframework.checker.units.qual.A;
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
import wyu.xwen.userservice.entity.EsPet;
import wyu.xwen.userservice.entity.EsUserInfo;
import wyu.xwen.userservice.entity.PetQuery;
import wyu.xwen.userservice.entity.UserInfoQuery;
import wyu.xwen.userservice.mapper.EsPetMapper;
import wyu.xwen.userservice.service.EsPetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 宠物信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-17
 */
@Service
public class EsPetServiceImpl extends ServiceImpl<EsPetMapper, EsPet> implements EsPetService {

    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public boolean addPet(EsPet esPet) {
        int insert = 0;
        try {
            /*持久化*/
            insert = baseMapper.insert(esPet);
            esPet = baseMapper.selectById(esPet.getId());

            IndexRequest userPetRequest = new IndexRequest("userpet").id(esPet.getId().toString());
            userPetRequest.source(objectMapper.writeValueAsString(esPet), XContentType.JSON);
            client.index(userPetRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert>0;
    }

    @Override
    public boolean deletePet(Integer id) {
        int i = 0;
        try {

            DeleteRequest userPetRequest = new DeleteRequest("userpet").id(id.toString());
            client.delete(userPetRequest,RequestOptions.DEFAULT);
            i = baseMapper.deleteById(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return i>0;
    }

    @Override
    public boolean batchDelete(Integer[] ids) {
        int i = 0;
        try {
            for (Integer id:ids
                 ) {
                DeleteRequest userPetRequest = new DeleteRequest("userpet").id(id.toString());
                client.delete(userPetRequest,RequestOptions.DEFAULT);
            }

            i = baseMapper.deleteBatchIds(Arrays.asList(ids));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return i == ids.length;
    }

    @Override
    public boolean updatePet(EsPet pet) {
        int update = 0;
        try {
            update = baseMapper.updateById(pet);
            pet = baseMapper.selectById(pet);
            IndexRequest userPetRequest = new IndexRequest("userpet").id(pet.getId().toString());
            userPetRequest.source(objectMapper.writeValueAsString(pet),XContentType.JSON);
            client.index(userPetRequest,RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update>0;
    }

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, PetQuery petQuery) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            SearchRequest searchRequest = new SearchRequest("userpet");
            searchRequest.source()
                    .query(QueryBuilders.matchAllQuery())
                    .from((current-1)*limit)
                    .size(limit);
            if (ObjectUtils.isEmpty(petQuery)) {
                SearchResponse response = client.search(searchRequest,RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }else {
                buildBoolQuery(petQuery,searchRequest);
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                resultMap = handleResponse(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @Override
    public EsPet etPetById(Integer id) {
        EsPet p = null;
        try {
            GetRequest request = new GetRequest("userpet").id(id.toString());
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            String petJson = response.getSourceAsString();
            p = objectMapper.readValue(petJson, EsPet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return p;
    }

    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<EsPet> petInfoList = new ArrayList<>();
        for (SearchHit hit :hitsArray
        ) {
            /*获取json字符串*/
            String petInfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsPet esPet = objectMapper.readValue(petInfoJson, EsPet.class);
            /*根据userid查找名称*/
            /*-----------------------*/
            /*封装*/
            /*---------------------*/
            petInfoList.add(esPet);
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("petInfoList",petInfoList);
        return resultMap;
    }

    private void buildBoolQuery(PetQuery petQuery, SearchRequest searchRequest) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(petQuery.getCondition())){
            boolQuery.must(QueryBuilders.matchQuery("all", petQuery.getCondition()));
        }
        if (!ObjectUtils.isEmpty(petQuery.getBeginDate())&&!ObjectUtils.isEmpty(petQuery.getEndDate())){

            //System.out.println(userInfo.getBeginDate().toString());
            boolQuery.filter(QueryBuilders.rangeQuery("a")
                    .gte(simpleDateFormat.format(petQuery.getBeginDate()))
                    .lte(simpleDateFormat.format(petQuery.getEndDate())));
        }else if (!ObjectUtils.isEmpty(petQuery.getBeginDate())&&ObjectUtils.isEmpty(petQuery.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("adoptTime")
                    .gte(simpleDateFormat.format(petQuery.getBeginDate())));
        }else if (ObjectUtils.isEmpty(petQuery.getBeginDate())&&!ObjectUtils.isEmpty(petQuery.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("adoptTime")
                    .lte(simpleDateFormat.format(petQuery.getEndDate())));
        }
        searchRequest.source().query(boolQuery);
    }

}
