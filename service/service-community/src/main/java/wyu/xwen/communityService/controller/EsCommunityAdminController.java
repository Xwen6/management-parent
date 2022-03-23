package wyu.xwen.communityService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.service.EsCommunityAdminService;

import java.util.List;

/**
 * <p>
 * 小区管理员关系表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@RestController
@RequestMapping("/communityService/CommunityAdmin")
public class EsCommunityAdminController {

    @Autowired
    private EsCommunityAdminService esCommunityAdminService;

    /*根据管理员id获取管理的小区列表*/
    @GetMapping("getCCodeByAId/{adminId}")
    public Result getCCode(@PathVariable Integer adminId ){
        /*根据adminId获取管理的小区列表*/
        List<CommunityVo> list = esCommunityAdminService.getList(adminId);
        return Result.ok().data("items",list);
    }


}

