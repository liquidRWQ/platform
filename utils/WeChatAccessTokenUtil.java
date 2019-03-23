package com.enter.platform.utils;

import com.alibaba.fastjson.JSONObject;
import com.enter.platform.config.PlatformAppConfig;
import com.enter.platform.exception.CheckedException;
import lombok.extern.slf4j.Slf4j;

/**
 * @className WeChatAccessTokenUtil
 * @auther Liquid
 * @description
 * @date 2018/12/21
 */
@Slf4j
public class WeChatAccessTokenUtil {

    public static String getAccessToken(String appId, String secret) throws CheckedException {

        String params = "grant_type=" + PlatformAppConfig.GRANT_TYPE + "&appid=" + appId + "&secret=" + secret;
        String accessTokenInfo = HttpRequestUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
        Object accessToken = JSONObject.parseObject(accessTokenInfo).get("access_token");
        String result = "";
        if (accessToken != null) {
            result = accessToken.toString();
        } else {
            String errmsg = JSONObject.parseObject(accessTokenInfo).get("errmsg").toString();
            throw new CheckedException("调用微信获取调用Token接口失败 " + errmsg);
        }
        return result;
    }

    public static String getEnterpriseWeChatAccessToken(String corpid, String corpsecret) throws CheckedException {
        String params = "corpid=" + corpid + "&corpsecret=" + corpsecret;

        String accessTokenInfo = HttpRequestUtils.sendGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken", params);
        Object accessToken = JSONObject.parseObject(accessTokenInfo).get("access_token");
        String result;
        if (accessToken != null) {
            result = accessToken.toString();
        } else {
            String errmsg = JSONObject.parseObject(accessTokenInfo).get("errmsg").toString();
            throw new CheckedException("调用企业微信获取调用Token接口失败 " + errmsg);
        }
        return result;
    }

}
