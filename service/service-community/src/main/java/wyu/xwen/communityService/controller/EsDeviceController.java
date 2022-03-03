package wyu.xwen.communityService.controller;


import com.baomidou.mybatisplus.core.metadata.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wyu.xwen.commonutils.Result;
import wyu.xwen.communityService.entity.EsDevice;
import wyu.xwen.communityService.entity.vo.DeviceQuery;
import wyu.xwen.communityService.service.EsDeviceService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 资产设备信息表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-27
 */
@RestController
@RequestMapping("/communityService/device")
public class EsDeviceController {
    @Autowired
    private EsDeviceService esDeviceService;

    /*add*/
    @PostMapping("addDevice")
    public Result addDevice(@RequestBody EsDevice device){
        /*生成code*/
        String code ="DV" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        device.setCode(code);
        boolean save = esDeviceService.save(device);
        return save?Result.ok():Result.error();
    }

    /*delete*/
    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean success = esDeviceService.removeById(id);
        return success?Result.ok():Result.error();
    }

    @PostMapping("updateDevice")
    public Result updateDevice(@RequestBody EsDevice device){
        boolean success = esDeviceService.updateById(device);
        return success?Result.ok():Result.error();
    }

    @GetMapping("getById/{id}")
    public Result getByCode(@PathVariable String id){
        EsDevice device = esDeviceService.getById(id);
        return Result.ok().date("item",device);
    }

    @PostMapping("pageList/{current}/{limit}")
    public Result pageList(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) DeviceQuery query){
        Map<String,Object> resultMap = esDeviceService.pageList(current,limit,query);
        return Result.ok().date("items",resultMap);
    }
}

