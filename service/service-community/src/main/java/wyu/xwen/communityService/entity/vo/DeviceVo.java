package wyu.xwen.communityService.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DeviceVo {


    private Integer id;
    private String communityName;
    private String code;
    private String name;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private Date buyTime;
    private Integer durableYears;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createTime;


}
