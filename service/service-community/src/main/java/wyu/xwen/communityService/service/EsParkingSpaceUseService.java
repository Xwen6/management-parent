package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsParkingSpaceUse;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.QueryCondition;

import java.util.Map;

/**
 * <p>
 * 停车位使用记录表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
public interface EsParkingSpaceUseService extends IService<EsParkingSpaceUse> {

    boolean add(EsParkingSpaceUse parkingSpaceUse);

    boolean deleteParkingUse(Integer id);

    boolean updateParkingUse(EsParkingSpaceUse esParkingSpaceUse);

    EsParkingSpaceUse getParkingSpaceUseById(Integer id);

    Map<String, Object> pageList(Integer current, Integer limit, QueryCondition condition);
}
