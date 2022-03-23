package wyu.xwen.communityService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsHouse;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.service.EsHouseService;

import java.util.Map;

/**
 * <p>
 * 房产信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/communityService/House")
public class EsHouseController {

    @Autowired
    private EsHouseService esHouseService;

    /*添加楼栋信息*/
    @PostMapping("addHouse")
    public Result addHouse(@RequestBody EsHouse house){
        boolean success = esHouseService.addHouse(house);
        return success?Result.ok():Result.error();
    }

    /*delete*/
    @DeleteMapping("deleteHouse/{code}")
    public Result deleteHouse(@PathVariable String code){
        boolean success = esHouseService.deleteHouseByCode(code);
        return success?Result.ok():Result.error();
    }

    /*update*/
    @PostMapping("updateHouse")
    public Result updateHouse(@RequestBody EsHouse house){
        boolean success = esHouseService.updateHouse(house);
        return success?Result.ok():Result.error();
    }

    /*pageList*/
    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) QueryCondition queryCondition){

        Map<String,Object> resultMap = esHouseService.pageList(current,limit, queryCondition);
        return Result.ok().data(resultMap);

    }

    @GetMapping("getHouseByCode/{code}")
    public Result getHouse(@PathVariable String code){
        EsHouse esHouse =  esHouseService.getHouseByCode(code);
        return Result.ok().data("item",esHouse);
    }

}

