package wyu.xwen.wechatApiService.service;

import wyu.xwen.wechatApiService.entity.EsUsers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
public interface EsUsersService extends IService<EsUsers> {

    String getToken(String code);
}
