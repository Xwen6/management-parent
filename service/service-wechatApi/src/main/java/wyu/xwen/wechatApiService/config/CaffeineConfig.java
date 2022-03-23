package wyu.xwen.wechatApiService.config;



import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName: CaffeineConfig
 * @Author: xcwen
 * @Create: 2022-03-23 17:10
 * @Version 1.0
 * @Description: TODO 咖啡因设置
 **/
@Configuration
public class CaffeineConfig {
    @Bean
    public Cache<String, String> wxInfoCache(){
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(10_000)
                .build();
    }

}
