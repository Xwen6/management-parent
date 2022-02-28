package wyu.xwen.userservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class EsVehicleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "家庭成员id")
    private Integer userId;

    private String userName;

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

    public EsVehicleVO() {
    }

    public EsVehicleVO(EsVehicle vehicle) {
        this.id = vehicle.getId();
        this.userId = vehicle.getUserId();
        this.name = vehicle.getName();
        this.licensePlate = vehicle.getLicensePlate();
        this.color = vehicle.getColor();
        this.photo = vehicle.getPhoto();
        this.createTime = vehicle.getCreateTime();
        this.updateTime = vehicle.getUpdateTime();
        this.remark = vehicle.getRemark();
        this.isDel = vehicle.getIsDel();
        this.deleteTime = vehicle.getDeleteTime();
    }

}
