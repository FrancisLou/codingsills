package org.codingsills.wechat.common;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 微信请求校验
 * ValidateSignature.java
 *
 * @date 2016年8月2日
 * 
 * @author Saber
 */
public class ValidateSignature {
    
    /**
     * 验证
     * @return true 验证通过，false 验证失败
     * */
    public static boolean checkSign(String timestamp, String nonce, String signature){
        String sha1 = encode(timestamp,nonce);
        return signature.equals(sha1);
    }
    
    /**
     * 得到加密后的数据
     * @return
     */
    private static String encode(String timestamp, String nonce){
        String[] sa = {WechatConfig.getInstance().getToken(),timestamp, nonce};
        Arrays.sort(sa);
        String sortStr = sa[0] + sa[1] + sa[2];
        return DigestUtils.sha1Hex(sortStr);
    }
    
}
