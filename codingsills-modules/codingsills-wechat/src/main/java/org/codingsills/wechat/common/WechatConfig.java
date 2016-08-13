package org.codingsills.wechat.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信相关基础信息配置类
 * WechatConfig.java
 *
 * @date 2016年7月28日
 * 
 * @author Saber
 */
public class WechatConfig {

    private static final Logger logger = LoggerFactory.getLogger(WechatConfig.class);

    private static final String configPath = "/wechat.properties";

    private String url;

    private String token;

    private String encodingAESKey;

    private String appid;

    private String appSecret;

    private String accessTokenUrl;

    private String jsapiTicketUrl;

    private String accessTokenServer;// 自定义中控服务

    private String jsApiTicketServer;

    private static WechatConfig config = new WechatConfig();

    private WechatConfig(){
        Properties prop = new Properties();
        InputStream ins = this.getClass().getResourceAsStream(configPath);
        if(ins == null){
            logger.error("can not find the wechat.properties under the class' root directory");
            return;
        }
        try{
            prop.load(ins);
            url = prop.getProperty("wechat.url");
            token = prop.getProperty("wechat.token");
            encodingAESKey = prop.getProperty("wechat.encodingAESKey");
            appid = prop.getProperty("wechat.appid");
            appSecret = prop.getProperty("wechat.appsecret");
            accessTokenUrl = prop.getProperty("wechat.accessToken.url");
            jsapiTicketUrl = prop.getProperty("wechat.jsapi.ticket.url");
            accessTokenServer = prop.getProperty("wechat.accessToken.server.class");
            jsApiTicketServer = prop.getProperty("wechat.ticket.jsapi.server.class");
        }
        catch(IOException e){
            logger.error("load wechat.properties error", e);
        }
    }

    public static WechatConfig getInstance(){
        return config;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getEncodingAESKey(){
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey){
        this.encodingAESKey = encodingAESKey;
    }

    public String getAppid(){
        return appid;
    }

    public void setAppid(String appid){
        this.appid = appid;
    }

    public String getAppSecret(){
        return appSecret;
    }

    public void setAppSecret(String appSecret){
        this.appSecret = appSecret;
    }

    public String getAccessTokenUrl(){
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl){
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getJsapiTicketUrl(){
        return jsapiTicketUrl;
    }

    public void setJsapiTicketUrl(String jsapiTicketUrl){
        this.jsapiTicketUrl = jsapiTicketUrl;
    }

    public String getAccessTokenServer(){
        return accessTokenServer;
    }

    public void setAccessTokenServer(String accessTokenServer){
        this.accessTokenServer = accessTokenServer;
    }

    public String getJsApiTicketServer(){
        return jsApiTicketServer;
    }

    public void setJsApiTicketServer(String jsApiTicketServer){
        this.jsApiTicketServer = jsApiTicketServer;
    }
}
