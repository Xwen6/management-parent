package wyu.xwen.wechatApiService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wyu.xwen.base.utils.AESUtil;
import wyu.xwen.base.utils.MD5Util;

@SpringBootTest
class ServiceWechatApiApplicationTests {

    @Test
    void contextLoads() {
        /*String encode = MD5Util.MD5Encode("wxd3850b9caa1430d8","appid");
        System.out.println(encode);*/

//        String encode = MD5Util.getMD5("wxd3850b9caa1430d8");
//        System.out.println(encode);
//        System.out.println(MD5Util.getMD5(encode));
        String encrypt = AESUtil.encrypt("123");
        System.out.println(encrypt);
        System.out.println(AESUtil.decrypt(encrypt));

    }

}
