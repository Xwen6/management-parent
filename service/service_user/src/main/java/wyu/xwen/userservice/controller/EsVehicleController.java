package wyu.xwen.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.userservice.entity.CarQuery;
import wyu.xwen.userservice.entity.EsVehicle;
import wyu.xwen.userservice.entity.EsVehicleVO;
import wyu.xwen.userservice.service.EsVehicleService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@RestController
@RequestMapping("/userService/Car")
public class EsVehicleController {

    @Autowired
    private EsVehicleService esVehicleService;


    /*addCar*/
    @PutMapping("addCar")
    public Result AddCar(@RequestBody EsVehicle vehicle){
        boolean success = esVehicleService.addCar(vehicle);
        return Result.ok();
    }

    @PostMapping("update")
    public Result updateCarInfo(@RequestBody EsVehicle vehicle){
        boolean success = esVehicleService.updateCarInfo(vehicle);
        return success?Result.ok():Result.error();
    }

    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean success = esVehicleService.deleteById(id);
        return success?Result.ok():Result.error();
    }

    @DeleteMapping("batchDelete")
    public Result batchDelete(@RequestParam Integer[] ids){
        List<Integer> idList = Arrays.asList(ids);
        boolean success =  esVehicleService.batchDelete(idList);
        return success?Result.ok():Result.error();
    }

    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit, @RequestBody(required = false)CarQuery carQuery){

        Map<String,Object> resultMap = esVehicleService.pageList(current,limit,carQuery);
        return Result.ok().data(resultMap);
    }

    /*getById*/
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id){
        EsVehicleVO vehicle =  esVehicleService.getCarById(id);
        return Result.ok().data("item",vehicle);
    }


}

