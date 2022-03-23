package wyu.xwen.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.userservice.entity.EsUserInfo;
import wyu.xwen.userservice.entity.UserInfoQuery;
import wyu.xwen.userservice.service.EsUserInfoService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@RestController
@RequestMapping("/userService/userInfo")
public class EsUserInfoController {

    @Autowired
    private EsUserInfoService esUserInfoService;


    /*新增userInfo*/
    @PostMapping("addUserInfo")
    public Result addUserInfo(@RequestBody EsUserInfo userInfo){
        boolean success = esUserInfoService.addUserInfo(userInfo);
        return success? Result.ok():Result.error();
    }

    /*修改info*/
    @PostMapping("updateUserInfo/")
    public Result updateUserInfo(@RequestBody EsUserInfo userInfo){
         boolean success =  esUserInfoService.updateUserInfo(userInfo);

        return success?Result.ok():Result.error();
    }

    /*delete*/
    @DeleteMapping("deleteUserInfo/{id}")
    public Result deleteUserInfo(@PathVariable Integer id){
        boolean success =  esUserInfoService.deleteUserInfo(id);
        return success?Result.ok():Result.error();
    }

    @DeleteMapping("batchDelete")
    public Result batchDelete(@RequestParam Integer[] ids){
        List<Integer> idList = Arrays.asList(ids);
        boolean success =  esUserInfoService.batchDelete(idList);
        return success?Result.ok():Result.error();
    }

    /*pageList*/
    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) UserInfoQuery userInfoQuery){

       Map<String,Object> resultMap =  esUserInfoService.pageList(current,limit,userInfoQuery);

        return Result.ok().data(resultMap);
    }

    @GetMapping("getUserInfoById/{id}")
    public Result GetUserInfoById(@PathVariable Integer id ){
        EsUserInfo userInfo =  esUserInfoService.getUserInfoById(id);
        return Result.ok().data("item",userInfo);
    }




}

