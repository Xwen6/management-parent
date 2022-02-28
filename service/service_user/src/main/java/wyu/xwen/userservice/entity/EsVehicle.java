package wyu.xwen.userservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
 * 车辆信息表
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsVehicle对象", description="车辆信息表")
@Document(indexName = "uservehicle",type = "docs", shards = 1, replicas = 0)
public class EsVehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "家庭成员id")
    private Integer userId;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "车辆名称")
    private String name;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "车辆牌照")
    private String licensePlate;

    @Field(type = FieldType.Keyword,copyTo = "all")
    @ApiModelProperty(value = "车辆颜色")
    private String color;

    @Field(type = FieldType.Text,index = false)
    @ApiModelProperty(value = "车辆照片，拍照上传即可")
    private String photo;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @ApiModelProperty(value = "备注")
    private String remark;


    @ApiModelProperty(value = "逻辑删除",example = "1")
    @TableField(fill = FieldFill.INSERT)//插入数据时自动填充
    @TableLogic(value = "0",delval = "1")//逻辑删除
    private Integer isDel;


    @ApiModelProperty(value = "删除时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.UPDATE)//插入数据时自动填充
    private Date deleteTime;

/* @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all;*/


}
