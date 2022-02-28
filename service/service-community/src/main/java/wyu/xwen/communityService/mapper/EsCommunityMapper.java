package wyu.xwen.communityService.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wyu.xwen.communityService.entity.EsCommunity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wyu.xwen.communityService.entity.vo.CommunityVo;

import java.util.List;

/**
 * <p>
 * 小区信息表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Repository
public interface EsCommunityMapper extends BaseMapper<EsCommunity> {

    @Select("select id,code,name from  es_community where is_del = 0 and code = #{code}")
    CommunityVo getCommunityList(@Param("code") String code);
}
