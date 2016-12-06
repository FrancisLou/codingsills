package org.codingsills.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.codingsills.model.SysResource;
import org.codingsills.service.UserService;
import org.codingsills.vo.TreeVO;
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
    
    @Resource
    private UserService userService;
    
	@RequestMapping("/")
    public String index(Model model) {
        //根据用户名获取用户菜单
        List<SysResource> menuList = userService.findMenuBy((String)SecurityUtils.getSubject().getPrincipal());
        List<TreeVO> treeVos = null;
        List<SysResource> childList = new ArrayList<SysResource>();
        if(menuList != null && menuList.size() > 0){
        	Map<Long,TreeVO> menuMap = new HashMap<Long,TreeVO>();
        	for(SysResource sysRes : menuList){
        		if(sysRes.getParentId().equals(0L)){//筛选一级菜单
        			menuMap.put(sysRes.getId(), new TreeVO(sysRes));
        		}else{
        			childList.add(sysRes);
        		}
        	}
        	for(SysResource sysRes2 : childList){
        		if(menuMap.keySet().contains(sysRes2.getParentId())){//筛选二级菜单
        			List<TreeVO> childTrees = menuMap.get(sysRes2.getParentId()).getNodes();
        			if(childTrees == null){
        				childTrees = new ArrayList<TreeVO>();
        			}
        			childTrees.add(new TreeVO(sysRes2));	
        			menuMap.get(sysRes2.getParentId()).setNodes(childTrees);
        		}
        	}
        	treeVos = new ArrayList<TreeVO>(menuMap.values());
        }
        model.addAttribute("menus", treeVos);
        model.addAttribute("currentUser", SecurityUtils.getSubject().getPrincipal());
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
        	if(exceptionClassName.equals("jcaptcha.error")){
        		error = "验证码错误";
        	}else{
        		error = "其他错误：" + exceptionClassName;
        	}
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
