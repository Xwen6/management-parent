package wyu.xwen.base.utils;

import java.util.UUID;

/**
 * @ClassName: UUIDUtil
 * @Author: xcwen
 * @Create: 2022-03-23 18:04
 * @Version 1.0
 * @Description: TODO
 **/
public class UUIDUtil {
    public static String getUUID(){

        return UUID.randomUUID().toString().replaceAll("-","");

    }
}
