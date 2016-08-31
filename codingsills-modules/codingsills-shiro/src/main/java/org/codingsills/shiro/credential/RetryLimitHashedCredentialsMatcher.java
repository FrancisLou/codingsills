package org.codingsills.shiro.credential;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;


/**
 * 扩展身份凭证匹配器，加入重试次数限定机制
 * RetryLimitHashedCredentialsMatcher.java
 *
 * @date 2016年6月17日
 * 
 * @author Saber
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{
    
    private Cache<String, AtomicInteger> passwordRetryCache;

    /**
     * RetryLimitHashedCredentialsMatcher.java 构造方法
     */
    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager){
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        
        String username = (String)token.getPrincipal();
        
        //获取重试次数
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null){
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > 5){
            //超过5次抛出异常
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches){
            //成功即清除缓存
            passwordRetryCache.remove(username);
        }
        
        return matches;
    }
    
    
    
}
