package wyu.xwen.wechatApiService.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 业主报修信息表
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsRepair对象", description="业主报修信息表")
public class EsRepair implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属小区编号，建议CM开头")
    private String communityCode;

    @ApiModelProperty(value = "报修成员id")
    private Integer memberId;

    @ApiModelProperty(value = "地址ID")
    private Integer consigneeId;

    @ApiModelProperty(value = "报修设备名称")
    private String deviceName;

    @ApiModelProperty(value = "报修设备id")
    private Integer deviceId;

    @ApiModelProperty(value = "报修描述")
    private String desc;

    @ApiModelProperty(value = "缩略图")
    private String thumb;

    @ApiModelProperty(value = "状态 0 待受理 1 已受理 2 已维修  3 确认维修")
    private Integer status;

    @ApiModelProperty(value = "报修来源 0 后台管理人员 1 前端业主")
    private Integer from;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "添加时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")//逻辑删除
    @ApiModelProperty(value = "逻辑删除")
    private Integer idDel;


}
