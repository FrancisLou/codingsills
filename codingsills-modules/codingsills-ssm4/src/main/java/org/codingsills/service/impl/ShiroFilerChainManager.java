package org.codingsills.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.codingsills.model.SysResource;
import org.codingsills.service.UserService;
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
    public void initFilterChains(List<SysResource> resList){
        //1.删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if(defaultFilterChains != null){
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }
        List<String> parentList = new ArrayList<String>();
        //2.注册filter chain
        for(SysResource res : resList){
            if(!StringUtils.isEmpty(res.getPermission())){
                String prefix = res.getPermission().substring(0, res.getPermission().lastIndexOf(":"));
                String parentPms = prefix +":list";
                if(!parentList.contains(parentPms)){
                    //拥有子菜单权限必然拥有访问父菜单的权限
                    filterChainManager.addToChain("/"+prefix+"/list.t", UserService.PERMS,parentPms);
                    parentList.add(parentPms);
                }
                
                filterChainManager.addToChain(res.getUrl(), UserService.PERMS, res.getPermission());
            }
        }
    }
}
