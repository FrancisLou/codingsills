package org.codingsills.wechat.token.server;

import org.codingsills.wechat.token.AccessToken;

/**
 * 类功能描述
 * AccessTokenMemServer.java
 *
 * @date 2016年8月3日
 * 
 * @author Saber
 */
public class AccessTokenMemServer implements IServer {

    private static AccessTokenMemServer tokenServer = new AccessTokenMemServer();

    private AccessToken accessToken = new AccessToken();

    private int requestTimes = 1;// token请求失败后重新请求的次数

    /**
     * token中控服务器实例
     * @return 中控服务器实例
     */
    public static AccessTokenMemServer instance(){
        return tokenServer;
    }

    @Override
    public String token(){
        return accessToken().getToken();
    }

    /**
     * 私有构造
     */
    private AccessTokenMemServer(){
        // 获取新的token
        refresh();
    }

    /**
     * 通过中控服务器得到token
     * @return
     */
    private AccessToken accessToken(){
        // 没有可用的token，则去刷新
        if(!accessToken.isValid()){
            refresh();
        }
        return accessToken;
    }

    /**
     * 服务器刷新token
     */
    private void refresh(){
        for(int i = 0; i < requestTimes; i++){
            // 请求成功则退出
            if(accessToken.requestToken()){
                break;
            }
        }
    }
}
