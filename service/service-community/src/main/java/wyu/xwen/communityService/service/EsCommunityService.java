package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsCommunity;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.entity.vo.QueryCondition;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 小区信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
public interface EsCommunityService extends IService<EsCommunity> {

    boolean deleteById(Integer id);

    EsCommunity getByCCode(String code);

    boolean updateCommunity(EsCommunity esCommunity);

    Map<String, Object> pageList(Integer current, Integer limit, QueryCondition queryCondition);

    boolean addCommunity(EsCommunity community);

    CommunityVo getList(String code);

    List<CommunityVo> getCommunityList();

    List<EsCommunity> getListByName(String name);
}
