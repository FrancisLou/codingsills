package org.codingsills.vo;

import org.codingsills.model.SysRole;

/**
 * 类功能描述
 * RoleVO.java
 *
 * @date 2016年4月12日
 * 
 * @author Saber
 */
public class RoleVO extends SysRole {

    private String resIds;
    
    public String getResIds(){
        return resIds;
    }

    
    public void setResIds(String resIds){
        this.resIds = resIds;
    }
}
