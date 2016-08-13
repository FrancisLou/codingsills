package org.codingsills.wechat.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 消息转发到指定客服
 * TransInfoRespInfo.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class TransInfoRespInfo {

    private String KfAccount;// 指定会话接入的客服账号

    /**
     * TransInfoRespInfo.java 默认构造
     */
    public TransInfoRespInfo(){
        super();
    }

    /**
     * TransInfoRespInfo.java 默认构造
     */
    public TransInfoRespInfo(String kfAccount){
        super();
        KfAccount = kfAccount;
    }

    @XmlElement(name = "KfAccount")
    public String getKfAccount(){
        return KfAccount;
    }

    public void setKfAccount(String kfAccount){
        KfAccount = kfAccount;
    }
}
