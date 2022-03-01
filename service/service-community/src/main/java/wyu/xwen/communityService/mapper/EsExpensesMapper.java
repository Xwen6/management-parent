package wyu.xwen.communityService.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wyu.xwen.communityService.entity.EsExpenses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wyu.xwen.communityService.entity.vo.ExpenseQuery;
import wyu.xwen.communityService.entity.vo.ExpenseVo;

import java.util.List;

/**
 * <p>
 * 费用信息表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
@Mapper
public interface EsExpensesMapper extends BaseMapper<EsExpenses> {

    List<ExpenseVo> pageList(Integer current, Integer limit, ExpenseQuery query);

    @Select("select count(1) from es_expenses ")
    Integer getTotal();
}
