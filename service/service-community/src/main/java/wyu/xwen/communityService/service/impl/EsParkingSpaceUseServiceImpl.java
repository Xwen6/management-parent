package wyu.xwen.communityService.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsParkingSpace;
import wyu.xwen.communityService.entity.EsParkingSpaceUse;
import wyu.xwen.communityService.entity.vo.ParkingUseVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.mapper.EsParkingSpaceUseMapper;
import wyu.xwen.communityService.service.EsCommunityService;
import wyu.xwen.communityService.service.EsParkingSpaceService;
import wyu.xwen.communityService.service.EsParkingSpaceUseService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 停车位使用记录表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
@Service
public class EsParkingSpaceUseServiceImpl extends ServiceImpl<EsParkingSpaceUseMapper, EsParkingSpaceUse> implements EsParkingSpaceUseService {

    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private EsCommunityService esCommunityService;
    @Autowired
    private EsParkingSpaceService esParkingSpaceService;


    @Override
    public boolean add(EsParkingSpaceUse parkingSpaceUse) {
        int insert = baseMapper.insert(parkingSpaceUse);
        try {
            EsParkingSpaceUse esParkingSpaceUse = baseMapper.selectById(parkingSpaceUse);
            IndexRequest request = new IndexRequest("parkinguse").id(esParkingSpaceUse.getId().toString());
            request.source(JSONObject.toJSONString(esParkingSpaceUse), XContentType.JSON);
            client.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insert>0;
    }

    @Override
    public boolean deleteParkingUse(Integer id) {
        try {
            DeleteRequest request = new DeleteRequest("parkinguse").id(id.toString());
            client.delete(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseMapper.deleteById(id)>0;
    }

    @Override
    public boolean updateParkingUse(EsParkingSpaceUse esParkingSpaceUse) {
        int update = baseMapper.updateById(esParkingSpaceUse);
        try {
            IndexRequest request = new IndexRequest("parkinguse").id(esParkingSpaceUse.getId().toString());
            request.source(JSONObject.toJSONString(esParkingSpaceUse),XContentType.JSON);
            client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return update>0;
    }

    @Override
    public EsParkingSpaceUse getParkingSpaceUseById(Integer id) {
        EsParkingSpaceUse esParkingSpaceUse = null;
        try {
            GetRequest request = new GetRequest("parkinguse").id(id.toString());
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            esParkingSpaceUse = JSONObject.parseObject(response.getSourceAsString(), EsParkingSpaceUse.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return esParkingSpaceUse;
    }

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, QueryCondition condition) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            /*建立分页条件*/
            SearchRequest searchRequest = new SearchRequest("parkinguse");
            searchRequest.source()
                    .query(QueryBuilders.matchAllQuery())
                    .from((current-1)*limit)
                    .size(limit);
            /*根据条件查询*/
            buildBoolQuery(condition,searchRequest);
            SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
            resultMap = handleResponse(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    private void buildBoolQuery(QueryCondition condition, SearchRequest searchRequest) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*如果查询条件不为空*/
        if (!StringUtils.isEmpty(condition.getCondition())){
            /*判断是否根据社区名称、停车场名称查询*/
            SearchRequest request = new SearchRequest("parking", "community");
            request.source().query(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name",condition.getCondition())));
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            /*如果结果数组长度大于0，即根据社区名称、停车场名称查询*/
            if (hits.length!=0){
                for (SearchHit hit : hits) {
                    /*将查询到的code作为bool查询的条件添加*/
                    String sourceAsString = hit.getSourceAsString();
                    String code = JSONObject.parseObject(sourceAsString).getString("code");
                    boolQuery.should(QueryBuilders.matchQuery("pkCode",code));
                    boolQuery.should(QueryBuilders.matchQuery("communityCode",code));
                }
            }
            else {
                /*根据其他条件进行查询*/
                boolQuery.must(QueryBuilders.matchQuery("all", condition.getCondition()));
            }
        }
        /*时间段查询*/
        if (!ObjectUtils.isEmpty(condition.getBeginDate())&&!ObjectUtils.isEmpty(condition.getEndDate())){
            //System.out.println(userInfo.getBeginDate().toString());
            boolQuery.filter(QueryBuilders.rangeQuery("beginTime")
                    .gte(simpleDateFormat.format(condition.getBeginDate())));
            boolQuery.filter(QueryBuilders.rangeQuery("endTime")
                    .lte(simpleDateFormat.format(condition.getEndDate())));
        }else if (!ObjectUtils.isEmpty(condition.getBeginDate())&&ObjectUtils.isEmpty(condition.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("beginTime")
                    .gte(simpleDateFormat.format(condition.getBeginDate())));
        }else if (ObjectUtils.isEmpty(condition.getBeginDate())&&!ObjectUtils.isEmpty(condition.getEndDate())){
            boolQuery.filter(QueryBuilders.rangeQuery("endTime")
                    .lte(simpleDateFormat.format(condition.getEndDate())));
        }
        searchRequest.source().query(boolQuery);
    }

    /*处理条件查询结果*/
    private Map<String, Object> handleResponse(SearchResponse response) throws JsonProcessingException {
        /*处理response*/
        SearchHits hits = response.getHits();
        /*总条数*/
        TotalHits total = hits.getTotalHits();
        SearchHit[] hitsArray = hits.getHits();
        List<ParkingUseVo> parkingUseVos = new ArrayList<>();
        for (SearchHit hit :hitsArray
        ) {
            /*获取json字符串*/
            String petInfoJson = hit.getSourceAsString();
            /*反序列化*/
            EsParkingSpaceUse esParkingSpaceUse = JSONObject.parseObject(petInfoJson, EsParkingSpaceUse.class);
            ParkingUseVo parkingUseVo = new ParkingUseVo();
            parkingUseVo.setBeginTime(esParkingSpaceUse.getBeginTime());
            parkingUseVo.setEndTime(esParkingSpaceUse.getEndTime());
            parkingUseVo.setId(esParkingSpaceUse.getId());
            parkingUseVo.setCost(esParkingSpaceUse.getCost());
            parkingUseVo.setOwner(esParkingSpaceUse.getOwner());
            parkingUseVo.setLicenseName(esParkingSpaceUse.getLicensePlate());
            parkingUseVo.setTel(esParkingSpaceUse.getTel());
            parkingUseVo.setType(esParkingSpaceUse.getType());
            parkingUseVo.setCreateTime(esParkingSpaceUse.getCreateTime());
            EsCommunity community = esCommunityService.getByCCode(esParkingSpaceUse.getCommunityCode());
            EsParkingSpace parkingSpace = esParkingSpaceService.getByCode(esParkingSpaceUse.getPkCode());
            if (community!=null){
                parkingUseVo.setParkingName(community.getName());
            }
            if (parkingSpace != null) {
                parkingUseVo.setCommunityName(parkingSpace.getName());
            }

            parkingUseVos.add(parkingUseVo);
        }
        /*封装查询结果*/
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total.value);
        resultMap.put("items",parkingUseVos);
        return resultMap;
    }

}
