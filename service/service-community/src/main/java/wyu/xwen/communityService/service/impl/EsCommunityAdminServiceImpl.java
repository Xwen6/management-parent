package wyu.xwen.communityService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import wyu.xwen.communityService.entity.EsBuilding;
import wyu.xwen.communityService.entity.EsCommunity;
import wyu.xwen.communityService.entity.EsCommunityAdmin;
import wyu.xwen.communityService.entity.vo.CommunityVo;
import wyu.xwen.communityService.mapper.EsCommunityAdminMapper;
import wyu.xwen.communityService.service.EsBuildingService;
import wyu.xwen.communityService.service.EsCommunityAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wyu.xwen.communityService.service.EsCommunityService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 小区管理员关系表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Service
public class EsCommunityAdminServiceImpl extends ServiceImpl<EsCommunityAdminMapper, EsCommunityAdmin> implements EsCommunityAdminService {

    @Autowired
    private EsCommunityService esCommunityService;
    @Autowired
    private EsBuildingService esBuildingService;

    @Override
    public List<CommunityVo> getList(Integer adminId) {
        /*根据adminId获取communityCode列表*/
        QueryWrapper<EsCommunityAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id",adminId);
        List<EsCommunityAdmin> esCommunityAdmins = baseMapper.selectList(wrapper);
        List<CommunityVo> communityVos = new ArrayList<>();
        /*根据communityCode列表获取community*/
        if (!(esCommunityAdmins.size()==0)) {
            for (EsCommunityAdmin communityAdmin : esCommunityAdmins) {

                String communityCode = communityAdmin.getCommunityCode();
                /*根据communityCode查询社区以及楼栋信息*/
                CommunityVo communityVo = esCommunityService.getList(communityCode);
                communityVos.add(communityVo);
            }
        }

        return communityVos;
    }

    public List<String> getCCodeList(Integer adminId) {
        /*根据adminId获取communityCode列表*/
        QueryWrapper<EsCommunityAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id",adminId);
        List<EsCommunityAdmin> esCommunityAdmins = baseMapper.selectList(wrapper);
        List<String> communityCodes = new ArrayList<>();
        /*根据communityCode列表获取community*/
        if (!(esCommunityAdmins.size()==0)) {
            for (EsCommunityAdmin communityAdmin : esCommunityAdmins) {
                communityCodes.add(communityAdmin.getCommunityCode());
            }
        }
        return communityCodes;
    }
}
