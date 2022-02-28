package wyu.xwen.communityService.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BuildingVo {
    private Integer id;
    private String code;
    private String name;
    private String communityName;
    private Integer house;
    private String description;
    private Date createTime;
}
