package org.codingsills.wechat.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信request请求属性
 * WechatRequest.java
 *
 * @date 2016年8月1日
 * 
 * @author Saber
 */
@XmlRootElement(name = "xml")
public class WechatRequest {

    // 公用字段
    private String ToUserName;// 开发者微信号

    private String FromUserName;// 发送方账号

    private String CreateTime;// 消息创建时间

    private String MsgType;// 消息类型
    
    // 普通消息字段
    private String Content;// 文本消息内容

    private String MsgId;// 消息ID

    private String PicUrl;// 图片链接

    private String MediaId;// 图片(语音、视频)消息媒体ID

    private String Format;// 语音格式

    private String ThumbMediaId;// 视频消息缩略图的媒体id

    private String Recognition;

    private String Location_X;// 地理位置纬度

    private String Location_Y;// 地理位置经度

    private String Scale;// 地图缩放大小

    private String Label;// 地理位置信息

    private String Title;// 链接消息标题

    private String Description;// 链接消息描述

    private String Url;// 链接消息链接
    
    // 事件消息字段
    private String Event; // 事件类型

    private String EventKey;// 事件KEY值

    private String Ticket;// 二维码的ticket

    private String Latitude;// 地理位置纬度

    private String Longitude;// 地理位置经度

    private String Precision;// 地理位置精度

    // 自定义菜单事件推送
    private ScanCodeInfo ScanCodeInfo; // 扫描信息

    private SendPicsInfo SendPicsInfo; // 发送的图片信息

    private SendLocationInfo SendLocationInfo; // 发送的位置信息

    @XmlElement(name="ToUserName")
    public String getToUserName(){
        return ToUserName;
    }

    public void setToUserName(String toUserName){
        ToUserName = toUserName;
    }

    @XmlElement(name="FromUserName")
    public String getFromUserName(){
        return FromUserName;
    }

    public void setFromUserName(String fromUserName){
        FromUserName = fromUserName;
    }

    @XmlElement(name="CreateTime")
    public String getCreateTime(){
        return CreateTime;
    }

    public void setCreateTime(String createTime){
        CreateTime = createTime;
    }

    @XmlElement(name="MsgType")
    public String getMsgType(){
        return MsgType;
    }

    public void setMsgType(String msgType){
        MsgType = msgType;
    }

    @XmlElement(name="Content")
    public String getContent(){
        return Content;
    }

    public void setContent(String content){
        Content = content;
    }

    @XmlElement(name="MsgId")
    public String getMsgId(){
        return MsgId;
    }

    public void setMsgId(String msgId){
        MsgId = msgId;
    }

    @XmlElement(name="PicUrl")
    public String getPicUrl(){
        return PicUrl;
    }

    public void setPicUrl(String picUrl){
        PicUrl = picUrl;
    }

    @XmlElement(name="MediaId")
    public String getMediaId(){
        return MediaId;
    }

    public void setMediaId(String mediaId){
        MediaId = mediaId;
    }

    @XmlElement(name="Format")
    public String getFormat(){
        return Format;
    }

    public void setFormat(String format){
        Format = format;
    }

    @XmlElement(name="ThumbMediaId")
    public String getThumbMediaId(){
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId){
        ThumbMediaId = thumbMediaId;
    }

    @XmlElement(name="Recognition")
    public String getRecognition(){
        return Recognition;
    }

    public void setRecognition(String recognition){
        Recognition = recognition;
    }

    @XmlElement(name="Location_X")
    public String getLocation_X(){
        return Location_X;
    }

    public void setLocation_X(String location_X){
        Location_X = location_X;
    }

    @XmlElement(name="Location_Y")
    public String getLocation_Y(){
        return Location_Y;
    }

    public void setLocation_Y(String location_Y){
        Location_Y = location_Y;
    }

    @XmlElement(name="Scale")
    public String getScale(){
        return Scale;
    }

    public void setScale(String scale){
        Scale = scale;
    }

    @XmlElement(name="Label")
    public String getLabel(){
        return Label;
    }

    public void setLabel(String label){
        Label = label;
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

    @XmlElement(name="Url")
    public String getUrl(){
        return Url;
    }

    public void setUrl(String url){
        Url = url;
    }

    @XmlElement(name="Event")
    public String getEvent(){
        return Event;
    }

    public void setEvent(String event){
        Event = event;
    }

    @XmlElement(name="EventKey")
    public String getEventKey(){
        return EventKey;
    }

    public void setEventKey(String eventKey){
        EventKey = eventKey;
    }

    @XmlElement(name="Ticket")
    public String getTicket(){
        return Ticket;
    }

    public void setTicket(String ticket){
        Ticket = ticket;
    }

    @XmlElement(name="Latitude")
    public String getLatitude(){
        return Latitude;
    }

    public void setLatitude(String latitude){
        Latitude = latitude;
    }

    @XmlElement(name="Longitude")
    public String getLongitude(){
        return Longitude;
    }

    public void setLongitude(String longitude){
        Longitude = longitude;
    }

    @XmlElement(name="Precision")
    public String getPrecision(){
        return Precision;
    }

    public void setPrecision(String precision){
        Precision = precision;
    }

    @XmlElement(name="ScanCodeInfo")
    public ScanCodeInfo getScanCodeInfo(){
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo){
        ScanCodeInfo = scanCodeInfo;
    }

    @XmlElement(name="SendPicsInfo")
    public SendPicsInfo getSendPicsInfo(){
        return SendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo){
        SendPicsInfo = sendPicsInfo;
    }

    @XmlElement(name="SendLocationInfo")
    public SendLocationInfo getSendLocationInfo(){
        return SendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo){
        SendLocationInfo = sendLocationInfo;
    }
}
