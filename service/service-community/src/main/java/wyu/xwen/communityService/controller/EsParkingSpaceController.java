package wyu.xwen.communityService.controller;


import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsParkingSpace;
import wyu.xwen.communityService.entity.vo.ParkingSpaceVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.service.EsParkingSpaceService;

import java.util.Map;

/**
 * <p>
 * 停车位基本信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
@RestController
@RequestMapping("/communityService/parkingSpace")
public class EsParkingSpaceController {

    @Autowired
    private EsParkingSpaceService esParkingSpaceService;

    @PostMapping("addParkingSpace")
    public Result addParkingSpace(@RequestBody EsParkingSpace esParkingSpace){
        boolean success =  esParkingSpaceService.addPackingSpace(esParkingSpace);
        return success?Result.ok():Result.error();
    }

    @DeleteMapping("deleteParkingSpace/{code}")
    public Result DeleteParkingSpace(@PathVariable String code){
        boolean success =  esParkingSpaceService.deletePackingSpace(code);
        return success?Result.ok():Result.error();
    }

    @PostMapping("updateParkingSpace")
    public Result updateParkingSpace(@RequestBody EsParkingSpace esParkingSpace){
        boolean success = esParkingSpaceService.updateParking(esParkingSpace);
        return success?Result.ok():Result.error();
    }

    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current, @PathVariable Integer limit, @RequestBody(required = false) QueryCondition condition){
        Map<String,Object> map = esParkingSpaceService.pageList(current,limit,condition);
        return Result.ok().date("items",map);
    }

    @GetMapping("getParkingSpaceByCode/{code}")
    public Result getByCode(@PathVariable String code ){
        EsParkingSpace parkingSpace = esParkingSpaceService.getByCode(code);
        return Result.ok().date("item",parkingSpace);
    }

    @PostMapping("changeStatus/{id}/{status}")
    public Result changeStatus(@PathVariable Integer id,@PathVariable Integer status ){
        boolean success = esParkingSpaceService.changeStatus(id,status);
        return success?Result.ok():Result.error();
    }
}

