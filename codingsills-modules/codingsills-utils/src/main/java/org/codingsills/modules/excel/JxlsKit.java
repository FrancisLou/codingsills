package org.codingsills.modules.excel;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

/**
 * JXLS利用模板导出excel
 * JxlsKit.java
 *
 * @date 2016年4月6日
 * 
 * @author Saber
 */
public class JxlsKit {
    
    public static void writeExcel(List<?> beans,String templatePath,String destPath) throws Exception{
        File tpFile = new File(templatePath); 
        if(!tpFile.exists()){
            throw new IllegalArgumentException("Excel export template does not exist！");
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beanList", beans);
        
        XLSTransformer transformer = new XLSTransformer();
        //根据模板生成excel文件
        transformer.transformXLS(templatePath, map,destPath);
    }
    
    
}
