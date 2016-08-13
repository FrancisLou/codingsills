package org.codingsills.wechat.token;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.codingsills.wechat.token.timer.AccessTokenTimer;
import org.codingsills.wechat.token.timer.JsApiTicketTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * access token(ticket)监听器
 * TokenListener.java
 *
 * @date 2016年8月5日
 * 
 * @author Saber
 */
public class TokenListener implements ServletContextListener{
    
    private static final Logger logger = LoggerFactory.getLogger(TokenListener.class);
    
    private Timer timer = null;
    @Override
    public void contextInitialized(ServletContextEvent sce){
        logger.info("accessToken监听器启动..........");
        timer = new Timer(true);
        registerAccessTokenTimer();
        registerJsApiTicketTimer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        timer.cancel();
    }
    
    private void registerAccessTokenTimer(){
        AccessTokenTimer accessTokenTimer = new AccessTokenTimer();
        timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY, AccessTokenTimer.PERIOD);
        logger.info("accessToken定时器注册成功，执行间隔为" + AccessTokenTimer.PERIOD);
    }
    
    private void registerJsApiTicketTimer(){
        JsApiTicketTimer jsApiTicketTimer = new JsApiTicketTimer();
        timer.schedule(jsApiTicketTimer, JsApiTicketTimer.DELAY, JsApiTicketTimer.PERIOD);
        logger.info("jsapi_ticket定时器注册成功，执行间隔为"+JsApiTicketTimer.PERIOD);
    }
}
