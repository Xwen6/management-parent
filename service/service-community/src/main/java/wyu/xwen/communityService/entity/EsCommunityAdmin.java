package wyu.xwen.communityService.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 小区管理员关系表
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsCommunityAdmin对象", description="小区管理员关系表")
public class EsCommunityAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "小区编号，建议CM开头")
    @TableId(value = "community_code", type = IdType.ID_WORKER)
    private String communityCode;

    @ApiModelProperty(value = "管理员id")
    private Integer adminId;


    private Integer id;


}
