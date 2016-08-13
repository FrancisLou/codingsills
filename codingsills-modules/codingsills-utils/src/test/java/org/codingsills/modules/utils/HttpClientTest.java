package org.codingsills.modules.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 类功能描述
 * HttpClientTest.java
 *
 * @date 2016年1月22日
 * 
 * @author Saber
 */
public class HttpClientTest {

    /**
     * 这个案例展示了如何创建一个定制的SSL上下文的安全连接。
     * */
    @Test
    public void testSSL() throws Exception{
        
        // 信任自己的CA和自签名证书
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(new File("D:/my.keystore"),
                "nopassword".toCharArray(), new TrustSelfSignedStrategy()).build();
        // 只允许TLSv1协议
        SSLConnectionSocketFactory sslsf =
                new SSLConnectionSocketFactory(sslContext, new String[]{ "TLSv1" }, null,
                        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try{
            HttpGet httpget = new HttpGet("https://httpbin.org/");
            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try{
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                EntityUtils.consume(entity);
            }
            finally{
                response.close();
            }
        }
        finally{
            httpclient.close();
        }
    }
    
    @Test
    public void testHttpClient(){
        Map<String,Object> params = new HashMap<>();
        params.put("type", "yuantong");
        params.put("postid", "700074134800");
        String str = HttpClientKit.doGet("http://www.kuaidi100.com/query",params);
        System.out.println(str);
    }
    
    @Test
    public void testFluentApi(){
        String url = "http://www.kuaidi100.com/query";
        Map<String,Object> params = new HashMap<>();
        params.put("type", "yuantong");
        params.put("postid", "700074134800");
        
        System.out.println("HttpKit2:"+HttpKit2.doGet(url, params));
    }
    
    
}
