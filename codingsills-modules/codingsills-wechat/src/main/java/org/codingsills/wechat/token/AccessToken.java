package org.codingsills.wechat.token;

import org.apache.commons.lang3.StringUtils;
import org.codingsills.wechat.common.WechatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * AccessToken.java
 *
 * @date 2016年7月28日
 * 
 * @author Saber
 */
public class AccessToken extends Token {

    private static final Logger logger = LoggerFactory.getLogger(AccessToken.class);

    private static final String DEFAULT_URL =
            "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private static final String TOKEN_NAME = "access_token";

    private static final String EXPIRES_IN_NAME = "expires_in";

    @Override
    protected String getAccessTokenUrl(){
        String url = WechatConfig.getInstance().getAccessTokenUrl();
        if(StringUtils.isBlank(url)){
            logger.warn("wechat.properties 未配置 access token url,采用默认值：{}", DEFAULT_URL);
            url = DEFAULT_URL;
        }
        url.replace("APPID", WechatConfig.getInstance().getAppid());
        url.replace("APPSECRET", WechatConfig.getInstance().getAppSecret());
        logger.debug("access_token请求接口地址初始化为:{}", url);
        return url;
    }

    @Override
    protected String getTokenName(){
        return TOKEN_NAME;
    }

    @Override
    protected String getExpiresInName(){
        return EXPIRES_IN_NAME;
    }
}
