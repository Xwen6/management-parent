package wyu.xwen.communityService.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 资产设备信息表
 * </p>
 *
 * @author testjava
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsDevice对象", description="资产设备信息表")
public class EsDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属小区编号，建议CM开头")
    private String communityCode;

    @ApiModelProperty(value = "设备编号，建议DV开头")
    private String code;

    @ApiModelProperty(value = "设备名称")
    private String name;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "购买价格（单价）")
    private BigDecimal price;

    @ApiModelProperty(value = "购买数量")
    private Integer quantity;

    @ApiModelProperty(value = "购买时间")
    private Date buyTime;

    @ApiModelProperty(value = "预计使用年限")
    private Integer durableYears;

    @ApiModelProperty(value = "逻辑删除，0未删除，1删除")
    @TableField(fill = FieldFill.INSERT)//插入数据时自动填充
    @TableLogic(value = "0",delval = "1")//逻辑删除
    private Integer isDel;

    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createTime;


    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
