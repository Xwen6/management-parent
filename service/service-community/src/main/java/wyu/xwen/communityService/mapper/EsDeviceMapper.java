package wyu.xwen.communityService.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wyu.xwen.communityService.entity.EsDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wyu.xwen.communityService.entity.vo.DeviceQuery;
import wyu.xwen.communityService.entity.vo.DeviceVo;

import java.util.List;

/**
 * <p>
 * 资产设备信息表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-02-27
 */
@Mapper
public interface EsDeviceMapper extends BaseMapper<EsDevice> {

    @Select("select count(*) from es_device where is_del = 0")
    Integer selectTotal();

    List<DeviceVo> pageList(@Param("current") Integer current, @Param("size") Integer limit, @Param("query") DeviceQuery query);
}
