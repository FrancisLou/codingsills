package org.codingsills.wechat.token.timer;

import java.util.TimerTask;

import org.codingsills.wechat.token.AccessToken;
import org.codingsills.wechat.token.server.AccessTokenServer;
import org.codingsills.wechat.token.server.CustomerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类功能描述
 * AccessTokenTimer.java
 *
 * @date 2016年8月3日
 * 
 * @author Saber
 */
public class AccessTokenTimer extends TimerTask{
    
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenTimer.class);

    //accessToken有效期7200秒,提前200秒请求新的token
    public static final long PERIOD = 7000 * 1000;
    public static final long DELAY = 0; //此任务的延迟时间为0，即立即执行
    
    @Override
    public void run(){
        logger.info("accessToken 定时任务启动，获取新的accessToken");
        //得到新的access token
        AccessToken accessToken = new AccessToken();
        //获取成功之后持久化accessToken
        if(accessToken.requestToken()){
            AccessTokenServer accessTokenServer = new AccessTokenServer();
            CustomerServer customerServer = (CustomerServer)accessTokenServer.customerServer();
            customerServer.save(accessToken);
        }
        
    }
}
