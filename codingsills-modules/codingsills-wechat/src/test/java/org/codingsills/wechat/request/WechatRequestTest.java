package org.codingsills.wechat.request;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

/**
 * 微信请求Bean to xml测试
 * WechatRequestTest.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class WechatRequestTest {
    
    private String getRealPath(String resName){
        String path = WechatRequestTest.class.getClassLoader().getResource(resName).getPath();
        return path;
    }
    
    /**
     * 测试接收文本消息
     * @throws FileNotFoundException 
     * @throws JAXBException 
     * */
    @Test
    public void testReceiveTest() throws FileNotFoundException, JAXBException{
        String path = getRealPath("req_text.xml");
        FileInputStream in = new FileInputStream(path);
        JAXBContext jc = JAXBContext.newInstance(WechatRequest.class);
        Unmarshaller u = jc.createUnmarshaller();
        WechatRequest request =  (WechatRequest)u.unmarshal(in);
        System.out.println(request.getToUserName());
        System.out.println(request.getFromUserName());
        System.out.println(request.getEvent());
    }
}
