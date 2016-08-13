package org.codingsills.wechat.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * @From 自定义菜单事件：弹出地理位置选择器
 * 
 * 发送的位置信息
 * SendLocationInfo.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class SendLocationInfo {

    /**
     * X坐标信息
     * */
    private String Location_X;

    /**
     * Y坐标信息
     * */
    private String Location_Y;

    /**
     * 精度，可理解为精度或者比例尺、越精细的话 scale越高
     * */
    private String Scale;

    /**
     * 地理位置的字符串信息
     * */
    private String Label;

    /**
     * 朋友圈POI的名字，可能为空
     * */
    private String Poiname;

    @XmlElement(name = "Location_X")
    public String getLocation_X(){
        return Location_X;
    }

    public void setLocation_X(String location_X){
        Location_X = location_X;
    }

    @XmlElement(name = "Location_Y")
    public String getLocation_Y(){
        return Location_Y;
    }

    public void setLocation_Y(String location_Y){
        Location_Y = location_Y;
    }

    @XmlElement(name = "Scale")
    public String getScale(){
        return Scale;
    }

    public void setScale(String scale){
        Scale = scale;
    }

    @XmlElement(name = "Label")
    public String getLabel(){
        return Label;
    }

    public void setLabel(String label){
        Label = label;
    }

    @XmlElement(name = "Poiname")
    public String getPoiname(){
        return Poiname;
    }

    public void setPoiname(String poiname){
        Poiname = poiname;
    }
}
