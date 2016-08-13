package org.codingsills.wechat.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @From 自定义菜单事件推送：弹出拍照、相册发图事件
 * 
 * 发送的图片信息
 * SendPicsInfo.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class SendPicsInfo {

    /**
     * 发送的图片数量
     * */
    private String Count;

    /**
     * 图片列表
     * */
    private List<Item> item;

    @XmlElement(name = "Count")
    public String getCount(){
        return Count;
    }

    public void setCount(String count){
        Count = count;
    }

    @XmlElementWrapper(name = "PicList")
    @XmlElement(name = "item")
    public List<Item> getItem(){
        return item;
    }

    public void setItem(List<Item> item){
        this.item = item;
    }
}
