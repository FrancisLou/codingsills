package org.codingsills.web.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.codingsills.constants.ResTypeEnum;
import org.codingsills.model.SysUser;
import org.codingsills.service.ResourceService;
import org.codingsills.service.UserService;
import org.codingsills.vo.TreeVO;
import org.codingsills.web.bind.annotation.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private ResourceService resourceService;
    
    @Resource
    private UserService userService;
    
    @RequestMapping("/")
    public String index(@CurrentUser SysUser loginUser, Model model) {
        //TODO 根据用户名获取用户菜单
        /*Set<String> permissions = userService.findPermissions(loginUser.getUserName());
        List<Resource> menus = resourceService.findMenus(permissions);*/
        model.addAttribute("menus", resourceService.initMenu(ResTypeEnum.MENU));
        return "main";
    }
    
    /*@RequestMapping(value="/userLogin.t")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout){
        ModelAndView mav = new ModelAndView("login");
        //TODO
        if(error == null){
            List<TreeVO> menuList = resourceService.initMenu(ResTypeEnum.MENU);
            
            logger.debug("菜单个数{}",menuList.size());
            
            mav = new ModelAndView("main");
            
            mav.addObject("menus", menuList);
        }else{
            
        }
        
        return mav;
    }*/
    @RequestMapping(value = "/login.t")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
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

    
}
