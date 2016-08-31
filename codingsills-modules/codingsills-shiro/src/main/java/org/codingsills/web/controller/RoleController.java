package org.codingsills.web.controller;

import java.util.List;

import org.codingsills.model.SysRole;
import org.codingsills.service.RoleService;
import org.codingsills.utils.PageObject;
import org.codingsills.vo.RoleVO;
import org.codingsills.vo.TreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 类功能描述
 * RoleController.java
 *
 * @date 2016年2月17日
 * 
 * @author Saber
 */
@Controller
@RequestMapping(value="/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value="list.t")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("role/list");
        
        return mav;
    }
    
    @RequestMapping(value="query.json")
    @ResponseBody
    public Object query(RoleVO role,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows){
        
        PageObject<SysRole> pageObj = roleService.pageBy(role, page, rows);
        
        return pageObj;
    }
    
    @RequestMapping(value="addRole.t",method=RequestMethod.GET)
    public ModelAndView toAddView(){
        ModelAndView mav = new ModelAndView("role/add");
        
        return mav;
    }
    
    @RequestMapping(value="addRole.t",method=RequestMethod.POST)
    public ModelAndView addRole(@ModelAttribute(value="role") RoleVO role){
        ModelAndView mav = new ModelAndView("role/list");
        roleService.addRole(role);
        
        return mav;
    }
    
    @RequestMapping(value="editRole.t",method=RequestMethod.GET)
    public ModelAndView toEditView(@RequestParam Long id){
        ModelAndView mav = new ModelAndView("role/edit");
        
        RoleVO roleVO = roleService.getRole(id);
        
        mav.addObject("role", roleVO);
        
        return mav;
    }
    
    @RequestMapping(value="editRole.t",method=RequestMethod.POST)
    public ModelAndView editRole(@ModelAttribute(value="role") RoleVO role){
        ModelAndView mav = new ModelAndView("role/list");
        
        roleService.updateRole(role);
        return mav;
    }
    
    @RequestMapping(value="deleteRole.t",method=RequestMethod.GET)
    public ModelAndView delRole(@RequestParam(required = true,value="id") Long id){
        ModelAndView mav = new ModelAndView("role/list");
        roleService.deleteRole(id);
        
        return mav;
    }
    
    @ResponseBody
    @RequestMapping("/showRoleMenu.json")
    public String showRoleMenu(@RequestParam Long roleId) throws JsonProcessingException{
        List<TreeVO> menuList = roleService.initRoleMenu(roleId);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_EMPTY);

        return mapper.writeValueAsString(menuList);
    }
}
