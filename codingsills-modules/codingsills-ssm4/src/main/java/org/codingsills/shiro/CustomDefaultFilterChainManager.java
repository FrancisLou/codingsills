package org.codingsills.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import org.apache.shiro.config.Ini;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.Nameable;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.apache.shiro.web.filter.mgt.SimpleNamedFilterList;

/**
 * 自定义过滤器链管理器
 * CustomDefaultFilterChainManager.java
 *
 * @date 2016年6月17日
 * 
 * @author Saber
 */
public class CustomDefaultFilterChainManager extends DefaultFilterChainManager {

    private Map<String, String> filterChainDefinitionMap;

    private String loginUrl;

    private String successUrl;

    private String unauthorizedUrl;

    /**
     * CustomDefaultFilterChainManager.java 默认构造
     */
    public CustomDefaultFilterChainManager(){
        setFilters(new LinkedHashMap<String, Filter>());
        setFilterChains(new LinkedHashMap<String, NamedFilterList>());
        addDefaultFilters(false);
    }

    public Map<String, String> getFilterChainDefinitionMap(){
        return filterChainDefinitionMap;
    }

    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap){
        this.filterChainDefinitionMap = filterChainDefinitionMap;
    }

    /**
     * 添加自定义过滤器
     * */
    public void setCustomFilters(Map<String, Filter> customFilters){
        for(Map.Entry<String, Filter> entry : customFilters.entrySet()){
            addFilter(entry.getKey(), entry.getValue(), false);
        }
    }

    public void setDefaultFilterChainDefinitions(String definitions){
        Ini ini = new Ini();
        ini.load(definitions);
        // 判断是否声明了“url”部分
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if(CollectionUtils.isEmpty(section)){
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        setFilterChainDefinitionMap(section);
    }

    public String getLoginUrl(){
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl){
        this.loginUrl = loginUrl;
    }

    public String getSuccessUrl(){
        return successUrl;
    }

    public void setSuccessUrl(String successUrl){
        this.successUrl = successUrl;
    }

    public String getUnauthorizedUrl(){
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl){
        this.unauthorizedUrl = unauthorizedUrl;
    }

    /**
     * CustomDefaultFilterChainManager实例化时被调用
     * */
    @PostConstruct
    public void init(){
        Map<String, Filter> filters = getFilters();
        if(!CollectionUtils.isEmpty(filters)){
            for(Map.Entry<String, Filter> entry : filters.entrySet()){
                String name = entry.getKey();
                Filter filter = entry.getValue();
                applyGlobalPropertiesIfNecessary(filter);
                if(filter instanceof Nameable){
                    ((Nameable)filter).setName(name);
                }
            }
        }
        Map<String, String> chains = getFilterChainDefinitionMap();
        if(!CollectionUtils.isEmpty(chains)){
            for(Map.Entry<String, String> entry : chains.entrySet()){
                String url = entry.getKey();
                String chainDefinition = entry.getValue();
                createChain(url, chainDefinition);
            }
        }
    }

    @Override
    protected void initFilter(Filter filter){
        // ingore
    }

    public FilterChain proxy(FilterChain original, List<String> chainNames){
        NamedFilterList configured = new SimpleNamedFilterList(chainNames.toString());
        for(String chainName : chainNames){
            configured.addAll(getChain(chainName));
        }
        return configured.proxy(original);
    }

    private void applyLoginUrlIfNecessary(Filter filter){
        String loginUrl = getLoginUrl();
        if(StringUtils.hasText(loginUrl) && (filter instanceof AccessControlFilter)){
            AccessControlFilter acFilter = (AccessControlFilter)filter;
            String existingLoginUrl = acFilter.getLoginUrl();
            // 只有在没有显式指定时才设置此loginUrl
            if(AccessControlFilter.DEFAULT_LOGIN_URL.equals(existingLoginUrl)){
                acFilter.setLoginUrl(loginUrl);
            }
        }
    }

    private void applySuccessUrlIfNecessary(Filter filter){
        String successUrl = getSuccessUrl();
        if(StringUtils.hasText(successUrl) && (filter instanceof AuthenticationFilter)){
            AuthenticationFilter authcFilter = (AuthenticationFilter)filter;
            String existingSuccessUrl = authcFilter.getSuccessUrl();
            if(AuthenticationFilter.DEFAULT_SUCCESS_URL.equals(existingSuccessUrl)){
                authcFilter.setSuccessUrl(successUrl);
            }
        }
    }

    private void applyUnauthorizedUrlIfNecessary(Filter filter){
        String unauthorizedUrl = getUnauthorizedUrl();
        if(StringUtils.hasText(unauthorizedUrl) && (filter instanceof AuthorizationFilter)){
            AuthorizationFilter authzFilter = (AuthorizationFilter)filter;
            String existingUnauthorizedUrl = authzFilter.getUnauthorizedUrl();
            if(existingUnauthorizedUrl == null){
                authzFilter.setUnauthorizedUrl(unauthorizedUrl);
            }
        }
    }

    private void applyGlobalPropertiesIfNecessary(Filter filter){
        applyLoginUrlIfNecessary(filter);
        applySuccessUrlIfNecessary(filter);
        applyUnauthorizedUrlIfNecessary(filter);
    }
}
