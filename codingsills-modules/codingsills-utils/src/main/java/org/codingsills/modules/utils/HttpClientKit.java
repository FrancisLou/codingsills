package org.codingsills.modules.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * apache httpclient简单封装(基于httpclient-4.5.1)
 * TODO 方法待验证和优化
 * HttpClientUtils.java
 *
 * @date 2016年1月25日
 * 
 * @author Saber
 */
public class HttpClientKit {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientKit.class);

    private static PoolingHttpClientConnectionManager connMng;

    private static RequestConfig reqCfg;

    private static final int MAX_TIMEOUT = 5000;

    private static String DEFAULT_CHARSET = "UTF-8";

    static{
        // 设置连接池
        connMng = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMng.setMaxTotal(100);
        // 设置路由的默认最大连接，是对maxTotal的细分
        // 目前只有一个路由，因此让它等于最大值
        connMng.setDefaultMaxPerRoute(connMng.getMaxTotal());
        // TODO ???
        connMng.setValidateAfterInactivity(10);
        RequestConfig.Builder cfgBuilder = RequestConfig.custom();
        // 设置连接超时时间
        cfgBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时时间
        cfgBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例超时时间
        cfgBuilder.setConnectionRequestTimeout(500);
        reqCfg = cfgBuilder.build();
    }

    /**
     * 发送 GET请求(HTTP)
     * @param url 请求地址
     * 
     * @return
     * */
    public static String doGet(String url){
        return doGet(url, new HashMap<String, Object>());
    }

    /**
     * 发送GET请求（HTTP）
     * @param url  请求地址
     * @param params 请求参数键值对
     * 
     * @return
     * */
    public static String doGet(String url, Map<String, Object> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlBuilder = buildUrlWithQueryString(url, params);
        HttpGet httpGet = new HttpGet(urlBuilder);
        logger.debug("Request URL >>> {}", urlBuilder);
        String result = null;
        CloseableHttpResponse resp = null;
        try{
            resp = httpClient.execute(httpGet);
            int statuCode = resp.getStatusLine().getStatusCode();
            logger.debug("Response status >>> {}", statuCode);
            HttpEntity entity = resp.getEntity();
            if(entity != null){
                InputStream is = entity.getContent();
                result = IOUtils.toString(is);
            }
        }
        catch(Exception e){
            logger.error("Get Request Error !", e);
        }
        finally{
            if(resp != null){
                try{
                    EntityUtils.consume(resp.getEntity());
                    resp.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 发送POST请求（HTTP）
     * @param url 请求地址
     * 
     * @return
     * */
    public static String doPost(String url){
        return doPost(url, new HashMap<String, Object>());
    }

    /**
     * 发送POST请求（HTTP）
     * @param url   请求地址
     * @param params 请求参数键值对
     * 
     * @return
     * */
    public static String doPost(String url, Map<String, Object> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse resp = null;
        post.setConfig(reqCfg);
        List<NameValuePair> pairList = new ArrayList<NameValuePair>();
        for(Entry<String, Object> entry : params.entrySet()){
            NameValuePair nvp =
                    new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
            pairList.add(nvp);
        }
        post.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(DEFAULT_CHARSET)));
        try{
            resp = httpClient.execute(post);
            logger.debug("Response : {}", resp.toString());
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, Charset.forName(DEFAULT_CHARSET));
        }
        catch(Exception e){
            logger.info("Post request error:", e);
        }
        finally{
            if(resp != null){
                try{
                    EntityUtils.consume(resp.getEntity());
                    resp.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 发送POST(请求)
     * @param url 请求地址
     * @param json 请求参数（json格式）
     * 
     * @return
     * */
    public static String doPost(String url, String json){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try{
            httpPost.setConfig(reqCfg);
            StringEntity stringEntity = new StringEntity(json.toString(), DEFAULT_CHARSET);// 解决中文乱码问题
            stringEntity.setContentEncoding(DEFAULT_CHARSET);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            logger.debug("response statu code : {}", response.getStatusLine().getStatusCode());
            httpStr = EntityUtils.toString(entity, DEFAULT_CHARSET);
        }
        catch(IOException e){
            logger.error("post request error", e);
        }
        finally{
            if(response != null){
                try{
                    EntityUtils.consume(response.getEntity());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 SSL POST请求（HTTPS）
     * @param url 请求地址
     * @param params 请求参数()
     * */
    public static String doSSLPost(String url, Map<String, Object> params){
        CloseableHttpClient httpClient =
                HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
                        .setConnectionManager(connMng).setDefaultRequestConfig(reqCfg).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;
        try{
            httpPost.setConfig(reqCfg);
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for(Map.Entry<String, Object> entry : params.entrySet()){
                NameValuePair pair =
                        new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(
                    new UrlEncodedFormEntity(pairList, Charset.forName(DEFAULT_CHARSET)));
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                return null;
            }
            HttpEntity entity = response.getEntity();
            if(entity == null){
                return null;
            }
            httpStr = EntityUtils.toString(entity, DEFAULT_CHARSET);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(response != null){
                try{
                    EntityUtils.consume(response.getEntity());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    public static String doSSLPost(String url, String json){
        CloseableHttpClient httpClient =
                HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
                        .setConnectionManager(connMng).setDefaultRequestConfig(reqCfg).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;
        try{
            httpPost.setConfig(reqCfg);
            StringEntity stringEntity = new StringEntity(json.toString(), DEFAULT_CHARSET);// 解决中文乱码问题
            stringEntity.setContentEncoding(DEFAULT_CHARSET);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                return null;
            }
            HttpEntity entity = response.getEntity();
            if(entity == null){
                return null;
            }
            httpStr = EntityUtils.toString(entity, DEFAULT_CHARSET);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(response != null){
                try{
                    EntityUtils.consume(response.getEntity());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    /** 
     * 创建SSL安全连接 
     * 
     * @return 
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory(){
        SSLConnectionSocketFactory sslsf = null;
        try{
            SSLContext sslContext =
                    new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){

                        public boolean isTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException{
                            return true;
                        }
                    }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier(){

                @Override
                public boolean verify(String hostname, SSLSession session){
                    return true;
                }
            });
        }
        catch(KeyManagementException e){
            e.printStackTrace();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        catch(KeyStoreException e){
            e.printStackTrace();
        }
        return sslsf;
    }

    /**
     * Build queryString of the url
     */
    public static String buildUrlWithQueryString(String url, Map<String, Object> queryParas){
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
                        value = URLEncoder.encode(String.valueOf(value), DEFAULT_CHARSET);
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
