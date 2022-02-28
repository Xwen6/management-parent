package wyu.xwen.communityService.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ParkingSpaceVo {
    private Integer id;
    private String name;
    private String code;
    private String CommunityName;
    private Date createTime;
    private Integer status;
}
