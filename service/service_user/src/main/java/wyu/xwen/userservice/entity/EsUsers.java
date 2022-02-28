package wyu.xwen.userservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2022-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsUsers对象", description="这是社区用户的实体类")
@Document(indexName = "user",type = "docs", shards = 1, replicas = 0)
public class EsUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    //@ApiModelProperty(value = "主键ID",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "用户身份唯一标记")
    //@TableId(value = "openId",type = IdType.ASSIGN_UUID)
    private String openid;

    @Field(type = FieldType.Text,copyTo = "all")
    @ApiModelProperty(value = "微信昵称")
    private String nickname;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "微信头像")
    private String userphoto;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "微信城市")
    private String city;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "微信国家")
    private String country;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "微信语言")
    private String language;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "微信性别")
    private String gender;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "微信省份")
    private String province;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @ApiModelProperty(value = "扩展字段")
    private String extend;

   /* @TableField(fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")*/
    @ApiModelProperty(value = "删除时间")
    @Field(type = FieldType.Date,pattern = "uuuu-MM-dd HH:mm:ss",format = DateFormat.basic_date_time)
    private Date deleteTime;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "注册时间")
    @Field(type = FieldType.Date,pattern = "uuuu-MM-dd HH:mm:ss",format = DateFormat.basic_date_time)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    @Field(type = FieldType.Date,pattern = "uuuu-MM-dd HH:mm:ss",format = DateFormat.basic_date_time)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")
    @ApiModelProperty(value = "逻辑删除",example = "1")
    @Field(type = FieldType.Integer,index = false,pattern = "uuuu-MM-dd HH:mm:ss",format = DateFormat.basic_date_time)
    private Integer isDel;


    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all;

}
