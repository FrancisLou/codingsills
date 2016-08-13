package org.codingsills.wechat.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信response属性
 * WechatResponse.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
@XmlRootElement(name = "xml")
public class WechatResponse {

    // 公用字段
    private String ToUserName;// 开发者微信号

    private String FromUserName;// 发送方账号

    private String CreateTime;// 消息创建时间

    private String MsgType;// 消息类型

    private String Content;// 回复的消息内容

    private String ArticleCount;// 图文消息个数，限制为10条以内

    private ImageRespInfo Image; // 回复图片消息

    private VoiceRespInfo Voice;// 回复语音消息

    private VideoRespInfo Video;// 回复视频消息

    private MusicRespInfo Music;// 回复音乐消息

    private List<ArticlesRespInfo> articleList; // 回复图文消息

    private TransInfoRespInfo TransInfo;// 消息转发到指定客服

    @XmlElement(name = "ToUserName")
    public String getToUserName(){
        return ToUserName;
    }

    public void setToUserName(String toUserName){
        ToUserName = toUserName;
    }

    @XmlElement(name = "FromUserName")
    public String getFromUserName(){
        return FromUserName;
    }

    public void setFromUserName(String fromUserName){
        FromUserName = fromUserName;
    }

    @XmlElement(name = "CreateTime")
    public String getCreateTime(){
        return CreateTime;
    }

    public void setCreateTime(String createTime){
        CreateTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public String getMsgType(){
        return MsgType;
    }

    public void setMsgType(String msgType){
        MsgType = msgType;
    }

    @XmlElement(name = "Content")
    public String getContent(){
        return Content;
    }

    public void setContent(String content){
        Content = content;
    }

    @XmlElement(name = "ArticleCount")
    public String getArticleCount(){
        return ArticleCount;
    }

    public void setArticleCount(String articleCount){
        ArticleCount = articleCount;
    }

    @XmlElement(name = "Image")
    public ImageRespInfo getImage(){
        return Image;
    }

    public void setImage(ImageRespInfo image){
        Image = image;
    }

    @XmlElement(name = "Voice")
    public VoiceRespInfo getVoice(){
        return Voice;
    }

    public void setVoice(VoiceRespInfo voice){
        Voice = voice;
    }

    @XmlElement(name = "Video")
    public VideoRespInfo getVideo(){
        return Video;
    }

    public void setVideo(VideoRespInfo video){
        Video = video;
    }

    @XmlElement(name = "Music")
    public MusicRespInfo getMusic(){
        return Music;
    }

    public void setMusic(MusicRespInfo music){
        Music = music;
    }

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    public List<ArticlesRespInfo> getArticleList(){
        return articleList;
    }

    public void setArticleList(List<ArticlesRespInfo> articleList){
        this.articleList = articleList;
    }

    @XmlElement(name = "TransInfo")
    public TransInfoRespInfo getTransInfo(){
        return TransInfo;
    }

    public void setTransInfo(TransInfoRespInfo transInfo){
        TransInfo = transInfo;
    }
}
