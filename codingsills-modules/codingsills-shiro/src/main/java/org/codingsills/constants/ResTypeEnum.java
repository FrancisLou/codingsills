package org.codingsills.constants;

/**
 * 资源类型枚举类
 * ResTypeEnum.java
 *
 * @date 2016年6月15日
 * 
 * @author Saber
 */
public enum ResTypeEnum{
    MENU("menu", "菜单"), BUTTON("btn", "按钮");

    private String code;

    private String name;

    /**
     * ResTypeEnum.java 默认构造
     */
    private ResTypeEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }
    
}
