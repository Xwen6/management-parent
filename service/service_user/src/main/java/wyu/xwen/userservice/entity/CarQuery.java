package wyu.xwen.userservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CarQuery {

    private String name;
    private Integer userId;
    private String colo;
    private String licensePlate;
    private Date beginDate;
    private Date endDate;
    //private String carId;

}
