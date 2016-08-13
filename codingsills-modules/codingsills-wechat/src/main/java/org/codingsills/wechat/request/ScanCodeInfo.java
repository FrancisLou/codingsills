package org.codingsills.wechat.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * @From 自定义菜单事件推送：扫描推事件
 * 
 * 扫描信息
 * ScanCodeInfo.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class ScanCodeInfo {

    /**
     * 扫描类型，一般是qrcode
     * */
    private String ScanType;

    /**
     * 扫描结果，即二维码对应的字符串信息
     * */
    private String ScanResult;

    @XmlElement(name="ScanType")
    public String getScanType(){
        return ScanType;
    }

    public void setScanType(String scanType){
        ScanType = scanType;
    }
    
    @XmlElement(name="ScanResult")
    public String getScanResult(){
        return ScanResult;
    }

    public void setScanResult(String scanResult){
        ScanResult = scanResult;
    }
}
