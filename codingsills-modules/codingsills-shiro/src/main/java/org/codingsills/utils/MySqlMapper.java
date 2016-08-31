package org.codingsills.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * MySQL主键自增长
 * MySqlMapper.java
 *
 * @date 2016年6月15日
 * 
 * @author Saber
 */
public interface MySqlMapper<T> extends InsertUseGeneratedKeysMapper<T> , Mapper<T>{
}
