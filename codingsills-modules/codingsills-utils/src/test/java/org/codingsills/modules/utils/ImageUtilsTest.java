package org.codingsills.modules.utils;

import org.junit.Before;
import org.junit.Test;

/**
 * 类功能描述
 * ImageUtilsTest.java
 *
 * @date 2016年1月26日
 * 
 * @author Saber
 */
public class ImageUtilsTest {
    
    private ImageKit image;
    
    @Before
    public void initImage(){
        image = new ImageKit("D:/dongman.jpg");
    }
    
    /**
     * 按百分比调整图片大小
     * */
    @Test
    public void testResizePercent(){
        image.resize(10);
        image.saveAs("D:/dongman_resize.jpg");
    }
    
    /**
     * 调整图片宽、高
     * */
    @Test
    public void testResizeWH(){
        image.resize(100, 80);
        image.saveAs("D:/dongman_resizeWH.jpg");
    }
    
    @Test
    public void testMultiply(){
//        image.multiply(5, 5, 11111);
        image.multiply(5, 5);
        image.saveAs("D:/dongman_multiply_no.jpg");
    }
    /**
     * 转黑白
     * */
    @Test
    public void testToBW(){
        image.convertToBlackAndWhite();
        image.saveAs("D:/back_write.jpg");
    }
    
    /**
     * 合并图片
     * */
    @Test
    public void testCombine(){
        ImageKit image2 = new ImageKit("D:/qw_cat_0005.gif");
        image2.combineWithPicture("D:/mxcp16-013416_925.jpg");
        image2.saveAs("D:/combine.jpg");
    }
}
