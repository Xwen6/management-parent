package wyu.xwen.communityService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsBuilding;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.service.EsBuildingService;

import java.util.Map;

/**
 * <p>
 * 栋数信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@RestController
@RequestMapping("/communityService/building")
public class EsBuildingController {
    @Autowired
    private EsBuildingService esBuildingService;


    /*添加楼栋信息*/
    @PostMapping("addBuilding")
    public Result addBuilding(@RequestBody EsBuilding esBuilding){
        boolean success = esBuildingService.addBuilding(esBuilding);
        return success?Result.ok():Result.error();
    }

    /*delete*/
    @DeleteMapping("deleteBuilding/{code}")
    public Result deleteBuilding(@PathVariable String code){
        boolean success = esBuildingService.deleteBuildingByCode(code);
        return success?Result.ok():Result.error();
    }

    /*update*/
    @PostMapping("updateBuilding")
    public Result updateBuilding(@RequestBody EsBuilding building){
        boolean success = esBuildingService.updateBuilding(building);
        return success?Result.ok():Result.error();
    }

    /*pageList*/
    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) QueryCondition queryCondition){

        Map<String,Object> resultMap = esBuildingService.pageList(current,limit, queryCondition);
        return Result.ok().data(resultMap);

    }

    /*getOne*/
    @GetMapping("getBuildingByCode/{code}")
    public Result getBuilding(@PathVariable String code){
        EsBuilding building =  esBuildingService.getBuildingByCode(code);
        return Result.ok().data("item",building);
    }

}

