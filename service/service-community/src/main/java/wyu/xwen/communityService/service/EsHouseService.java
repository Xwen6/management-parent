package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsHouse;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.QueryCondition;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房产信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-22
 */
public interface EsHouseService extends IService<EsHouse> {

    boolean addHouse(EsHouse house);

    boolean deleteHouseByCode(String code);

    boolean updateHouse(EsHouse house);

    Map<String, Object> pageList(Integer current, Integer limit, QueryCondition queryCondition);

    EsHouse getHouseByCode(String code);

    List<EsHouse> selectListByCommunityCode(String communityCode);
}
