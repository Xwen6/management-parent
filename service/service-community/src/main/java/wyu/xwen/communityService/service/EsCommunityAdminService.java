package wyu.xwen.communityService.service;

import wyu.xwen.communityService.entity.EsCommunityAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.communityService.entity.vo.CommunityVo;

import java.util.List;

/**
 * <p>
 * 小区管理员关系表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
public interface EsCommunityAdminService extends IService<EsCommunityAdmin> {

    List<CommunityVo> getList(Integer adminId);
}
