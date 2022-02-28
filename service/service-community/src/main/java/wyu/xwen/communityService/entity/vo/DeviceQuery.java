package wyu.xwen.communityService.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DeviceQuery {

    private Date beginDate;
    private Date endDate;
    private String communityName;
    private String name;
    private String brand;

}
