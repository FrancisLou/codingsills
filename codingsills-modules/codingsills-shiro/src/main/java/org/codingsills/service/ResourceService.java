package org.codingsills.service;

import java.util.List;

import org.codingsills.constants.ResTypeEnum;
import org.codingsills.model.SysResource;
import org.codingsills.vo.ResourceVO;
import org.codingsills.vo.TreeVO;

/**
 * 类功能描述
 * ResourceService.java
 *
 * @date 2016年2月4日
 * 
 * @author Saber
 */
public interface ResourceService extends IService<SysResource>{
    
    /**
     * 分页查询
     * 
     * */
    public List<SysResource> selectByPage(SysResource res,int page,int rows);
    
    /**
     * 根据条件查询
     * */
    public List<SysResource> selectBy(SysResource res);
    
    /**
     * 初始化菜单树
     * */
    public List<TreeVO> initMenu(ResTypeEnum resType);
    
    /**
     * 保存菜单信息
     * */
    public void saveMenu(ResourceVO menuVO);
    
    /**
     * 更新菜单信息
     * */
    public void updateMenu(ResourceVO menuVO);
}
