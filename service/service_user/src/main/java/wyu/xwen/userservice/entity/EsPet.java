package wyu.xwen.userservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

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
 * 宠物信息表
 * </p>
 *
 * @author testjava
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsPet对象", description="宠物信息表")
@Document(indexName = "userpet",type = "docs", shards = 1, replicas = 0)
public class EsPet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "家庭成员id")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private Integer userId;

    @ApiModelProperty(value = "成员名称")
    @TableField(exist = false)
    private String userName;


    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "宠物名称")
    private String name;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "宠物颜色")
    private String color;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "宠物照片，拍照上传即可")
    private String photo;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "收养时间")
    private Date adoptTime;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "添加时间")
    private Date createTime;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @ApiModelProperty(value = "备注")
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")//逻辑删除
    @ApiModelProperty(value = "逻辑删除")
    private Integer isDel;

    @ApiModelProperty(value = "删除时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date deleteTime;

/*
   @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all;
*/


}
