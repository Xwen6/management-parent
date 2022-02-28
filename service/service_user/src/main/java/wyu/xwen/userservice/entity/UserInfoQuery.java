package wyu.xwen.userservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@ApiModel(value="用于用户信息的条件查询的对象", description="查询条件")
public class UserInfoQuery {
    /*根据所属楼栋模糊查询*/
    @ApiModelProperty(value = "所属楼栋")
    private String houseCode;

    /*根据业主名字查询*/
    @ApiModelProperty(value = "业主名字")
    private String name;

    /*身份证查询*/
    @ApiModelProperty(value = "身份证")
    private String identityId;

    /*职业查询*/
    @ApiModelProperty(value = "职业")
    private String job;

    @ApiModelProperty(value = "联系方式")
    private String phone;

    /*开始日期*/
    @ApiModelProperty(value = "开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    /*结束日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束日期")
    private Date endDate;


}
