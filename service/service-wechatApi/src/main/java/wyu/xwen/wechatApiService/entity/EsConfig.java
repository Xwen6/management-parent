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
 * 系统配置
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EsConfig对象", description="系统配置")
public class EsConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "变量名")
    private String name;

    @ApiModelProperty(value = "分组")
    private String configGroup;

    @ApiModelProperty(value = "变量标题")
    private String title;

    @ApiModelProperty(value = "变量描述")
    private String tip;

    @ApiModelProperty(value = "类型:string,text,int,bool,array,datetime,date,file")
    private String configType;

    @ApiModelProperty(value = "变量值")
    private String value;

    @ApiModelProperty(value = "变量字典数据")
    private String content;

    @ApiModelProperty(value = "验证规则")
    private String rule;

    @ApiModelProperty(value = "扩展属性")
    private String extend;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Long isDel;


}
