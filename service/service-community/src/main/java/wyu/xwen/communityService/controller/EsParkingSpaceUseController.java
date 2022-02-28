package wyu.xwen.communityService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsParkingSpaceUse;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.service.EsParkingSpaceUseService;

import java.util.Map;

/**
 * <p>
 * 停车位使用记录表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
@RestController
@RequestMapping("/communityService/parkingSpaceUse")
public class EsParkingSpaceUseController {
    @Autowired
    private EsParkingSpaceUseService esParkingSpaceUseService;


    @PostMapping("add")
    public Result addParkingSpaceUse(@RequestBody EsParkingSpaceUse parkingSpaceUse){
        boolean success =  esParkingSpaceUseService.add(parkingSpaceUse);
        return success?Result.ok():Result.error();
    }

    @DeleteMapping("delete/{code}")
    public Result deleteParkingUser(@PathVariable Integer id){
        boolean success = esParkingSpaceUseService.deleteParkingUse(id);
        return success?Result.ok():Result.error();
    }

    @PostMapping("update")
    public Result updateParkingUse(@RequestBody EsParkingSpaceUse esParkingSpaceUse){
        boolean success =  esParkingSpaceUseService.updateParkingUse(esParkingSpaceUse);
        return success?Result.ok():Result.error();
    }

    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id){
        EsParkingSpaceUse esParkingSpaceUse = esParkingSpaceUseService.getParkingSpaceUseById(id);
        return Result.ok().date("item",esParkingSpaceUse);
    }


    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) QueryCondition queryCondition){
        Map<String,Object> resultMap = esParkingSpaceUseService.pageList(current,limit,queryCondition);
        return Result.ok().date("items",resultMap);
    }

}

