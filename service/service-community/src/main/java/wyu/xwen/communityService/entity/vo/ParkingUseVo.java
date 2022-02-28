package wyu.xwen.communityService.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ParkingUseVo {

    private Integer id;

    private String communityName;

    private String parkingName;

    private String licenseName;

    private String owner;

    private String tel;

    private Date beginTime;

    private Date endTime;

    private Integer type;

    private String cost;

    private Date createTime;


}
