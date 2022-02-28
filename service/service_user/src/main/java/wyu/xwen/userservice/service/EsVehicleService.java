package wyu.xwen.userservice.service;

import wyu.xwen.userservice.entity.CarQuery;
import wyu.xwen.userservice.entity.EsVehicle;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.userservice.entity.EsVehicleVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
public interface EsVehicleService extends IService<EsVehicle> {

    boolean addCar(EsVehicle vehicle);

    boolean updateCarInfo(EsVehicle vehicle);

    boolean deleteById(Integer id);

    boolean batchDelete(List<Integer> ids);

    Map<String, Object> pageList(Integer current, Integer limit, CarQuery carQuery);

    EsVehicleVO getCarById(Integer id);
}
