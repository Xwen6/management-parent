package wyu.xwen.wechatApiService.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import wyu.xwen.feignApi.client.UserClient;
import wyu.xwen.wechatApiService.config.WxConfig;
import wyu.xwen.wechatApiService.entity.EsUserInfo;
import wyu.xwen.wechatApiService.entity.EsUsers;
import wyu.xwen.wechatApiService.mapper.EsUsersMapper;
import wyu.xwen.wechatApiService.service.EsUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@Service
public class EsUsersServiceImpl extends ServiceImpl<EsUsersMapper, EsUsers> implements EsUsersService {


    @Autowired
    private Cache<String,String> wxInfoCache;
    @Autowired
    private UserClient client;

    @Override
    public  String getToken(String code) {
        //String url = getUrl(code);
        //JSONObject jsonObject = httpsRequestToJsonObject(url, "GET", null);

        String token_url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WxConfig.App_Id + "&secret=" + WxConfig.App_Secret + "&js_code=" + code + "&grant_type=authorization_code";
        JSONObject access_token = httpsRequestToJsonObject(token_url, "GET", null);
        //        openid    string    用户唯一标识 这个就是你微信用户标识
        String openid = access_token.getString("openid");
//        session_key    string    会话密钥
        String session_key = access_token.getString("session_key");

//            wxInfoCache.put("openid", openid);
//            wxInfoCache.put("session_key", session_key);
        QueryWrapper<EsUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openid);
        EsUsers esUsers = baseMapper.selectOne(wrapper);
        if (esUsers == null) {
            /*如果为null则为第一次登录*/
            EsUsers users = new EsUsers();
            EsUserInfo esUserInfo = new EsUserInfo();

            users.setOpenid(openid);
            baseMapper.insert(users);

        }else {

        }
        Map<String, String> map = new HashMap<>();
        map.put("openid", openid);
        map.put("session_key", session_key);
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(map);
        wxInfoCache.put("token",jsonString);
        return jsonString;


    }



    public static JSONObject httpsRequestToJsonObject(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            StringBuffer buffer = httpsRequest(requestUrl, requestMethod, outputStr);
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            System.err.println("请求连接超时"+ce);
        } catch (Exception e) {
            System.err.println("https请求异常：" + e.getMessage());
        }
        return jsonObject;
    }

    private static StringBuffer httpsRequest(String requestUrl, String requestMethod, String output)
            throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
            IOException, ProtocolException, UnsupportedEncodingException {
        URL url = new URL(null, requestUrl, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod(requestMethod);
        if (null != output) {
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes("UTF-8"));
            outputStream.close();
        }
        // 从输入流读取返回内容
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        connection.disconnect();
        return buffer;
    }
}
