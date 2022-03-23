package wyu.xwen.wechatApiService.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsCategory对象", description="分类表")
public class EsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @ApiModelProperty(value = "父ID")
    private Integer pid;

    @ApiModelProperty(value = "栏目类型")
    private String type;

    private String name;

    private String nickname;

    private String flag;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "更新时间")
    private Date updatetime;

    @ApiModelProperty(value = "权重")
    private Integer weigh;

    @ApiModelProperty(value = "状态")
    private String status;

    private Integer isDel;


}
