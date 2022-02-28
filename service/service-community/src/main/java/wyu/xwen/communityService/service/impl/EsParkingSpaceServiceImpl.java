package wyu.xwen.communityService.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsParkingSpace;
import wyu.xwen.communityService.entity.vo.ParkingSpaceVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.mapper.EsParkingSpaceMapper;
import wyu.xwen.communityService.service.EsParkingSpaceService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 停车位基本信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
@Service
public class EsParkingSpaceServiceImpl extends ServiceImpl<EsParkingSpaceMapper, EsParkingSpace> implements EsParkingSpaceService {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean addPackingSpace(EsParkingSpace esParkingSpace) {
        esParkingSpace.setCode("PK"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        int insert = baseMapper.insert(esParkingSpace);
        try {
            EsParkingSpace parkingSpace = baseMapper.selectById(esParkingSpace);
            IndexRequest request = new IndexRequest("parking").id(parkingSpace.getId().toString());
            request.source(JSONObject.toJSONString(esParkingSpace), XContentType.JSON);
            client.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insert>0;
    }

    @Override
    public boolean changeStatus(Integer id, Integer status) {
        QueryWrapper<EsParkingSpace> wrapper = new QueryWrapper();
        wrapper.eq("status",status);
        EsParkingSpace parkingSpace = new EsParkingSpace();
        parkingSpace.setStatus(status);
        parkingSpace.setId(id);
        int update = baseMapper.updateById(parkingSpace);
        try {
            EsParkingSpace esParkingSpace = baseMapper.selectById(id);
            IndexRequest request = new IndexRequest("parking").id(id.toString());
            request.source(JSONObject.toJSONString(esParkingSpace),XContentType.JSON);
            client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return update>0;
    }

    @Override
    public boolean deletePackingSpace(String code) {
        QueryWrapper<EsParkingSpace> wrapper = new QueryWrapper<>();
        wrapper.eq("code",code);

        try {
            EsParkingSpace parkingSpace = baseMapper.selectOne(wrapper);
            DeleteRequest request = new DeleteRequest("parking").id(parkingSpace.getId().toString());
            client.delete(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baseMapper.delete(wrapper)>0;
    }

    @Override
    public boolean updateParking(EsParkingSpace esParkingSpace) {
        try {
            IndexRequest request = new IndexRequest("parking").id(esParkingSpace.getId().toString());
            request.source(JSONObject.toJSONString(esParkingSpace),XContentType.JSON);
            client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseMapper.updateById(esParkingSpace)>0;
    }

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, QueryCondition condition1) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            SearchRequest request = new SearchRequest("parking");
            request.source()
                    .query(QueryBuilders.matchAllQuery())
                    .from((current-1)*limit)
                    .size(limit);
            /*构建条件查询*/
            buildBoolQuery(condition1,request);
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            resultMap = handleResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @Override
    public EsParkingSpace getByCode(String code) {
        EsParkingSpace parkingSpace = null;
        try {
            SearchRequest request = new SearchRequest("parking");
            request.source().query(QueryBuilders.termQuery("code",code));
            SearchResponse search = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = search.getHits().getHits();
            if (hits.length>0) {
                parkingSpace = JSONObject.parseObject(hits[0].getSourceAsString(), EsParkingSpace.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parkingSpace;
    }

    private Map<String,Object> handleResponse(SearchResponse response) throws IOException {
        SearchHit[] hits = response.getHits().getHits();
        List<ParkingSpaceVo> parkingSpaceVos = new ArrayList<>();
        if (hits.length>0){
            for (SearchHit hit : hits) {
                EsParkingSpace parkingSpace = JSONObject.parseObject(hit.getSourceAsString(), EsParkingSpace.class);
                ParkingSpaceVo parkingSpaceVo = new ParkingSpaceVo();
                parkingSpaceVo.setCode(parkingSpace.getCode());
                parkingSpaceVo.setId(parkingSpace.getId());
                parkingSpaceVo.setStatus(parkingSpace.getStatus());
                parkingSpaceVo.setCreateTime(parkingSpace.getCreateTime());
                parkingSpaceVo.setName(parkingSpace.getName());
                SearchRequest searchRequest = new SearchRequest("community");
                searchRequest.source().query(QueryBuilders.termQuery("code",JSONObject.parseObject(hit.getSourceAsString()).getString("communityCode")));
                SearchHit[] searchHits = client.search(searchRequest, RequestOptions.DEFAULT).getHits().getHits();
                if (searchHits.length>0){
                    parkingSpaceVo.setCommunityName(JSONObject.parseObject(searchHits[0].getSourceAsString(), EsCommunity.class).getName());
                }

                parkingSpaceVos.add(parkingSpaceVo);
            }
        }
        Map<String,Object> result = new HashMap<>();
        result.put("total",response.getHits().getTotalHits().value);
        result.put("items",parkingSpaceVos);
        return result;
    }

    private void buildBoolQuery(QueryCondition queryCondition, SearchRequest searchRequest) throws IOException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1.准备Boolean查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        /*根据条件进行bool查询*/
        if (!StringUtils.isEmpty(queryCondition.getCondition())){
            SearchRequest request = new SearchRequest("community");
            request.source().query(QueryBuilders.matchQuery("name",queryCondition.getCondition()));
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            if (hits.length>0){
                for (SearchHit hit : hits) {
                    String code = JSONObject.parseObject(hit.getSourceAsString()).getString("code");
                    boolQuery.should(QueryBuilders.termQuery("communityCode",code));
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
