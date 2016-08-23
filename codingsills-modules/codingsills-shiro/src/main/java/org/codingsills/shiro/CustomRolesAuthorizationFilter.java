package org.codingsills.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 自定义角色授权过滤器(满足任一角色即完成授权)
 * @see org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
 * @eg RolesAuthorizationFilter:满足所有角色才能授权
 * 
 * CustomRolesAuthorizationFilter.java
 *
 * @date 2016年8月23日
 * 
 * @author Saber
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,
            Object mappedValue) throws Exception{
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        for(int i=0;i<rolesArray.length;i++){
            if(subject.hasRole(rolesArray[i])){
                return true;
            }
        }
        return false;
    }
}
