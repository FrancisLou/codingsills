package org.codingsills.web.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.codingsills.constants.Consts;

/**
 * 绑定当前登录的用户,不同于@ModelAttribute
 * CurrentUser.java
 *
 * @date 2016年6月20日
 * 
 * @author Saber
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    
    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default Consts.CURRENT_USER;
}
