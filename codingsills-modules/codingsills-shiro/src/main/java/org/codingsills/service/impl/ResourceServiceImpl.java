package org.codingsills.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.codingsills.constants.ResTypeEnum;
import org.codingsills.mapper.SysResourceMapper;
import org.codingsills.model.SysResource;
import org.codingsills.service.ResourceService;
import org.codingsills.vo.ResourceVO;
import org.codingsills.vo.TreeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 类功能描述
 * ResourceServiceImpl.java
 *
 * @date 2016年2月4日
 * 
 * @author Saber
 */
@Service("menuService")
public class ResourceServiceImpl extends BaseService<SysResource> implements ResourceService {

    @Autowired
    private SysResourceMapper resourceMapper;

    @Override
    public List<SysResource> selectByPage(SysResource menu, int page, int rows){
        Example example = new Example(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(menu.getName())){
            criteria.andLike("name", "%" + menu.getName() + "%");
        }
        if(menu.getParentId() > 0){
            criteria.andEqualTo("parentId", menu.getParentId());
        }
        if(menu.getId() != null){
            criteria.andEqualTo("id", menu.getId());
        }
        // 分页查询
        PageHelper.startPage(page, rows);
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<SysResource> selectBy(SysResource menu){
        Example example = new Example(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(menu.getName())){
            criteria.andLike("name", "%" + menu.getName() + "%");
        }
        if(menu.getParentId() > 0){
            criteria.andEqualTo("parentId", menu.getParentId());
        }
        if(menu.getId() != null){
            criteria.andEqualTo("id", menu.getId());
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<TreeVO> initMenu(ResTypeEnum resType){
        List<TreeVO> menuTree = new ArrayList<>();
        SysResource rootMenu = new SysResource();
        rootMenu.setParentId(0L);
        if(resType != null){
            rootMenu.setType(resType.getCode());
        }
        List<SysResource> pMenus = resourceMapper.select(rootMenu);
        if(pMenus != null && pMenus.size()>0){
            for(SysResource pMenu:pMenus){
                TreeVO tVO = new TreeVO(pMenu);
                iteratorMenu(tVO,resType);
                menuTree.add(tVO);
            }
        }
        return menuTree;
    }

    private void iteratorMenu(TreeVO ptVO,ResTypeEnum resType){
        SysResource menuParam = new SysResource();
        menuParam.setParentId(ptVO.getId());
        if(resType != null){
            menuParam.setType(resType.getCode());
        }
        List<SysResource> childList = resourceMapper.select(menuParam);
        if(childList != null && !childList.isEmpty()){
            List<TreeVO> childTree = new ArrayList<>();
            for(SysResource childMenu : childList){
                TreeVO childTVO = new TreeVO(childMenu);
                iteratorMenu(childTVO,resType);
                childTree.add(childTVO);
            }
            ptVO.setNodes(childTree);
        }
    }

    @Override
    public void saveMenu(ResourceVO menuVO){
        SysResource tm = new SysResource();
        BeanUtils.copyProperties(menuVO, tm);
        this.save(tm);
    }

    @Override
    public void updateMenu(ResourceVO menuVO){
        SysResource tm = new SysResource();
        BeanUtils.copyProperties(menuVO, tm);
        this.updateNotNull(tm);
    }
}
