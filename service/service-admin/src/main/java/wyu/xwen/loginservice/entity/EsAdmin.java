package wyu.xwen.loginservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author testjava
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsAdmin对象", description="管理员表")
public class EsAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "密码盐")
    private String salt;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "失败次数")
    private Integer loginFailure;

    @ApiModelProperty(value = "登录时间")
    private Integer loginTime;

    @ApiModelProperty(value = "创建时间")
    private Integer createTime;

    @ApiModelProperty(value = "更新时间")
    private Integer updateTime;

    @ApiModelProperty(value = "Session标识")
    private String token;

    @ApiModelProperty(value = "状态")
    private String status;


}
