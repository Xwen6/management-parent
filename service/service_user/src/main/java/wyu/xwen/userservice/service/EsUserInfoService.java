package wyu.xwen.userservice.service;

import io.swagger.models.auth.In;
import wyu.xwen.userservice.entity.EsUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.userservice.entity.UserInfoQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
public interface EsUserInfoService extends IService<EsUserInfo> {

    boolean addUserInfo(EsUserInfo userInfo);

    boolean updateUserInfo(EsUserInfo userInfo);

    boolean deleteUserInfo(Integer id);

    Map<String, Object> pageList(Integer current, Integer limit, UserInfoQuery userInfo);

    boolean batchDelete(List<Integer> ids);

    EsUserInfo getUserInfoById(Integer id);

   // boolean updateVehicleId(Integer id, Integer vehicleId);
}
