package org.codingsills.modules.excel;

/**
 * Excel工具类
 * ExcelUtils.java
 *
 * @date 2016年1月21日
 * 
 * @author Saber
 */
public class ExcelTypeKit {
    
    /**
     * 判断是否为03版excel(文件名以'.xls'结尾)
     * */
    public static boolean isExcel03(String filePath){
        return filePath.matches("^.+\\.(?i)(xls)$");
    }
    
    /**
     * 判断是否为07及以上版本excel(文件名以'.xlsx'结尾)
     * */
    public static boolean isExcel07Plus(String filePath){
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

}
