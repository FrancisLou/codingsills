package org.codingsills.modules.utils;

import java.io.Serializable;

/**
 * 类功能描述
 * ExcelDemo.java
 *
 * @date 2016年1月22日
 * 
 * @author Saber
 */
public class ExcelDemo implements Serializable {

    private static final long serialVersionUID = -7047328027931236477L;

    private String name;

    private String date;

    private String no;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getNo(){
        return no;
    }

    public void setNo(String no){
        this.no = no;
    }

    @Override
    public String toString(){
        return "name:"+name+",date:"+date+",no:"+no;
    }
    
    
}
