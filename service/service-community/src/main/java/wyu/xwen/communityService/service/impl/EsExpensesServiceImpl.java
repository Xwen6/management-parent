package wyu.xwen.communityService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import wyu.xwen.communityService.entity.EsExpenses;
import wyu.xwen.communityService.entity.vo.ExpenseQuery;
import wyu.xwen.communityService.entity.vo.ExpenseVo;
import wyu.xwen.communityService.mapper.EsExpensesMapper;
import wyu.xwen.communityService.service.EsExpensesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
