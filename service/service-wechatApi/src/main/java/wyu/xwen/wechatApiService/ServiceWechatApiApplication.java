package wyu.xwen.wechatApiService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import wyu.xwen.feignApi.client.UserClient;

@SpringBootApplication
@MapperScan(value = "wyu.xwen.wechatApiService.mapper")
@EnableCaching
@EnableFeignClients(clients = {UserClient.class})
public class ServiceWechatApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceWechatApiApplication.class, args);
    }

}
