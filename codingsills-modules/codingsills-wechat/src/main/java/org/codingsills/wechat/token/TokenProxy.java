package org.codingsills.wechat.token;

import org.codingsills.wechat.token.server.AccessTokenServer;
import org.codingsills.wechat.token.server.JsApiTicketServer;
import org.codingsills.wechat.token.server.TicketServer;
import org.codingsills.wechat.token.server.TokenServer;

/**
 * AccessToken(ticket)代理
 * 所有access_token或jsapi_ticket都从此类获取
 * TokenProxy.java
 *
 * @date 2016年8月5日
 * 
 * @author Saber
 */
public class TokenProxy {
    
    /**
     * 获取access_token
     * */
    public static String accessToken(){
        TokenServer tokenServer = new AccessTokenServer();
        return tokenServer.token();
    }
    
    /**
     * 获取jsapi_ticket
     * */
    public static String jsApiTicket(){
        TicketServer ticketServer = new JsApiTicketServer();
        return ticketServer.ticket();
    }
}
