package wyu.xwen.userservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document(indexName = "userinfo",type = "docs", shards = 1, replicas = 0)
public class UserInfoDoc {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表ID")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @Field(type = FieldType.Text,copyTo = "all")
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "车辆ID")
    @Field(type = FieldType.Integer)
    private Integer vehicleId;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "手机号")
    private String phone;

    @Field(type = FieldType.Text,copyTo = "all")
    @ApiModelProperty(value = "房产编号，建议HS开头")
    private String house;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "所属社区,建议CM开头")
    private String community;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "省")
    private String province;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "市")
    private String city;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "区")
    private String country;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @ApiModelProperty(value = "详细地址")
    private String address;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "外键")
    private Integer userId;

    @Field(type = FieldType.Integer,index = false)
    @ApiModelProperty(value = "是否为默认地址")
    private Integer isDefault;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "删除时间")
    private Date deleteTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "新建时间")
    private Date createTime;

    @ApiModelProperty(value = "逻辑删除",example = "1")
    @TableField(fill = FieldFill.INSERT)//插入数据时自动填充
    @TableLogic(value = "0",delval = "1")//逻辑删除
    @Field(type = FieldType.Integer,index = false)//es字段配置
    private Integer isDel;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "身份证")
    private String identityId;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @ApiModelProperty(value = "备注")
    private String remark;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "生日")
    private Date birth;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "照片")
    private String image;

    @Field(type = FieldType.Boolean)
    @ApiModelProperty(value = "成员类型 1 户主 2 家庭成员，3 租户")
    private Boolean ownerType;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "职业")
    private String occupation;


    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all;

}
