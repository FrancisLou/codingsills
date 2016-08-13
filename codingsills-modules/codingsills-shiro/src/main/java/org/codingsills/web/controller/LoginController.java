package org.codingsills.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.codingsills.constants.ResTypeEnum;
import org.codingsills.model.SysResource;
import org.codingsills.model.SysUser;
import org.codingsills.service.ResourceService;
import org.codingsills.service.UserService;
import org.codingsills.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 类功能描述
 * LoginController.java
 *
 * @date 2016年2月4日
 * 
 * @author Saber
 */
@Controller
public class LoginController {
    
    @Autowired
    private ResourceService resourceService;
    
    @Resource
    private UserService userService;
    
    @SuppressWarnings("unused")
	@RequestMapping("/")
    public String index(@CurrentUser SysUser loginUser, Model model) {
        //TODO 根据用户名获取用户菜单
        List<SysResource> menuList = userService.findMenuBy(loginUser.getUserName());
        /*Set<String> permissions = userService.findPermissions(loginUser.getUserName());
        List<Resource> menus = resourceService.findMenus(permissions);*/
        
        model.addAttribute("menus", resourceService.initMenu(ResTypeEnum.MENU));
        return "main";
    }
    
    @RequestMapping(value = "/login.t")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }
    
    @RequestMapping(value="/logout.t")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
    }

    
}
