package org.codingsills.wechat.token.timer;

import java.util.TimerTask;

import org.codingsills.wechat.token.Ticket;
import org.codingsills.wechat.token.server.CustomerServer;
import org.codingsills.wechat.token.server.JsApiTicketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类功能描述
 * JsApiTicketTimer.java
 *
 * @date 2016年8月5日
 * 
 * @author Saber
 */
public class JsApiTicketTimer extends TimerTask {

    private static final Logger logger = LoggerFactory.getLogger(AccessTokenTimer.class);

    // jsapi_ticket有效期7200秒,提前200秒请求新的token
    public static final long PERIOD = 7000 * 1000;

    public static final long DELAY = 0; // 此任务的延迟时间为0，即立即执行

    @Override
    public void run(){
        logger.info("jsapi_ticket定时任务启动，获得新的jsapi_ticket");
        Ticket ticket = new Ticket();
        if(ticket.requestToken()){
            JsApiTicketServer jsApiTicketServer = new JsApiTicketServer();
            CustomerServer customerServer = (CustomerServer)jsApiTicketServer.customerServer();
            customerServer.save(ticket);
        }
    }
}
