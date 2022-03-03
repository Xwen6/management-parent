package wyu.xwen.communityService.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsExpenses;
import wyu.xwen.communityService.entity.EsExpensesProject;
import wyu.xwen.communityService.entity.EsHouse;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.entity.vo.ExpenseQuery;
import wyu.xwen.communityService.entity.vo.ExpenseVo;
import wyu.xwen.communityService.mapper.EsExpensesMapper;
import wyu.xwen.communityService.service.EsCommunityService;
import wyu.xwen.communityService.service.EsExpensesProjectService;
import wyu.xwen.communityService.service.EsExpensesService;
import wyu.xwen.communityService.service.EsHouseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 费用信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
@Service
public class EsExpensesServiceImpl extends ServiceImpl<EsExpensesMapper, EsExpenses> implements EsExpensesService {

    @Autowired
    private EsExpensesMapper esExpensesMapper;
    @Autowired
    private EsCommunityService esCommunityService;
    @Autowired
    private EsHouseService esHouseService;
    @Autowired
    private EsExpensesProjectService esExpensesProjectService;


    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, ExpenseQuery query) {
        current = (current-1)*limit;
        Integer total =  esExpensesMapper.getTotal();
        List<ExpenseVo> list =  esExpensesMapper.pageList(current,limit,query);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("items",list);
        return resultMap;
    }

    @Override
    public List<CommunityVo> getServiceList() {
        List<EsCommunity> communityServiceList = esCommunityService.getList();
        List<CommunityVo> communityVoList = new ArrayList<>();
        if (communityServiceList.size()>0){
            for (EsCommunity community : communityServiceList) {
                List<EsHouse> houseList = esHouseService.selectListByCommunityCode(community.getCode());
                List<EsExpensesProject> expensesProjectList = esExpensesProjectService.getListByCommunityCode(community.getCode());
                CommunityVo communityVo = new CommunityVo();
                communityVo.setId(community.getId());
                communityVo.setName(community.getName());
                communityVo.setCode(community.getCode());
                communityVo.setHouseVoList(houseList);
                communityVo.setExpensesProjectList(expensesProjectList);
                communityVoList.add(communityVo);
            }
        }
        return communityVoList;
    }
}
