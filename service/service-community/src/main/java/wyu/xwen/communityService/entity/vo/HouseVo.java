package wyu.xwen.communityService.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class HouseVo {

    private Integer id;

    private String communityName;

    private String buildingName;

    private String code;

    private String name;

    private String ownerName;

    private String ownerTel;

    private Integer rooms;

    private String unit;

    private Integer floor;

    private String description;

    private Date enterTime;

}
