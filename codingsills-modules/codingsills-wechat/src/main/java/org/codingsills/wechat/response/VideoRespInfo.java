package org.codingsills.wechat.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 视频消息
 * VideoRespInfo.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class VideoRespInfo {

    private String MediaId;// 通过素材管理接口上传多媒体文件，得到的id

    private String Title;// 视频消息的标题

    private String Description;// 视频消息的描述

    @XmlElement(name="MediaId")
    public String getMediaId(){
        return MediaId;
    }

    public void setMediaId(String mediaId){
        MediaId = mediaId;
    }

    @XmlElement(name="Title")
    public String getTitle(){
        return Title;
    }

    public void setTitle(String title){
        Title = title;
    }

    @XmlElement(name="Description")
    public String getDescription(){
        return Description;
    }

    public void setDescription(String description){
        Description = description;
    }
}
