package org.codingsills.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.codingsills.model.SysResource;
import org.codingsills.service.ResourceService;
import org.codingsills.vo.ResourceVO;
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
 * MenuController.java
 *
 * @date 2016年2月4日
 * 
 * @author Saber
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    
    @Autowired
    private ResourceService resourceService;
    
    @ResponseBody
    @RequestMapping("/getTreeJson.json")
    public String getTreeJson() throws JsonProcessingException{
        List<TreeVO> list = resourceService.initMenu(null);
        TreeVO root = new TreeVO();
        root.setText("M+");
        root.setIcon("fa fa-home");
        root.setId(0L);
        root.setColor("#000000");
        root.setBackColor("#FFFFFF");
        root.setNodes(list);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        List<TreeVO> newList = new ArrayList<TreeVO>();
        newList.add(root);
        return mapper.writeValueAsString(newList);
    }
    
    @RequestMapping("/list.t")
    public ModelAndView view(){
        ModelAndView mav = new ModelAndView("resource/menuView");
        
        return mav;
    }
    
    @RequestMapping(value = "/addMenu.t",method=RequestMethod.GET)
    public ModelAndView toAddView(@RequestParam(name = "parentId") String parentId){
        ModelAndView mav = new ModelAndView("resource/addMenu");
        mav.addObject("parentId", parentId);
        return mav;
    }

    @RequestMapping(value = "/addMenu.t",method=RequestMethod.POST)
    public ModelAndView addMenu(@ModelAttribute(value = "menuVO") ResourceVO menuVO){
        ModelAndView mav = new ModelAndView("resource/menuView");
        resourceService.saveMenu(menuVO);
        return mav;
    }

    @RequestMapping(value = "/editMenu.t",method=RequestMethod.GET)
    public ModelAndView toModifyView(@RequestParam(name = "menuId") Long menuId){
        ModelAndView mav = new ModelAndView("resource/modifyMenu");
        SysResource tmenu = resourceService.selectByKey(menuId);
        mav.addObject("menu", tmenu);
        return mav;
    }

    @RequestMapping(value = "/editMenu.t",method=RequestMethod.POST)
    public ModelAndView modifyMenu(@ModelAttribute(value = "menuVO") ResourceVO menuVO){
        ModelAndView mav = new ModelAndView("resource/menuView");
        resourceService.updateMenu(menuVO);
        return mav;
    }
    
}
