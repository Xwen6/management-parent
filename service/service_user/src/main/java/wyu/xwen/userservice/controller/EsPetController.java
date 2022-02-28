package wyu.xwen.userservice.controller;


import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.userservice.entity.EsPet;
import wyu.xwen.userservice.entity.EsUserInfo;
import wyu.xwen.userservice.entity.PetQuery;
import wyu.xwen.userservice.service.EsPetService;

import java.util.Map;

/**
 * <p>
 * 宠物信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/userService/Pet")
public class EsPetController {

    @Autowired
    private EsPetService esPetService;

    /*添加宠物*/
    @PutMapping("addPet")
    public Result AddPet(@RequestBody EsPet esPet){
        boolean success =  esPetService.addPet(esPet);
        return success?Result.ok():Result.error();
    }

    /*Delete*/
    @DeleteMapping("delete/{id}")
    public Result deletePet(@PathVariable Integer id){
        boolean success = esPetService.deletePet(id);
        return success?Result.ok():Result.error();
    }

    /*batchDelete*/
    @DeleteMapping("batchDelete")
    private Result batchDelete(@RequestParam Integer[] ids){
        boolean success=  esPetService.batchDelete(ids);
        return success?Result.ok():Result.error();
    }

    /*update*/
    @PostMapping("update")
    public Result delete(@RequestBody EsPet pet){
        boolean success = esPetService.updatePet(pet);
        return success?Result.ok():Result.error();
    }

    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false)PetQuery petQuery){
        Map<String,Object> resultMap = esPetService.pageList(current,limit,petQuery);
        return Result.ok().date(resultMap);

    }

    @GetMapping("getPetById/{id}")
    public Result GetPetById(@PathVariable Integer id ){
        EsPet pet =  esPetService.etPetById(id);
        return Result.ok().date("item",pet);
    }

}

