package org.codingsills.wechat.common;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


/**
 * 微信相关基础配置测试
 * WechatConfigTest.java
 *
 * @date 2016年8月1日
 * 
 * @author Saber
 */
public class WechatConfigTest {
    
    @Test
    public void testInit(){
        Assert.assertEquals(WechatConfig.getInstance().getAppid(), "wxf37394337d303eec");
        Assert.assertEquals(WechatConfig.getInstance().getAppSecret(), "9138442b15b3f40968920633a9416d5a");
    }
    
    @Test
    public void testSort(){
        String[] strs = {"fesfe","afbcdfe","wfgejlgje","bdfefjoe","adbcd"};
        Arrays.sort(strs);
        for(String str:strs){
            System.out.println(str);
        }
    }
}
