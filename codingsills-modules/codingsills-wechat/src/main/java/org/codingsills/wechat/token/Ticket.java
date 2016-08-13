package org.codingsills.wechat.token;

import org.apache.commons.lang3.StringUtils;
import org.codingsills.wechat.common.WechatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * jsapi_ticket是公众号用于调用微信JS接口的临时票据
 * Ticket.java
 *
 * @date 2016年8月3日
 * 
 * @author Saber
 */
public class Ticket extends Token{
    private static final Logger logger = LoggerFactory.getLogger(Ticket.class);

    private static final String DEFAULT_URL =
            "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    private static final String TOKEN_NAME = "ticket";

    private static final String EXPIRES_IN_NAME = "expires_in";

    @Override
    protected String getAccessTokenUrl(){
        String url = WechatConfig.getInstance().getJsapiTicketUrl();
        if(StringUtils.isBlank(url)){
            url = DEFAULT_URL;
        }
        url.replace("ACCESS_TOKEN", "");
        logger.debug("获取公众号用于调用微信JS接口的临时票据ticket,请求接口地址初始化为:{}", url);
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
