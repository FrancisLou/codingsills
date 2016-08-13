package org.codingsills.service;

import java.util.Map;
import java.util.Set;

import org.codingsills.model.SysUser;
import org.codingsills.utils.PageObject;
import org.codingsills.vo.UserVO;

/**
 * 类功能描述
 * UserService.java
 *
 * @date 2016年2月17日
 * 
 * @author Saber
 */
public interface UserService extends IService<SysUser>{
    
    public static final String ROLES = "roles";
    
    public static final String PERMS = "perms";
    
    public PageObject<SysUser> pageBy(SysUser user,int page,int rows);
    
    public SysUser getByName(String userName);
    
    public UserVO getUser(Long id);
    
    public void addUser(UserVO user);
    
    public void updateUser(UserVO user);
    
    public void deleteUser(Long id);
    
    public Map<String,Set<String>> findRolesAndPermissions(String userName);
    
}
