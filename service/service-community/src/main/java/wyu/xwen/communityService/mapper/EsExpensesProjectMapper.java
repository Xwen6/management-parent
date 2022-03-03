package wyu.xwen.communityService.mapper;

import org.apache.ibatis.annotations.Select;
import wyu.xwen.communityService.entity.EsExpensesProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wyu.xwen.communityService.entity.vo.ExpenseProjectQuery;

import java.util.List;

/**
 * <p>
 * 收费项目信息表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
public interface EsExpensesProjectMapper extends BaseMapper<EsExpensesProject> {

    List<EsExpensesProject> pageList(Integer current, Integer limit, ExpenseProjectQuery query);

    @Select("select count(1) from es_expenses_project where is_del = 0")
    Integer getTotal();
}
