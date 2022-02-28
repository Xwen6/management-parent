package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsDevice;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.DeviceQuery;

import java.util.Map;

/**
 * <p>
 * 资产设备信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-27
 */
public interface EsDeviceService extends IService<EsDevice> {

    Map<String, Object> pageList(Integer current, Integer limit, DeviceQuery query);
}
