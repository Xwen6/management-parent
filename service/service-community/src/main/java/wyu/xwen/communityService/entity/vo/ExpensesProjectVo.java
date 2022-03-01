package wyu.xwen.communityService.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ExpensesProjectVo {

    private Integer id;

    private String communityCode;

    private String code;

    private String name;

    private Date createTime;



}
