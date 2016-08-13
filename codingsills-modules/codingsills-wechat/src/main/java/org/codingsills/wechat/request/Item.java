package org.codingsills.wechat.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * 类功能描述
 * Item.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class Item {

    /**
     * 图片的MD5值，开发者若需要，可用于验证接收到图片
     * */
    private String PicMd5Sum;

    @XmlElement(name = "PicMd5Sum")
    public String getPicMd5Sum(){
        return PicMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum){
        PicMd5Sum = picMd5Sum;
    }
}
