package wyu.xwen.communityService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsDevice;
import wyu.xwen.communityService.entity.vo.DeviceQuery;
import wyu.xwen.communityService.entity.vo.DeviceVo;
import wyu.xwen.communityService.mapper.EsDeviceMapper;
import wyu.xwen.communityService.service.EsCommunityService;
import wyu.xwen.communityService.service.EsDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资产设备信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-27
 */
@Service
public class EsDeviceServiceImpl extends ServiceImpl<EsDeviceMapper, EsDevice> implements EsDeviceService {

    @Autowired
    private EsDeviceMapper esDeviceMapper;
    @Autowired
    private EsCommunityService esCommunityService;

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, DeviceQuery query) {
       /* IPage<EsDevice> devicePage = new Page<>(current, limit);

        QueryWrapper<EsDevice> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(query.getCommunityName())) {
            List<EsCommunity> communityList = esCommunityService.getListByName(query.getName());
            if (communityList.size() > 0) {
                String[] communityCodeArr = new String[communityList.size()];
                for (EsCommunity community : communityList) {
                    int i = 0;
                    communityCodeArr[i++] = community.getCode();
                }

                queryWrapper.in("community_code", communityCodeArr);
                *//*判断条件*//*
                if (query.getBeginDate()!=null) {
                    queryWrapper.ge("buy_time", query.getBeginDate());
                }
                if (query.getEndDate()!=null) {
                    queryWrapper.le("buy_time", query.getEndDate());
                }
                if (!StringUtils.isEmpty(query.getBrand())) {
                    queryWrapper.eq("brand", query.getBrand());
                }
                if (!StringUtils.isEmpty(query.getName())) {
                    queryWrapper.eq("name", query.getName());
                }

            }

        } else {
            *//*判断条件*//*
            if (query.getBeginDate()!=null) {
                queryWrapper.ge("buy_time", query.getBeginDate());
            }
            if (query.getEndDate()!=null) {
                queryWrapper.le("buy_time", query.getEndDate());
            }
            if (!StringUtils.isEmpty(query.getBrand())) {
                queryWrapper.eq("brand", query.getBrand());
            }
            if (!StringUtils.isEmpty(query.getName())) {
                queryWrapper.eq("name", query.getName());
            }
        }*/
        current = (current-1)*limit;
        List<DeviceVo> deviceVos = esDeviceMapper.pageList(current, limit, query);
        Integer integer = esDeviceMapper.selectTotal();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", integer);
        resultMap.put("items", deviceVos);
        return resultMap;
    }
}
