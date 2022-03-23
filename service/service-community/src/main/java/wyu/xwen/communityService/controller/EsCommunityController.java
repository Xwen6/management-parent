package wyu.xwen.communityService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;
import wyu.xwen.communityService.service.EsCommunityService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 小区信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@RestController
@RequestMapping("/communityService/Community")
public class EsCommunityController {

    @Autowired
    private EsCommunityService esCommunityService;


    @PostMapping("addCommunity")
    public Result addCommunity(@RequestBody EsCommunity community){
        boolean success =  esCommunityService.addCommunity(community);
        return success?Result.ok():Result.error();
    }


    @GetMapping("getCommunityById/{id}")
    public Result getById(@PathVariable Integer id){
        EsCommunity item = esCommunityService.getById(id);
        if (ObjectUtils.isEmpty(item)) {
            throw new RuntimeException("该用户不存在");
        }

        return Result.ok().data("item",item);
    }

    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
       boolean success =  esCommunityService.deleteById(id);
        return success?Result.ok():Result.error();
    }

    @GetMapping("getByCCode/{code}")
    public Result getByCCode(@PathVariable String code){
        EsCommunity community = esCommunityService.getByCCode(code);
        return Result.ok().data("item",community);
    }

    @PostMapping("update")
    public Result update(@RequestBody EsCommunity esCommunity){
        boolean success =  esCommunityService.updateCommunity(esCommunity);
        return success?Result.ok():Result.error();
    }



    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) QueryCondition queryCondition){
        Map<String,Object> resultMap = esCommunityService.pageList(current,limit, queryCondition);
        return Result.ok().data(resultMap);

    }



    /*获取社区、楼栋列表*/
    @GetMapping("getCommunityAndBuildingList/{code}")
    public Result getList(@PathVariable String code){
        CommunityVo communities =  esCommunityService.getList(code);

        return Result.ok().data("items",communities);
    }


    @GetMapping("getCommunityList")
    public Result getCommunityList(){
        List<CommunityVo> list = esCommunityService.getCommunityList();
        return Result.ok().data("item",list);
    }



}

