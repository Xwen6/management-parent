package wyu.xwen.communityService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsExpensesProject;
import wyu.xwen.communityService.entity.vo.ExpenseProjectQuery;
import wyu.xwen.communityService.mapper.EsExpensesProjectMapper;
import wyu.xwen.communityService.service.EsCommunityService;
import wyu.xwen.communityService.service.EsExpensesProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费项目信息表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
@Service
public class EsExpensesProjectServiceImpl extends ServiceImpl<EsExpensesProjectMapper, EsExpensesProject> implements EsExpensesProjectService {

    @Autowired
    private EsCommunityService esCommunityService;

    @Override
    public Map<String, Object> pageList(Integer current, Integer limit, ExpenseProjectQuery query) {
        IPage<EsExpensesProject> page = new Page<>(current,limit);
        QueryWrapper<EsExpensesProject> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(query.getCommunityName())) {
            /*根据code模糊查询*/
            List<EsCommunity> communityList = esCommunityService.getListByName(query.getCommunityName());
            if (communityList.size()>0) {
                String codeArr[] = new String[communityList.size()];
                for (int i = 0; i < communityList.size(); i++) {
                    codeArr[i] = communityList.get(i).getCode();
                }

                wrapper.in("community_code",codeArr);
                /*判断条件*/
                if (query.getBeginDate()!=null) {
                    wrapper.ge("create_time", query.getBeginDate());
                }
                if (query.getEndDate()!=null) {
                    wrapper.le("create_time", query.getEndDate());
                }
                if (!StringUtils.isEmpty(query.getName())) {
                    wrapper.eq("name", query.getName());
                }
            }else {

                if (query.getBeginDate()!=null) {
                    wrapper.ge("create_time", query.getBeginDate());
                }
                if (query.getEndDate()!=null) {
                    wrapper.le("create_time", query.getEndDate());
                }
                if (!StringUtils.isEmpty(query.getName())) {
                    wrapper.eq("name", query.getName());
                }
            }
        }

        baseMapper.selectPage(page,wrapper);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",page.getTotal());
        resultMap.put("items",page.getRecords());
        return resultMap;
    }
}
