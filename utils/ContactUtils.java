package com.enter.platform.utils;

import com.alibaba.fastjson.JSONObject;
import com.enter.platform.DTO.ContactUserDTO;
import com.enter.platform.config.PlatformAppConfig;
import com.enter.platform.exception.CheckedException;
import com.enter.platform.exception.UnCheckedException;

/**
 * @author Liquid
 * @类名： ContactUtils
 * @描述：
 * @date 2019/3/23
 */
public class ContactUtils {

    public static String addContactWay() throws CheckedException {
        ContactUserDTO contactUserDTO = new ContactUserDTO();
        contactUserDTO.setType(1);
        contactUserDTO.setScene(1);
        contactUserDTO.setStyle(2);
        contactUserDTO.setRemark("测试");
        contactUserDTO.setSkipVerify(true);
        contactUserDTO.setUser(new String[]{"user1"});
        String param = JsonUtils.toJSONStringBySanakeCase(contactUserDTO);
        String resultJson = HttpRequestUtils.sendPost("https://qyapi.weixin.qq.com/cgi-bin/crm/add_contact_way?access_token=" + PlatformAppConfig.enterpriseWeChatAccessToken, param);
        JSONObject jsonObject = JsonUtils.toJSONObject(resultJson);
        Object errcode =  jsonObject.get("errcode");

        if (errcode!=null && (int)errcode==0){
             return (String)jsonObject.get("config_id");
        }else {
            throw new UnCheckedException("添加联系我用户失败");
        }
    }

    public static void getContactWay(String configId) throws CheckedException {
        ContactUserDTO contactUserDTO = new ContactUserDTO();
        contactUserDTO.setConfigId(configId);
        String param = JsonUtils.toJSONStringBySanakeCase(contactUserDTO);
        String resultJson = HttpRequestUtils.sendPost("https://qyapi.weixin.qq.com/cgi-bin/crm/get_contact_way?access_token=" + PlatformAppConfig.enterpriseWeChatAccessToken, param);
        JSONObject jsonObject = JsonUtils.toJSONObject(resultJson);
        Object errcode =  jsonObject.get("errcode");
        if (errcode!=null && (int)errcode==0){
            System.out.println("jsonObject = " + jsonObject.toString());
        }else {
            throw new UnCheckedException("获取联系我用户失败"+jsonObject.get("errmsg"));
        }
    }

    public static void updateContactWay(String configId) throws CheckedException {
        ContactUserDTO contactUserDTO = new ContactUserDTO();
        contactUserDTO.setStyle(1);
        contactUserDTO.setRemark("渠道客户");
        contactUserDTO.setSkipVerify(true);
        contactUserDTO.setUser(new String[]{"userId"});
        contactUserDTO.setConfigId(configId);
        String param = JsonUtils.toJSONStringBySanakeCase(contactUserDTO);
        String resultJson = HttpRequestUtils.sendPost("https://qyapi.weixin.qq.com/cgi-bin/crm/update_contact_way?access_token=" + PlatformAppConfig.enterpriseWeChatAccessToken, param);
        JSONObject jsonObject = JsonUtils.toJSONObject(resultJson);
        Object errcode =  jsonObject.get("errcode");
        if (errcode!=null && (int)errcode==0){
            System.out.println("jsonObject = " + jsonObject.toString());
        }else {
            throw new UnCheckedException("修改联系我用户失败"+jsonObject.get("errmsg"));
        }
    }

    public static void deleteContactWay(String configId) throws CheckedException {
        ContactUserDTO contactUserDTO = new ContactUserDTO();
        contactUserDTO.setConfigId(configId);
        String param = JsonUtils.toJSONStringBySanakeCase(contactUserDTO);
        String resultJson = HttpRequestUtils.sendPost("https://qyapi.weixin.qq.com/cgi-bin/crm/del_contact_way?access_token=" + PlatformAppConfig.enterpriseWeChatAccessToken, param);
        JSONObject jsonObject = JsonUtils.toJSONObject(resultJson);
        Object errcode =  jsonObject.get("errcode");
        if (errcode!=null && (int)errcode==0){
            System.out.println("jsonObject = " + jsonObject.toString());
        }else {
            throw new UnCheckedException("删除联系我用户失败"+jsonObject.get("errmsg"));
        }
    }


}
