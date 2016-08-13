package org.codingsills.wechat.token.server;

import org.codingsills.wechat.common.WechatConfig;

/**
 * 类功能描述
 * JsApiTicketServer.java
 *
 * @date 2016年8月5日
 * 
 * @author Saber
 */
public class JsApiTicketServer extends AbstractServer implements TicketServer{

    @Override
    public String ticket(){
        return super.token();
    }

    @Override
    public String getCustomerServerClass(){
        return WechatConfig.getInstance().getJsApiTicketServer();
    }

    @Override
    public IServer defaultServer(){
        return null;
    }
}
