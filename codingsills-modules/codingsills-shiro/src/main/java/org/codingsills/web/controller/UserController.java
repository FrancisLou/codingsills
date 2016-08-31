package org.codingsills.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.codingsills.model.SysRole;
import org.codingsills.model.SysUser;
import org.codingsills.service.RoleService;
import org.codingsills.service.UserService;
import org.codingsills.utils.PageObject;
import org.codingsills.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类功能描述
 * UserController.java
 *
 * @date 2016年2月17日
 * 
 * @author Saber
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value = "/list.t")
    public ModelAndView getList(){
        ModelAndView result = new ModelAndView("user/list");
        return result;
    }
    
    @RequestMapping(value="query.json")
    @ResponseBody
    public Object query(UserVO user,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows){
        PageObject<SysUser> pageObj = userService.pageBy(user, page, rows);
        return pageObj;
    }
    
    @RequestMapping(value="addUser.t",method=RequestMethod.GET)
    public ModelAndView toAddView(){
        ModelAndView mav = new ModelAndView("user/add");
        List<SysRole> allRoles = roleService.getAllRoles();
        mav.addObject("roles",allRoles);
        return mav;
    }
    
    @RequestMapping(value="addUser.t",method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute(value="user")UserVO user){
        ModelAndView mav = new ModelAndView("user/list");
        userService.addUser(user);
        return mav;
    }
    
    @RequestMapping(value="editUser.t",method=RequestMethod.GET)
    public ModelAndView toEditView(@RequestParam Long id){
        ModelAndView mav = new ModelAndView("user/edit");
        UserVO user = userService.getUser(id);
        List<SysRole> allRoles = roleService.getAllRoles();
        mav.addObject("roles",allRoles);
        mav.addObject("user", user);
        mav.addObject("userRole",getRoleIdAry(user.getRoleList()));
        return mav;
    }
    
    @RequestMapping(value="editUser.t",method=RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute(value="user") UserVO user){
        ModelAndView mav = new ModelAndView("user/list");
        userService.updateUser(user);
        return mav;
    }
    
    @RequestMapping(value="deleteUser.t",method=RequestMethod.GET)
    public ModelAndView deleteUserById(@RequestParam Long id){
        ModelAndView mav = new ModelAndView("user/list");
        userService.deleteUser(id);
        return mav;
    }
    
    private List<Long> getRoleIdAry(List<SysRole> roleList){
        List<Long> roleIds = new ArrayList<Long>();
        if(roleList != null && !roleList.isEmpty()){
            for(int i = 0; i < roleList.size(); i++){
                roleIds.add(roleList.get(i).getId());
            }
        }
        return roleIds;
    }

}
