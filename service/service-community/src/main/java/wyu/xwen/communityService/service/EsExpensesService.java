package wyu.xwen.communityService.service;

import org.apache.ibatis.annotations.Select;
import wyu.xwen.communityService.entity.EsExpenses;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.entity.vo.ExpenseQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 费用信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
public interface EsExpensesService extends IService<EsExpenses> {


    Map<String, Object> pageList(Integer current, Integer limit, ExpenseQuery query);

    List<CommunityVo> getServiceList();
}
