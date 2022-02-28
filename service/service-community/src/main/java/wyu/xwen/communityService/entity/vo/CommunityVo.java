package wyu.xwen.communityService.entity.vo;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class CommunityVo {
    private Integer id;
    private String code;
    private String name;
    private List<BuildingVo> children = new ArrayList<>();
    private List<ParkingSpaceVo> parkingSpaceVoList =  new ArrayList<>();
}
