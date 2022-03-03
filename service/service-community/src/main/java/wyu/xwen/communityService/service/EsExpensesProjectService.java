package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsExpensesProject;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.ExpenseProjectQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费项目信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
public interface EsExpensesProjectService extends IService<EsExpensesProject> {

    Map<String, Object> pageList(Integer current, Integer limit, ExpenseProjectQuery query);
    List<EsExpensesProject> getListByCommunityCode(String communityCode);
}
