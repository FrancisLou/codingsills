package org.codingsills.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

/**
 * 自定义路径过滤器链解析器
 * CustomPathMatchingFilterChainResolver.java
 *
 * @date 2016年6月17日
 * 
 * @author Saber
 */
public class CustomPathMatchingFilterChainResolver extends PathMatchingFilterChainResolver {
	
    private CustomDefaultFilterChainManager customDefaultFilterChainManager;

    public void setCustomDefaultFilterChainManager(
            CustomDefaultFilterChainManager customDefaultFilterChainManager){
        this.customDefaultFilterChainManager = customDefaultFilterChainManager;
        setFilterChainManager(customDefaultFilterChainManager);
    }

    public FilterChain getChain(ServletRequest request, ServletResponse response,
            FilterChain originalChain){
        FilterChainManager filterChainManager = getFilterChainManager();
        if(!filterChainManager.hasChains()){
            return null;
        }
        String requestURI = getPathWithinApplication(request);
        
        List<String> chainNames = new ArrayList<String>();
        for(String pathPattern : filterChainManager.getChainNames()){
        	//不对静态资源添加过滤器
            if(pathMatches(pathPattern, requestURI) && notStaticResource(requestURI)){
                chainNames.add(pathPattern);
            }
        }
        if(chainNames.size() == 0){
            return null;
        }
        return customDefaultFilterChainManager.proxy(originalChain, chainNames);
    }
    
    /**
     * 判断是否为静态资源
     * */
    private boolean notStaticResource(String requestUri){
    	if(requestUri.endsWith("css") || requestUri.endsWith("js") || requestUri.endsWith("ico")
    			||requestUri.endsWith("jpg") || requestUri.endsWith("png")){
    		return false;
    	}
    	return true;
    }
}
