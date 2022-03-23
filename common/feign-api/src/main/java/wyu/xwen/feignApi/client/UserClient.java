package wyu.xwen.feignApi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import wyu.xwen.commonutils.Result;
import wyu.xwen.feignApi.entity.EsUserInfo;

/**
 * @ClassName: UserClient
 * @Author: xcwen
 * @Create: 2022-03-23 19:28
 * @Version 1.0
 * @Description: TODO
 **/
@FeignClient(name = "userService",path = "userService")
public interface UserClient {
    /*新增userInfo*/
    @PostMapping("addUserInfo")
    Result addUserInfo(@RequestBody EsUserInfo userInfo);
}
