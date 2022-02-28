package wyu.xwen.communityService.entity;

import java.io.File;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.generator.config.rules.FileType;
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
 * 小区信息表
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsCommunity对象", description="小区信息表")
@Document(indexName = "community",type = "docs", shards = 1, replicas = 0)
public class EsCommunity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "小区编号，建议CM开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String code;

    @Field(type = FieldType.Text,copyTo = "all")
    @ApiModelProperty(value = "小区名称")
    private String name;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "简介")
    private String introduction;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "缩略图")
    private String thumb;

    @Field(type = FieldType.Text,copyTo = "all")
    @ApiModelProperty(value = "坐落地址")
    private String address;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "占地面积，单位：平米")
    private BigDecimal area;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "开发商名称")
    private String developer;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "物业公司名称")
    private String estate;

    @Field(type = FieldType.Keyword,index = false)
    @ApiModelProperty(value = "绿化率，单位：百分比")
    private BigDecimal greeningRate;

    @ApiModelProperty(value = "总栋数")
    @Field(type = FieldType.Integer,index = false)
    private Integer totalBuilding;

    @Field(type = FieldType.Integer,index = false)
    @ApiModelProperty(value = "总户数")
    private Integer totalOwner;


    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")//逻辑删除
    @ApiModelProperty(value = "逻辑删除")
    private int isDel;

//    @Field(type = FieldType.Text)
//    private String all;

}
