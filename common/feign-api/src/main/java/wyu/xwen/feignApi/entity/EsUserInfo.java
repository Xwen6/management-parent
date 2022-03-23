package wyu.xwen.feignApi.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsUserInfo对象", description="业主信息")
public class EsUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表ID")
    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;


    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "车辆ID")

    private Integer vehicleId;


    @ApiModelProperty(value = "手机号")
    private String phone;


    @ApiModelProperty(value = "房产编号，建议HS开头")
    private String houseCode;

   // private String houseName;


    @ApiModelProperty(value = "所属社区,建议CM开头")
    private String communityCode;

   // private String communityName;


    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;


    @ApiModelProperty(value = "区")
    private String country;


    @ApiModelProperty(value = "详细地址")
    private String address;


    @ApiModelProperty(value = "外键")
    private Integer userId;


    @ApiModelProperty(value = "是否为默认地址")
    private Integer isDefault;


    @ApiModelProperty(value = "删除时间")
    private Date deleteTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    @ApiModelProperty(value = "新建时间")
    private Date createTime;

    @ApiModelProperty(value = "逻辑删除",example = "1")
    @TableField(fill = FieldFill.INSERT)//插入数据时自动填充
    @TableLogic(value = "0",delval = "1")//逻辑删除

    private Integer isDel;


    @ApiModelProperty(value = "身份证")
    private String identityId;


    @ApiModelProperty(value = "备注")
    private String remark;


    @ApiModelProperty(value = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date birth;
    @ApiModelProperty(value = "照片")
    private String image;


    @ApiModelProperty(value = "成员类型 1 户主 2 家庭成员，3 租户")
    private Integer ownerType;


    @ApiModelProperty(value = "职业")
    private String occupation;


    @ApiModelProperty(value = "性别")
    private Integer gender;

    private String openid;

   // @Field(type = FieldType.Text,analyzer = "ik_max_word")
   // private String all;


}
