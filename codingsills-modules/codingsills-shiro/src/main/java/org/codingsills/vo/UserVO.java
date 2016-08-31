package org.codingsills.vo;

import java.util.List;

import org.codingsills.model.SysRole;
import org.codingsills.model.SysUser;

/**
 * 类功能描述
 * UserVO.java
 *
 * @date 2016年5月26日
 * 
 * @author Saber
 */
public class UserVO extends SysUser {

    private List<SysRole> roleList;

    private String roleIds;

    private String[] roleAry;

    public List<SysRole> getRoleList(){
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList){
        this.roleList = roleList;
    }

    public String getRoleIds(){
        return roleIds;
    }

    public void setRoleIds(String roleIds){
        this.roleIds = roleIds;
    }

    public String[] getRoleAry(){
        return roleAry;
    }

    public void setRoleAry(String[] roleAry){
        this.roleAry = roleAry;
    }
}
