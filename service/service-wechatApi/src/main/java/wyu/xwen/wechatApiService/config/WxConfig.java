package wyu.xwen.wechatApiService.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WxConfig
 * @Author: xcwen
 * @Create: 2022-03-23 13:48
 * @Version 1.0
 * @Description: TODO 微信配置类
 **/

@Component
@ConfigurationProperties(prefix = "wx")
public class WxConfig {
    public final static String App_Id ="/";
    public final static String App_Secret = "/";
}
