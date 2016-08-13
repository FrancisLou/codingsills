package org.codingsills.wechat.token.server;

import org.codingsills.wechat.common.WechatConfig;

/**
 * access_token适配器
 * AccessTokenServer.java
 *
 * @date 2016年8月3日
 * 
 * @author Saber
 */
public class AccessTokenServer extends AbstractServer implements TokenServer {

    public String token(){
        return super.token();
    }

    @Override
    public String getCustomerServerClass(){
        return WechatConfig.getInstance().getAccessTokenServer();
    }

    @Override
    public IServer defaultServer(){
        return AccessTokenMemServer.instance();
    }
}
