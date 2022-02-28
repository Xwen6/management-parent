package wyu.xwen.userservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wyu.xwen.commonutils.Result;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/userService/")
public class EsAdminController {

    /*login*/
    @PostMapping("login")
    public Result login(){
        return Result.ok().date("token","admin");
    }

    /*info*/
    @GetMapping("info")
    public Result info(){
        return Result.ok()
                .date("roles","[admin]").date("name","admin")
                .date("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}

