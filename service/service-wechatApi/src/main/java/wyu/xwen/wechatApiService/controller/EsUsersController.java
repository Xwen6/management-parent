package wyu.xwen.wechatApiService.controller;


import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import wyu.xwen.commonutils.Result;
import wyu.xwen.wechatApiService.service.EsUsersService;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@RestController
@RequestMapping("wechatApiService/users")
@ComponentScan(value = "wyu.xwen")
@EnableSwagger2
public class EsUsersController {
    @Autowired
    private EsUsersService esUsersService;
    @Autowired
    private Cache<String,String> wxInfoCache;

    /*微信登录*/
    @PostMapping("getToken")
    public Result wxLogin(@RequestBody Map<String,Object> map) {
        String code = (String) (map.get("code"));

        String result = esUsersService.getToken(code);
        String token = wxInfoCache.get("token", key -> esUsersService.getToken(code));

        return Result.WX_ok().data("token",token);
    }

}

