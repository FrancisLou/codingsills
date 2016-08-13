package org.codingsills.modules.utils;

import java.io.File;
import java.util.List;

import org.codingsills.modules.excel.XssfExcelKit;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * 测试excel工具类
 * ExcelTest.java
 *
 * @date 2016年1月22日
 * 
 * @author Saber
 */
public class ExcelTest {
    
    private File file;
    
    @Before
    public void init(){
        file = new File("D:/排班表.xlsx");
    }
    
    @Test
    public void testXssf() throws Exception{
        XssfExcelKit excelHelper = XssfExcelKit.getInstance(file);
        
        List<ExcelDemo> list = excelHelper.readExcel(ExcelDemo.class, true);
        
        for(ExcelDemo po:list){
            System.out.println(po.toString());
        }
        
        //写excel文档
        XssfExcelKit excelHelper2 = XssfExcelKit.getInstance("D:/testExcel.xlsx");
        List<String> titles = Lists.newArrayList("姓名","日期","班次");
        excelHelper2.writeExcelExclude(ExcelDemo.class, list, null, titles);
    }
    
    
}
