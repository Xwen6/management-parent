package wyu.xwen.communityService.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsExpensesProject;
import wyu.xwen.communityService.entity.vo.ExpenseProjectQuery;
import wyu.xwen.communityService.service.EsExpensesProjectService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 收费项目信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-28
 */
@RestController
@RequestMapping("/communityService/expensesProject")
public class EsExpensesProjectController {

    @Autowired
    private EsExpensesProjectService esExpensesProjectService;

    @PostMapping("add")
    public Result addProject(@RequestBody EsExpensesProject esExpensesProject){
        String code = "EP" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        esExpensesProject.setCode(code);
        boolean success = esExpensesProjectService.save(esExpensesProject);
        return  success?Result.ok():Result.error();
    }

    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean success = esExpensesProjectService.removeById(id);
        return  success?Result.ok():Result.error();
    }

    @PostMapping("updateById")
    public Result updateById(@RequestBody EsExpensesProject esExpensesProject){
        boolean success = esExpensesProjectService.updateById(esExpensesProject);
        return success?Result.ok():Result.error();
    }

    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id){
        EsExpensesProject item = esExpensesProjectService.getById(id);
        return Result.ok().date("item",item);
    }

    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @PathVariable ExpenseProjectQuery query){


        Map<String,Object> resultMap = esExpensesProjectService.pageList(current,limit,query);
        return Result.ok().date("items",resultMap);
    }

}

