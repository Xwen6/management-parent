package wyu.xwen.userservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.userservice.entity.EsUsers;
import wyu.xwen.userservice.service.EsUsersService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-12
 */
@RestController
@RequestMapping("/userService/users")
public class EsUsersController {
    @Autowired
    private EsUsersService esUsersServiceImpl;

    @GetMapping("/getUserById/{openId}")
    public Result getUserById(@PathVariable() Integer openId){
        QueryWrapper<EsUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("openId",openId);
        EsUsers user = esUsersServiceImpl.getOne(wrapper);
        return Result.ok().data("user",user);
    }

    /*insert*/
    @PostMapping("/insert")
    public Result insertUser(@RequestBody EsUsers esUsers ){
        boolean save = esUsersServiceImpl.save(esUsers);
        return save?Result.ok():Result.error();
    }

    /*update*/
    @PostMapping("/Update")
    public Result updateById(@RequestBody EsUsers esUsers){
        UpdateWrapper<EsUsers> wrapper = new UpdateWrapper<>();
        wrapper.eq("openId",esUsers.getOpenid());
        boolean success = esUsersServiceImpl.update(wrapper);
        return success?Result.ok():Result.error();
    }

    /*没有条件的分页*/
    @GetMapping("/pageList/{page}/{limit}")
    public Result pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<EsUsers> pageParam = new Page<>(page, limit);
        esUsersServiceImpl.page(pageParam, null);
        List<EsUsers> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("items",records);
    }

    /*delete*/
    @DeleteMapping("delete/{openId}")
    public Result deleteById(@PathVariable String openId){
        QueryWrapper<EsUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("openId",openId);
        EsUsers user = esUsersServiceImpl.getOne(wrapper);
        user.setDeleteTime(new Date());
        boolean remove = esUsersServiceImpl.remove(wrapper);
        return remove?Result.ok():Result.error();
    }






    

}

