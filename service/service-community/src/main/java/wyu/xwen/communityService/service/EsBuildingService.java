package wyu.xwen.communityService.service;

import wyu.xwen.base.exception.CommunityException;
import wyu.xwen.communityService.entity.EsBuilding;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.BuildingVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 栋数信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
public interface EsBuildingService extends IService<EsBuilding> {
    List<EsBuilding> getBuildingByCCode(String code);

    boolean addBuilding(EsBuilding esBuilding);

    boolean deleteBuildingByCode(String code);

    boolean updateBuilding(EsBuilding building);

    Map<String, Object> pageList(Integer current, Integer limit, QueryCondition queryCondition);

    EsBuilding getBuildingByCode(String code);
}
