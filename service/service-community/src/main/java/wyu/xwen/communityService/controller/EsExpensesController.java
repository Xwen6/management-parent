package wyu.xwen.communityService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsExpenses;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.entity.vo.ExpenseQuery;
import wyu.xwen.communityService.service.EsExpensesService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 费用信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
@RestController
@RequestMapping("/communityService/Expenses")
public class EsExpensesController {

    @Autowired
    private EsExpensesService esExpensesService;

    @PostMapping("add")
    public Result addExpend(@RequestBody EsExpenses expenses){
        boolean save = esExpensesService.save(expenses);
        return save?Result.ok():Result.error();
    }

    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean success = esExpensesService.removeById(id);
        return success?Result.ok():Result.error();
    }

    @PostMapping("update")
    public Result updateExpense(@RequestBody EsExpenses expenses){
        boolean success = esExpensesService.updateById(expenses);
        return success?Result.ok():Result.error();
    }

    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id){
        EsExpenses expenses = esExpensesService.getById(id);
        return Result.ok().date("item",expenses);
    }

    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) ExpenseQuery query){
        Map<String,Object> resultMap = esExpensesService.pageList(current,limit,query);
        return Result.ok().date("items",resultMap);
    }

    @GetMapping("getSelectList")
    public Result getSelectList(){
        List<CommunityVo> list =  esExpensesService.getServiceList();
        return Result.ok().date("items",list);
    }

}

