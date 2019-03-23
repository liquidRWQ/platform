package com.enter.platform.thread;

import com.enter.platform.config.PlatformAppConfig;
import com.enter.platform.exception.CheckedException;
import com.enter.platform.utils.WeChatAccessTokenUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Liquid
 * @类名： TokenThread
 * @描述： 简单的自制定时器，用于获取会过期的Token
 * @date 2018/12/29
 */
@Slf4j
public class TokenThread extends Thread {

    @Override
    public void run() {

        while (true) {
            try {
                PlatformAppConfig.enterpriseWeChatAccessToken = WeChatAccessTokenUtil.getEnterpriseWeChatAccessToken(PlatformAppConfig.ENTERPRISE_WE_CHAT_APP_ID, PlatformAppConfig.ENTERPRISE_WE_CHAT_SECRET);
                log.info("获取access_token成功，有效时长{}秒 token:{}", PlatformAppConfig.ACCESS_TOKEN_EFFECTIVE_SECOND, PlatformAppConfig.enterpriseWeChatAccessToken);
                // 休眠7000秒
                Thread.sleep((PlatformAppConfig.ACCESS_TOKEN_EFFECTIVE_SECOND - 5400) * 1000);

            } catch (InterruptedException | CheckedException e) {
                try {
                    log.error("定时器出异常了！{}", e);
                    Thread.sleep(30 * 1000);
                    PlatformAppConfig.enterpriseWeChatAccessToken = WeChatAccessTokenUtil.getEnterpriseWeChatAccessToken(PlatformAppConfig.ENTERPRISE_WE_CHAT_APP_ID, PlatformAppConfig.ENTERPRISE_WE_CHAT_SECRET);
                } catch (InterruptedException | CheckedException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

}


