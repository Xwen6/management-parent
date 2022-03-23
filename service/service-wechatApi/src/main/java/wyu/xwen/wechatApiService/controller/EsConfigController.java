package wyu.xwen.wechatApiService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wyu.xwen.commonutils.Result;
import wyu.xwen.wechatApiService.entity.EsConfig;
import wyu.xwen.wechatApiService.service.EsConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统配置 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@RestController
@RequestMapping("/wechatApiService/Config")
public class EsConfigController {
   @Autowired
   private EsConfigService esConfigService;

   @GetMapping("getSystemConfig")
   public Result getSystemConfig(){
       List<EsConfig> list = esConfigService.getSystemConfig();
       Map<String,String> resultMap = new HashMap<>();
       list.forEach(esConfig -> {
           resultMap.put(esConfig.getName(),esConfig.getValue());
       });
       return resultMap.size()>0?Result.WX_ok().data("data",resultMap):Result.WX_error();
   }
}

