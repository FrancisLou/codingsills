package org.codingsills.modules.utils;


/**
 * 类功能描述
 * Student.java
 *
 * @date 2016年4月6日
 * 
 * @author Saber
 */
public class Student {

    private String name;

    private Integer age;

    private String birthday;

    public Student(String name, Integer age, String birthday){
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
}
