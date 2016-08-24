package org.codingsills.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.util.CollectionUtils;
import org.codingsills.constants.ResTypeEnum;
import org.codingsills.mapper.RRoleResourceMapper;
import org.codingsills.mapper.RUserRoleMapper;
import org.codingsills.mapper.SysResourceMapper;
import org.codingsills.mapper.SysRoleMapper;
import org.codingsills.mapper.SysUserMapper;
import org.codingsills.model.RRoleResource;
import org.codingsills.model.RUserRole;
import org.codingsills.model.SysResource;
import org.codingsills.model.SysRole;
import org.codingsills.model.SysUser;
import org.codingsills.service.UserService;
import org.codingsills.utils.PageObject;
import org.codingsills.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 类功能描述
 * UserService.java
 *
 * @date 2016年2月17日
 * 
 * @author Saber
 */
@Service("userService")
public class UserServiceImpl extends BaseService<SysUser> implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private RUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleMapper roleMapper;
    
    @Resource
    private SysResourceMapper resourceMapper;
    
    @Resource
    private RRoleResourceMapper roleResMapper;
    
    @Resource
    private PasswordHelper passwordHelper;
    
    @Override
    public PageObject<SysUser> pageBy(SysUser user, int page, int rows){
        Example example = new Example(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(user.getUserName())){
            criteria.andLike("name", "%" + user.getUserName() + "%");
        }
        if(user.getId() != null){
            criteria.andEqualTo("id", user.getId());
        }
        // 分页查询
        Page<SysUser> pageObj = PageHelper.startPage(page, rows);
        List<SysUser> list = userMapper.selectByExample(example);
        PageObject<SysUser> pageResult = new PageObject<>(pageObj, list);
        return pageResult;
    }

    @Override
    public SysUser getByName(String userName){
        Example example = new Example(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(userName)){
            criteria.andEqualTo(userName);
        }else{
            return null;
        }
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public UserVO getUser(Long id){
        SysUser tbUser = userMapper.selectByPrimaryKey(id);
        if(tbUser == null) return null;
        // 查询用户拥有的角色
        RUserRole userRole = new RUserRole();
        userRole.setUserId(id);
        List<RUserRole> list = userRoleMapper.select(userRole);
        List<SysRole> roleList = null;
        if(list != null && !list.isEmpty()){
            roleList = new ArrayList<SysRole>();
            for(RUserRole ur : list){
                SysRole tbRole = roleMapper.selectByPrimaryKey(ur.getRoleId());
                if(tbRole != null){
                    roleList.add(tbRole);
                }
            }
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(tbUser, userVO);
        if(roleList != null){
            userVO.setRoleList(roleList);
        }
        return userVO;
    }

    @Override
    public void addUser(UserVO user){
        passwordHelper.encryptPassword(user);
        userMapper.insertUseGeneratedKeys(user);
        // 建立用户与角色关系
        String[] roleIdAry = user.getRoleAry();
        if((roleIdAry != null) && (roleIdAry.length > 0)){
            for(String roleId : roleIdAry){
                RUserRole userRole = new RUserRole();
                userRole.setRoleId(Long.valueOf(roleId));
                userRole.setUserId(user.getId());
                userRoleMapper.insert(userRole);
            }
        }
    }

    @Override
    public void updateUser(UserVO user){
        userMapper.updateByPrimaryKeySelective(user);
        // 删除用户角色关联关系
        RUserRole tbUr = new RUserRole();
        tbUr.setUserId(user.getId());
        userRoleMapper.delete(tbUr);
        // 建立用户与角色关系
        String[] roleIdAry = user.getRoleAry();
        if((roleIdAry != null) && (roleIdAry.length > 0)){
            for(String roleId : roleIdAry){
                RUserRole userRole = new RUserRole();
                userRole.setRoleId(Long.valueOf(roleId));
                userRole.setUserId(user.getId());
                userRoleMapper.insert(userRole);
            }
        }
    }

    @Override
    public void deleteUser(Long id){
        // 删除用户角色关联关系
        RUserRole tbUr = new RUserRole();
        tbUr.setUserId(id);
        userRoleMapper.delete(tbUr);
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据用户名获取角色
     * */
    @Override
    public Map<String,Set<String>> findRolesAndPermissions(String userName){
        Map<String,Set<String>> rolePermsMap = new HashMap<String, Set<String>>();
        Set<String> roleSet = null;
        Set<String> permSet = null;
        SysUser user = getByName(userName);
        if(user == null) return null;
        RUserRole urPara = new RUserRole();
        urPara.setUserId(user.getId());
        List<RUserRole> urList = userRoleMapper.select(urPara);
        if(!CollectionUtils.isEmpty(urList)){
            roleSet = new HashSet<String>();
            permSet = new HashSet<String>();
            for(RUserRole userRole : urList){
                SysRole role = roleMapper.selectByPrimaryKey(userRole.getRoleId());
                roleSet.add(role.getRole());
                RRoleResource roleRes = new RRoleResource();
                roleRes.setRoleId(role.getId());
                List<RRoleResource> roleResList = roleResMapper.select(roleRes);
                if(!CollectionUtils.isEmpty(roleResList)){
                    for(RRoleResource rroleRes: roleResList){
                        SysResource res = resourceMapper.selectByPrimaryKey(rroleRes.getResourceId());
                        if(!StringUtils.isEmpty(res.getPermission())){
                            permSet.add(res.getPermission());
                            String parentPerm = res.getPermission().substring(0, res.getPermission().lastIndexOf(":"))+":list";
                            if(!permSet.contains(parentPerm)){
                                permSet.add(parentPerm);
                            }
                        }
                    }
                }
            }
        }
        rolePermsMap.put(UserService.ROLES, roleSet);
        rolePermsMap.put(UserService.PERMS, permSet);
        
        return rolePermsMap;
    }

    @Override
    public List<SysResource> findMenuBy(String userName){
        SysUser user = getByName(userName);
        if(user == null) return null;
        RUserRole urPara = new RUserRole();
        urPara.setUserId(user.getId());
        List<RUserRole> urList = userRoleMapper.select(urPara);
        if(urList == null || urList.isEmpty()) return null;
        Set<Long> resIdSet = new HashSet<Long>();
        for(RUserRole ur : urList){
            RRoleResource roleRes = new RRoleResource();
            roleRes.setRoleId(ur.getRoleId());
            List<RRoleResource> roleResList = roleResMapper.select(roleRes);
            if(roleResList == null || roleResList.isEmpty()) continue;
            for(RRoleResource rres : roleResList){
                resIdSet.add(rres.getResourceId());
            }
        }
        if(resIdSet.isEmpty()) return null;
        List<SysResource> sysResList = new ArrayList<SysResource>();
        for(Long resId:resIdSet){
            SysResource sres = resourceMapper.selectByPrimaryKey(resId);
            if(sres.getType().equals(ResTypeEnum.MENU.getCode())){
                sysResList.add(sres);
            }
        }
        return sysResList;
    }

    @Override
    public void changePassword(Long userId, String newPassword){
        SysUser user =  userMapper.selectByPrimaryKey(userId);;
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
