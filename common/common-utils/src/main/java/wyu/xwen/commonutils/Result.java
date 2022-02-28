package wyu.xwen.commonutils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/*封装返回信息格式的类*/

@Data
public class Result {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private Result(){}

    public static Result ok(){
        Result resultFormat = new Result();
        resultFormat.setSuccess(true);
        resultFormat.setCode(ResultCode.SUCCESS);
        resultFormat.setMessage("success");
        return resultFormat;
    }

    public static Result error(){
        Result resultFormat = new Result();
        resultFormat.setSuccess(false);
        resultFormat.setCode(ResultCode.ERROR);
        resultFormat.setMessage("failure");
        return resultFormat;
    }

    public Result success(Boolean isSuccess){
        this.setSuccess(isSuccess);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result date(String key, Object value){
        this.getData().put(key,value);
        return this;
    }

    public Result date(Map<String,Object> resultMap){
        this.setData(resultMap);
        return this;
    }

}
