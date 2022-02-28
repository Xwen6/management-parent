package wyu.xwen.loginservice.service;

import wyu.xwen.loginservice.entity.EsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-21
 */
public interface EsAdminService extends IService<EsAdmin> {

    String login(Map<String,String> data);
}
