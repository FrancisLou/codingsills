package org.codingsills.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.codingsills.entity.UrlFilter;
import org.codingsills.mapper.RRoleResourceMapper;
import org.codingsills.mapper.SysResourceMapper;
import org.codingsills.mapper.SysRoleMapper;
import org.codingsills.model.RRoleResource;
import org.codingsills.model.SysResource;
import org.codingsills.model.SysRole;
import org.codingsills.modules.utils.Collections3;
import org.codingsills.service.RoleService;
import org.codingsills.utils.PageObject;
import org.codingsills.vo.RoleVO;
import org.codingsills.vo.TreeNodeVO;
import org.codingsills.vo.TreeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 角色管理业务层
 * RoleServiceImpl.java
 *
 * @date 2016年2月17日
 * 
 * @author Saber
 */
@Service(value="roleService")
public class RoleServiceImpl extends BaseService<SysRole> implements RoleService{

    @Autowired
    private SysRoleMapper roleMapper;
    
    @Resource
    private SysResourceMapper resourceMapper;
    
    @Resource
    private RRoleResourceMapper roleResMapper;
    
    @Autowired
    private ShiroFilerChainManager shiroFilerChainManager;
    
    @Override
    public PageObject<SysRole> pageBy(SysRole role, int page, int rows){
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(role.getRoleCn())){
            criteria.andLike("roleCn", "%" + role.getRoleCn() + "%");
        }
        if(role.getId() != null){
            criteria.andEqualTo("id", role.getId());
        }
        // 分页查询
        Page<SysRole> pageObj = PageHelper.startPage(page, rows);
        List<SysRole> list = roleMapper.selectByExample(example);
        
        PageObject<SysRole> pageResult = new PageObject<>(pageObj, list);
        
        return pageResult;
    }

    @Override
    public List<SysRole> getAllRoles(){
        return roleMapper.selectAll();
    }

    @Override
    public List<String> getResourceByRole(String roleCode){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addRole(RoleVO role){
        role.setAvailable(true);
        insertAuto(role);
        if(StringUtil.isNotEmpty(role.getResIds())){
            String[] resIds = role.getResIds().split(",");
            for(String resId : resIds){
                RRoleResource roleRes = new RRoleResource();
                roleRes.setResourceId(Long.valueOf(resId));
                roleRes.setRoleId(role.getId());
                roleResMapper.insert(roleRes);
            }
        }
        initFilterChain();
    }

    @Override
    public void updateRole(RoleVO role){
        //更新角色信息
        updateNotNull(role);
        RRoleResource roleResPara = new RRoleResource();
        roleResPara.setRoleId(role.getId());
        roleResMapper.delete(roleResPara);
        //重新建立角色资源关联关系
        if(StringUtil.isNotEmpty(role.getResIds())){
            String[] resIds = role.getResIds().split(",");
            for(String resId : resIds){
                RRoleResource roleRes = new RRoleResource();
                roleRes.setResourceId(Long.valueOf(resId));
                roleRes.setRoleId(role.getId());
                roleResMapper.insert(roleRes);
            }
        }
        initFilterChain();
    }

    @Override
    public RoleVO getRole(Long id){
        SysRole role = selectByKey(id);
        if(role == null) return null;
        RoleVO roleVO = new RoleVO();
        BeanUtils.copyProperties(role, roleVO);
        
        RRoleResource roleRes = new RRoleResource();
        roleRes.setRoleId(role.getId());
        List<RRoleResource> roleResList = roleResMapper.select(roleRes);
        if(roleResList != null && !roleResList.isEmpty()){
            roleVO.setResIds(Collections3.extractToString(roleResList, "resourceId", ","));;
        }

        return roleVO;
    }

    @Override
    public void deleteRole(Long id){
        //删除权限、删除角色
        RRoleResource roleRes = new RRoleResource();
        roleRes.setRoleId(id);
        roleResMapper.delete(roleRes);
        roleMapper.deleteByPrimaryKey(id);
        initFilterChain();
    }

    @Override
    public List<TreeVO> initRoleMenu(Long roleId){
        RoleVO roleVO = getRole(roleId);
        List<String> menuIdList = null;
        if(roleVO != null){
            if(StringUtil.isNotEmpty(roleVO.getResIds())){
                String[] menuIds = roleVO.getResIds().split(",");
                menuIdList = Arrays.asList(menuIds);
            }
        }
        List<TreeVO> menuTree = new ArrayList<TreeVO>();
        SysResource rootMenu = new SysResource();
        rootMenu.setParentId(0L);

        List<SysResource> pMenus = resourceMapper.select(rootMenu);
        if(pMenus != null && pMenus.size()>0){
            for(SysResource pMenu:pMenus){
                TreeVO tVO = new TreeVO(pMenu);
                if(menuIdList != null && menuIdList.contains(String.valueOf(tVO.getId()))){
                    TreeNodeVO nodeState = new TreeNodeVO();
                    nodeState.setChecked(true);
                    tVO.setState(nodeState); 
                }
                iteratorMenu(tVO,menuIdList);
                menuTree.add(tVO);
            }
        }
        return menuTree;
    }
    
    private void iteratorMenu(TreeVO ptVO,List<String> hasMenus){
        SysResource menuParam = new SysResource();
        menuParam.setParentId(ptVO.getId());
        
        List<SysResource> childList = resourceMapper.select(menuParam);
        if(childList != null && !childList.isEmpty()){
            List<TreeVO> childTree = new ArrayList<>();
            for(SysResource childMenu : childList){
                TreeVO childTVO = new TreeVO(childMenu);
                if(hasMenus != null && hasMenus.contains(String.valueOf(childTVO.getId()))){
                    TreeNodeVO nodeState = new TreeNodeVO();
                    nodeState.setChecked(true);
                    childTVO.setState(nodeState); 
                }
                iteratorMenu(childTVO,hasMenus);
                childTree.add(childTVO);
            }
            ptVO.setNodes(childTree);
        }
    }

	@Override
	public List<UrlFilter> buildUrlFilter() {
		List<UrlFilter> filterList = new ArrayList<UrlFilter>();
		List<SysResource> resList = resourceMapper.selectAll();
		for(SysResource res : resList){
			UrlFilter filter = new UrlFilter();
			if(String.valueOf(res.getParentId()).equals("0")){
				continue;
			}
			//根据资源查角色
			RRoleResource roleResParam = new RRoleResource();
			roleResParam.setResourceId(res.getId());
			List<RRoleResource> roleResList = roleResMapper.select(roleResParam);
			List<String> roleList = new ArrayList<String>();
			if(roleResList != null && roleResList.size() > 0){
				for(RRoleResource roleRes : roleResList){
					SysRole sysRole = roleMapper.selectByPrimaryKey(roleRes.getRoleId());
					if(sysRole != null){
						roleList.add(sysRole.getRole());
					}
				}
			}
			//设置角色
			filter.setRoles(list2Str(roleList));
			//设置权限
			filter.setPermissions(res.getPermission());
			//设置请求路径
			filter.setUrl(res.getUrl());
			filter.setName(res.getName());
			
			filterList.add(filter);
		}

		return filterList;
	}
	
	private String list2Str(List<String> strList){
    	if(strList == null || strList.isEmpty()){
    		return "";
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<strList.size();i++){
    		sb.append(strList.get(i));
    		if(i < strList.size() -1){
    			sb.append(",");
    		}
    	}
    	
    	return sb.toString();
    }
	
	@PostConstruct
    public void initFilterChain() {
        shiroFilerChainManager.initFilterChains(buildUrlFilter());
    }
}
