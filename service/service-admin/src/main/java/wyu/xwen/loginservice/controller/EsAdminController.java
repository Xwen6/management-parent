package wyu.xwen.loginservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.loginservice.service.EsAdminService;

import java.util.Map;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/loginService/")
public class EsAdminController {

    @Autowired
    private EsAdminService esAdminService;

    /*login*/
    @PostMapping("login")
    public Result login(@RequestBody Map<String,String> data){
       String token =  esAdminService.login(data);
        return Result.ok().data("token",token);
    }

    /*info*/
    @GetMapping("info")
    public Result info(){
        return Result.ok()
                .data("roles","[admin]").data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}

