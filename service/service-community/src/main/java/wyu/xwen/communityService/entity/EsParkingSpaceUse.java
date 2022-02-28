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
 * 停车位使用记录表
 * </p>
 *
 * @author testjava
 * @since 2022-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsParkingSpaceUse对象", description="停车位使用记录表")
@Document(indexName = "parkinguse",type = "docs", shards = 1, replicas = 0)
public class EsParkingSpaceUse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "所属小区编号，建议CM开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String communityCode;

    @ApiModelProperty(value = "车位编号，建议PK开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String pkCode;

    @ApiModelProperty(value = "车辆牌照")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String licensePlate;

    @ApiModelProperty(value = "车辆所有人")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String owner;

    @ApiModelProperty(value = "联系电话")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String tel;

    @ApiModelProperty(value = "开始时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date beginTime;

    @ApiModelProperty(value = "截止时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty(value = "使用性质 1 租 2 买")
    @Field(type = FieldType.Integer)
    private Integer type;

    @ApiModelProperty(value = "费用")
    @Field(type = FieldType.Keyword)
    private String cost;

    @ApiModelProperty(value = "创建时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除，1删除，0未删除")
    @TableLogic(value = "0",delval = "1")//逻辑删除
    @TableField(fill = FieldFill.INSERT)//插入数据时自动填充
    private Integer isDel;

//    @Field(type = FieldType.Text,analyzer = "ik_max_word")
//    private String all;
//

}
