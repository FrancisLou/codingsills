package org.codingsills.service;

import java.util.List;

import org.codingsills.model.SysRole;
import org.codingsills.utils.PageObject;
import org.codingsills.vo.RoleVO;
import org.codingsills.vo.TreeVO;

/**
 * 类功能描述
 * RoleService.java
 *
 * @date 2016年2月17日
 * 
 * @author Saber
 */
public interface RoleService extends IService<SysRole>{
    
    public PageObject<SysRole> pageBy(SysRole role,int page,int rows);
    
    public List<SysRole> getAllRoles();
    
    /**
     * 根据角色Code查询角色所拥有资源的URL
     * @param roleCode 
     *          角色Code
     * @return List<String>
     * */
    public List<String> getResourceByRole(String roleCode);
    
    public void addRole(RoleVO role);
    
    public void updateRole(RoleVO role);
    
    public RoleVO getRole(Long id);
    
    public void deleteRole(Long id);
    
    public List<TreeVO> initRoleMenu(Long roleId);
}
