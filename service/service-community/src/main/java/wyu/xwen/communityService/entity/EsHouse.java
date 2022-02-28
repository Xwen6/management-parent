package wyu.xwen.communityService.entity;

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
 * 房产信息表
 * </p>
 *
 * @author testjava
 * @since 2022-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsHouse对象", description="房产信息表")
@Document(indexName = "house",type = "docs", shards = 1, replicas = 0)
public class EsHouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "所属小区编号，建议CM开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String communityCode;

    @ApiModelProperty(value = "栋数编号，建议BD开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String buildingCode;

    @ApiModelProperty(value = "房产编号，建议HS开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String code;

    @ApiModelProperty(value = "房产名称")
    @Field(type = FieldType.Text,copyTo = "all")
    private String name;

    @ApiModelProperty(value = "户主姓名")
    @Field(type = FieldType.Text,copyTo = "all")
    private String ownerName;

    @ApiModelProperty(value = "户主联系方式")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String ownerTel;

    @ApiModelProperty(value = "房间数")
    @Field(type = FieldType.Keyword,index = false)
    private Integer rooms;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "单元信息")
    private String unit;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "楼层信息")
    private Integer floor;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "房产描述")
    private String description;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "入住时间")
    private Date enterTime;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")//逻辑删除
    @ApiModelProperty(value = "逻辑删除")
    private Integer isDel;

//    @Field(type = FieldType.Text)
//    private String all;


}
