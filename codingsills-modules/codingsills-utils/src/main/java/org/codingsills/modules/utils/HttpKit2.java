package org.codingsills.modules.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

/**
 * 利用apache fluent api实现http请求工具类
 * HttpKit2.java
 *
 * @date 2016年1月25日
 * 
 * @author Saber
 */
public class HttpKit2 {
    
    private static String charset = "UTF-8";
    
    private static final int MAX_TIMEOUT = 5000;
    
    /**
     * 设置默认编码
     * */
    public static void setCharset(String charset){
        if(StringUtils.isBlank(charset)){
            throw new IllegalArgumentException("charSet can not be blank.");
        }
        HttpKit2.charset = charset;
    }
    
    public static String doGet(String url){
        return doGet(url,new HashMap<String,Object>());
    }
    
    public static String doGet(String url,Map<String,Object> params){
        String result = null;
        try{
            Content content = Request.Get(buildUrlWithQueryString(url, params))
                    .connectTimeout(MAX_TIMEOUT).socketTimeout(MAX_TIMEOUT).execute().returnContent();
            result =  content.asString(Charset.forName(charset));
        }
        catch(ClientProtocolException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static String doPost(String url){
        String result = null;
        try{
            Content content = Request.Post(url)
                    .connectTimeout(MAX_TIMEOUT).socketTimeout(MAX_TIMEOUT).execute().returnContent();
            result = content.asString(Charset.forName(charset));
        }
        catch(ClientProtocolException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static String doPost(String url,Map<String,Object> params){
        String result = null;
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for(Entry<String, Object> entry:params.entrySet()){
            list.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        try{
            Content content = Request.Post(url).connectTimeout(MAX_TIMEOUT)
                    .socketTimeout(MAX_TIMEOUT).bodyForm(list).execute().returnContent();
            result = content.asString(Charset.forName(charset));
        }
        catch(ClientProtocolException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    private static String buildUrlWithQueryString(String url, Map<String, Object> queryParas){
        if(queryParas == null || queryParas.isEmpty()) return url;
        StringBuilder sb = new StringBuilder(url);
        boolean isFirst;
        if(url.indexOf("?") == -1){
            isFirst = true;
            sb.append("?");
        }else{
            isFirst = false;
        }
        for(Entry<String, Object> entry : queryParas.entrySet()){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append("&");
            }
            String key = entry.getKey();
            Object value = entry.getValue();
            if(value != null){
                if(value instanceof String){
                    try{
                        value = URLEncoder.encode(String.valueOf(value), charset);
                    }
                    catch(UnsupportedEncodingException e){
                        throw new RuntimeException(e);
                    }
                }
                sb.append(key).append("=").append(value);
            }
        }
        return sb.toString();
    }
}
