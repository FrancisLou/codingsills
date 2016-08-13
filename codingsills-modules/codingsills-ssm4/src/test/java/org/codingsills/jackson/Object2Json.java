package org.codingsills.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codingsills.model.SysResource;
import org.codingsills.vo.TreeVO;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 类功能描述
 * Object2Json.java
 *
 * @date 2016年2月14日
 * 
 * @author Saber
 */
public class Object2Json {
    
    public static void main(String[] args) throws IOException{
        SysResource menu = new SysResource();
        menu.setId(1L);
        menu.setUrl("/");
        menu.setName("测试");
        menu.setParentId(0L);
        menu.setWeight(1);
        menu.setIcon("fa fa-gear");
        TreeVO treeVO = new TreeVO(menu);
        
        List<TreeVO> list = new ArrayList<>();
        list.add(treeVO);
        
        ObjectMapper objMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = objMapper.getFactory().createGenerator(System.out,JsonEncoding.UTF8);
        jsonGenerator.writeObject(list);
    }
}
