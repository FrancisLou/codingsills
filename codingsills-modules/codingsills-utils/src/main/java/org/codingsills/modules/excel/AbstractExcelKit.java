package org.codingsills.modules.excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Excel工具抽象类
 * ExcelHelper.java
 *
 * @date 2016年1月21日
 * 
 * @author Saber
 */
public abstract class AbstractExcelKit {

    /**
     * 对象序列化版本号名称
     */
    public static final String UID = "serialVersionUID";
    /**
     * 将指定excel文件中的数据转换成数据列表
     * 
     * @param clazz
     *            数据类型
     * @param hasTitle
     *            是否带有标题
     * @return 返回转换后的数据列表
     * @throws Exception
     */
    public <T> List<T> readExcel(Class<T> clazz, boolean hasTitle) throws Exception{
        return readExcel(clazz, 0, hasTitle);
    }
    
    /**
     * 将指定excel文件中的数据转换成数据列表
     * 
     * @param clazz
     *            数据类型
     * @param sheetNo
     *            工作表编号
     * @param hasTitle
     *            是否带有标题
     * @return 返回转换后的数据列表
     * @throws Exception
     */
    public <T> List<T> readExcel(Class<T> clazz, int sheetNo, boolean hasTitle) throws Exception{
        return readExcelExclude(clazz, sheetNo, hasTitle,null);
    }

    /**
     * 将指定excel文件中的数据转换成数据列表
     * 
     * @param clazz
     *            数据类型
     * @param sheetNo
     *            工作表编号
     * @param hasTitle
     *            是否带有标题
     * @return 返回转换后的数据列表
     * @throws Exception
     */
    public <T> List<T> readExcelExclude(Class<T> clazz, int sheetNo, boolean hasTitle,
            List<String> excludeFields) throws Exception{
        LinkedList<String> validFields = getFieldsExculde(clazz, excludeFields);
        return readExcel(clazz, validFields, sheetNo, hasTitle);
    }

    /**
     * 将指定excel文件中的数据转换成数据列表
     * 
     * @param clazz
     *            数据类型
     * @param fieldNames
     *            属性列表
     * @param hasTitle
     *            是否带有标题
     * @return 返回转换后的数据列表
     * @throws Exception
     */
    public <T> List<T> readExcel(Class<T> clazz, List<String> fieldNames, boolean hasTitle)
            throws Exception{
        return readExcel(clazz, fieldNames, 0, hasTitle);
    }

    /**
     * 抽象方法：将指定excel文件中的数据转换成数据列表，由子类实现
     * 
     * @param clazz
     *            数据类型
     * @param fieldNames
     *            属性列表
     * @param sheetNo
     *            工作表编号
     * @param hasTitle
     *            是否带有标题
     * @return 返回转换后的数据列表
     * @throws Exception
     */
    public abstract <T> List<T> readExcel(Class<T> clazz, List<String> fieldNames, int sheetNo,
            boolean hasTitle) throws Exception;

    /**
     * 写入数据到指定excel文件中
     * 
     * @param clazz
     *            数据类型
     * @param dataModels
     *            数据列表
     * @throws Exception
     */
    public <T> void writeExcelExclude(Class<T> clazz, List<T> dataModels,
            List<String> excludeFields) throws Exception{
        LinkedList<String> validFields = getFieldsExculde(clazz, excludeFields);
        writeExcel(clazz, dataModels, validFields, validFields);
    }
    
    /**
     * 写入数据到指定excel文件中
     * 
     * @param clazz
     *            数据类型
     * @param dataModels
     *            数据列表
     * @throws Exception
     */
    public <T> void writeExcelExclude(Class<T> clazz, List<T> dataModels,
            List<String> excludeFields,List<String> titles) throws Exception{
        LinkedList<String> validFields = getFieldsExculde(clazz, excludeFields);
        writeExcel(clazz, dataModels, validFields, titles);
    }

    /**
     * 写入数据到指定excel文件中
     * 
     * @param clazz
     *            数据类型
     * @param dataModels
     *            数据列表
     * @param fieldNames
     *            属性列表
     * @throws Exception
     */
    public <T> void writeExcel(Class<T> clazz, List<T> dataModels, List<String> fieldNames)
            throws Exception{
        writeExcel(clazz, dataModels, fieldNames, fieldNames);
    }

    /**
     * 抽象方法：写入数据到指定excel文件中，由子类实现
     * 
     * @param clazz
     *            数据类型
     * @param dataModels
     *            数据列表
     * @param fieldNames
     *            属性列表
     * @param titles
     *            标题列表
     * @throws Exception
     */
    public abstract <T> void writeExcel(Class<T> clazz, List<T> dataModels, List<String> fieldNames,
            List<String> titles) throws Exception;

    /**
     * 获取实体类所需元素
     * @param clazz
     *          数据类型
     * @param excludeFields
     *          需要排除的属性名
     * @return 有效的属性名
     * */
    protected <T> LinkedList<String> getFieldsExculde(Class<T> clazz, List<String> excludeFields){
        Field[] fields = clazz.getDeclaredFields();
        LinkedList<String> llist = new LinkedList<String>();
        // 默认排除UID
        if(excludeFields == null){
            excludeFields = new ArrayList<String>();
        }
        excludeFields.add(UID);
        for(int i = 0; i < fields.length; i++){
            String fieldName = fields[i].getName();
            if(excludeFields.contains(fieldName)){
                continue;
            }
            llist.add(fieldName);
        }
        return llist;
    }

    /**
     * 判断属性是否为日期类型
     * 
     * @param clazz
     *            数据类型
     * @param fieldName
     *            属性名
     * @return 如果为日期类型返回true，否则返回false
     */
    protected <T> boolean isDateType(Class<T> clazz, String fieldName){
        boolean flag = false;
        try{
            Field field = clazz.getDeclaredField(fieldName);
            Object typeObj = field.getType().newInstance();
            flag = typeObj instanceof Date;
        }
        catch(Exception e){
            // 把异常吞掉直接返回false
        }
        return flag;
    }

    /**
     * 根据类型将指定参数转换成对应的类型
     * 
     * @param value
     *            指定参数
     * @param type
     *            指定类型
     * @return 返回类型转换后的对象
     */
    protected <T> Object parseValueWithType(String value, Class<?> type){
        Object result = null;
        try{ // 根据属性的类型将内容转换成对应的类型
            if(Boolean.TYPE == type){
                result = Boolean.parseBoolean(value);
            }else if(Byte.TYPE == type){
                result = Byte.parseByte(value);
            }else if(Short.TYPE == type){
                result = Short.parseShort(value);
            }else if(Integer.TYPE == type){
                result = Integer.parseInt(value);
            }else if(Long.TYPE == type){
                result = Long.parseLong(value);
            }else if(Float.TYPE == type){
                result = Float.parseFloat(value);
            }else if(Double.TYPE == type){
                result = Double.parseDouble(value);
            }else{
                result = (Object)value;
            }
        }
        catch(Exception e){
            // 把异常吞掉直接返回null
        }
        return result;
    }
    
    
}
