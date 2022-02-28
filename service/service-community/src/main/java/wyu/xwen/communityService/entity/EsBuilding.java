package wyu.xwen.communityService.entity;

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
 * 栋数信息表
 * </p>
 *
 * @author testjava
 * @since 2022-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsBuilding对象", description="栋数信息表")
@Document(indexName = "building",type = "docs", shards = 1, replicas = 0)
public class EsBuilding implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "所属小区编号，建议CM开头")
    @Field(type = FieldType.Keyword,copyTo = "all")
    private String communityCode;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "栋数编号，建议BD开头")
    private String code;

    @Field(type = FieldType.Text,copyTo = "all")
    @ApiModelProperty(value = "栋数名称")
    private String name;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "总户数")
    private Integer house;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "描述")
    private String description;


    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createTime;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "电梯数")
    private Integer lift;


    @ApiModelProperty(value = "逻辑删除",example = "1")
    @TableField(fill = FieldFill.INSERT)//插入数据时自动填充
    @TableLogic(value = "0",delval = "1")//逻辑删除
    private Integer isDel;

//    @Field(type = FieldType.Text,analyzer = "ik_max_word")
//    private String all;


}
