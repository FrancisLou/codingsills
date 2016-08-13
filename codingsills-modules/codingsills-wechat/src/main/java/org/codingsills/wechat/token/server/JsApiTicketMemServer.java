package org.codingsills.wechat.token.server;

import org.codingsills.wechat.token.Ticket;

/**
 * 类功能描述
 * JsApiTicketMemServer.java
 *
 * @date 2016年8月5日
 * 
 * @author Saber
 */
public class JsApiTicketMemServer implements IServer{

private static JsApiTicketMemServer ticketServer = new JsApiTicketMemServer();
    
    private Ticket jsApiTicket = new Ticket();
    
    private int requestTimes = 1;//token请求失败后重新请求的次数
    
    /**
     * 私有构造
     */
    private JsApiTicketMemServer(){
        //获取新的token
        refresh();
    }
    
    /**
     * token中控服务器实例
     * @return ticket服务器实例
     */
    public static JsApiTicketMemServer instance(){
        return ticketServer;
    }
    
    
    /**
     * 通过中控服务器得到accessToken
     * @return
     */
    public String token(){
        //没有可用的token，则去刷新
        if(!this.jsApiTicket.isValid()){
            refresh();
        }
        return this.jsApiTicket.getToken();
    }
    
    /**
     * 服务器刷新token
     */
    private void refresh(){
        for(int i=0;i<requestTimes;i++){
            //请求成功则退出
            if(this.jsApiTicket.requestToken())
                break;
        }
    }
}
