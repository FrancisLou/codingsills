package org.codingsills.wechat.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 语音消息
 * VoiceRespInfo.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class VoiceRespInfo {

    private String MediaId; // 通过素材管理接口上传多媒体文件，得到的id

    @XmlElement(name="MediaId")
    public String getMediaId(){
        return MediaId;
    }

    public void setMediaId(String mediaId){
        MediaId = mediaId;
    }
}
