package wyu.xwen.wechatApiService.service;

import wyu.xwen.wechatApiService.entity.EsConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统配置 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
public interface EsConfigService extends IService<EsConfig> {

    List<EsConfig> getSystemConfig();
}
