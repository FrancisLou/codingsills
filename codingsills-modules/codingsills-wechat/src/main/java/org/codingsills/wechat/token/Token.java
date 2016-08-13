package org.codingsills.wechat.token;

import org.apache.commons.lang3.StringUtils;
import org.codingsills.wechat.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 类功能描述
 * Token.java
 *
 * @date 2016年8月3日
 * 
 * @author Saber
 */
public abstract class Token {
    
    private static final Logger logger = LoggerFactory.getLogger(Token.class);
    
    private String token;
    
    private long expires; //token有效时间
    
    private long tokenTime;//token产生时间
    
    private int redundance = 10*1000;  //冗余时间，提前10秒就去请求新的token

    /**
     * 得到token
     * */
    public String getToken(){
        return token;
    }

    /**
     * 得到token有效时间
     * */
    public long getExpires(){
        return expires;
    }
    
    /**
     * Get方法请求微信服务器获取token
     * */
    public boolean requestToken(){
        String url = getAccessTokenUrl();
        String result = HttpUtils.get(url);
        
        if(!parseTokenResult(result)){
            return false;
        }
        logger.info("token获取成功");
        return true;
    }
    
    /**
     * 验证token是否有效
     * @return true 有效，false:无效
     * */
    public boolean isValid(){
        if((StringUtils.isBlank(token)) || (expires <= 0)){
            return false;
        }
        if(isExpired()){
            return false;
        }
        return true;
    }
    
    /**
     * 解析token数据
     * */
    private boolean parseTokenResult(String data){
        if(StringUtils.isBlank(data)){
            logger.warn("请求access token返回结果为空");
            return false;
        }
        JSONObject obj = JSONObject.parseObject(data);
        String tokenName = getTokenName();
        String expiresInName = getExpiresInName();
        try{
            String tokenPara = obj.getString(tokenName);
            if(StringUtils.isBlank(tokenPara)){
                logger.error("token获取失败,结果为空;解析串为:{}" ,data);
                return false;
            }
            this.token = tokenPara;
            this.tokenTime = System.currentTimeMillis();
            String expiresPara = obj.getString(expiresInName);
            if(StringUtils.isBlank(expiresPara)){
                logger.error("expires_in 获取失败,结果为空;解析串为:{}",data);
                return false;
            }else{
                expires = Long.valueOf(expiresPara).longValue();
            }
        }
        catch(Exception e){
            logger.error("token 结果解析失败，token参数名称: " + tokenName 
                    + "有效期参数名称:" + expiresInName
                    + "token请求结果:" + data,e);
            return false;
        }
        
        return true;
    }
    
    /**
     * 判断是否过期
     * @return true 过期，false:未过期
     * */
    private boolean isExpired(){
        long currentTime = System.currentTimeMillis();
        long expiresTime = expires * 1000 - redundance;
        //判断是否过期
        if((tokenTime + expiresTime) > currentTime){
            return false;
        }
        return true;
    }
    
    /**
     * 获取access token的接口地址,并完成参数初始化
     * */
    protected abstract String getAccessTokenUrl();
    
    /**
     * token的参数名称
     * */
    protected abstract String getTokenName();
    
    /**
     * expireIn参数名称
     * */
    protected abstract String getExpiresInName();
}
