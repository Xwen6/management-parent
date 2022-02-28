package wyu.xwen.base.exception;

import lombok.Data;

@Data
public class CommunityException extends Exception{
    private String msg;
    private Integer code;

   public CommunityException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
