package org.codingsills.modules.utils;

import java.util.ArrayList;
import java.util.List;

import org.codingsills.modules.excel.JxlsKit;
import org.junit.Test;

/**
 * 类功能描述
 * JxlsKitTest.java
 *
 * @date 2016年4月6日
 * 
 * @author Saber
 */
public class JxlsKitTest {
    
    @Test
    public void test() throws Exception{
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("张三", 20, "19960205"));
        list.add(new Student("李四", 21, "19950312"));
        list.add(new Student("王五", 22, "19940413"));
        list.add(new Student("柳流", 23, "19930515"));
        JxlsKit.writeExcel(list, "D:/student.xlsx", "D:/student_data.xlsx");
    }

}
