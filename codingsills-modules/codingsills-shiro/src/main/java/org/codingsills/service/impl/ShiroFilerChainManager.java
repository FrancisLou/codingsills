package org.codingsills.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.codingsills.entity.UrlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * 类功能描述
 * ShiroFilerChainManager.java
 *
 * @date 2016年6月20日
 * 
 * @author Saber
 */
@Service
public class ShiroFilerChainManager {
    
    private static final Logger logger = LoggerFactory.getLogger(ShiroFilerChainManager.class);
    
    @Autowired
    private DefaultFilterChainManager filterChainManager;
    
    private Map<String, NamedFilterList> defaultFilterChains;

    @PostConstruct
    public void init() {
        defaultFilterChains = new HashMap<String, NamedFilterList>(filterChainManager.getFilterChains());
    }
    
    /**
     * 初始化过滤器链
     * */
    //1、首先删除以前老的filter chain并注册默认的
    public void initFilterChains(List<UrlFilter> urlFilters) {
        //1、首先删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if(defaultFilterChains != null) {
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }

        //2、循环URL Filter 注册filter chain
        for (UrlFilter urlFilter : urlFilters) {
            String url = urlFilter.getUrl();
            //注册roles filter
            if (!StringUtils.isEmpty(urlFilter.getRoles())) {
                filterChainManager.addToChain(url, "roles", urlFilter.getRoles());
            }
            //注册perms filter
            if (!StringUtils.isEmpty(urlFilter.getPermissions())) {
                logger.debug("初始化过滤器链,url:{},perms:{}",url,urlFilter.getPermissions());
                filterChainManager.addToChain(url, "perms", urlFilter.getPermissions());
            }
        }


    }
}
