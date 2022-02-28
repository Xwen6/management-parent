package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsParkingSpace;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.ParkingSpaceVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;

import java.util.Map;

/**
 * <p>
 * 停车位基本信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
public interface EsParkingSpaceService extends IService<EsParkingSpace> {

    boolean addPackingSpace(EsParkingSpace esParkingSpace);

    boolean deletePackingSpace(String code);

    boolean updateParking(EsParkingSpace esParkingSpace);

    Map<String, Object> pageList(Integer current, Integer limit, QueryCondition condition1);

    EsParkingSpace getByCode(String code);

    boolean changeStatus(Integer id, Integer status);
}
