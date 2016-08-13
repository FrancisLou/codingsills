package org.codingsills.service.impl;

import org.codingsills.service.IService;
import org.codingsills.utils.MySqlMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseService<T> implements IService<T> {

    @Autowired
    protected MySqlMapper<T> mapper;

    public MySqlMapper<T> getMapper() {
        return mapper;
    }

    @Override
    public int insertAuto(T entity){
        return mapper.insertUseGeneratedKeys(entity);
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
    
    //TODO 其他...
}
