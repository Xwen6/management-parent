package wyu.xwen.wechatApiService.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsUsers对象", description="")
public class EsUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户身份唯一标记")
    private String openid;

    @ApiModelProperty(value = "微信昵称")
    private String nickname;

    @ApiModelProperty(value = "微信头像")
    private String userphoto;

    @ApiModelProperty(value = "微信城市")
    private String city;

    @ApiModelProperty(value = "微信国家")
    private String country;

    @ApiModelProperty(value = "微信语言")
    private String language;

    @ApiModelProperty(value = "微信性别")
    private String gender;

    @ApiModelProperty(value = "微信省份")
    private String province;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除时间")
    private Date deleteTime;

    @ApiModelProperty(value = "注册时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Integer isDel;


}
