package org.codingsills.modules.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Date;

import org.codingsills.modules.utils.DateKit.TimeType;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * 类功能描述
 * JodaTest.java
 *
 * @date 2016年1月14日
 * 
 * @author Saber
 */
public class DateUtilsTest {
    
    private static final String DATE_FORMATER = "yyyy-MM-dd HH:mm:ss";
    
    @Test
    public void testJoda(){
        DateTime dateTime = new DateTime(2016, 1, 14, 16, 23,45);
        assertThat(dateTime.toString(DATE_FORMATER)).isEqualTo("2016-01-14 16:23:45");
    
        assertThat(dateTime.plus(15*1000).toString(DATE_FORMATER)).isEqualTo("2016-01-14 16:24:00");
        assertThat(dateTime.plusDays(1).toString(DATE_FORMATER)).isEqualTo("2016-01-15 16:23:45");
        assertThat(dateTime.plusDays(-1).toString(DATE_FORMATER)).isEqualTo("2016-01-13 16:23:45");
    
    }
    
    @Test
    public void testDateUtils(){
        Date date1 = DateKit.createDate(2016, 1, 13, 9, 0,0);
        Date date2 = DateKit.createDate(2015, 1, 15, 10, 0, 0);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.YEAR)).isEqualTo(0);
        assertThat(DateKit.periodBtDate(date2, date1, TimeType.YEAR)).isEqualTo(0);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.MONTH)).isEqualTo(11);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.WEEK)).isEqualTo(51);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.DAY)).isEqualTo(362);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.HOUR)).isEqualTo(8711);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.MIN)).isEqualTo(522660);
        assertThat(DateKit.periodBtDate(date1, date2, TimeType.SECOND)).isEqualTo(31359600);
        
        assertThat(DateKit.beforeDate(date1, date2)).isEqualTo(false);
        assertThat(DateKit.afterDate(date1, date2)).isEqualTo(true);
        
        assertThat(DateKit.formatDate(date1, "yyyy/MM/dd HH:mm:ss")).isEqualTo("2016/01/13 09:00:00");
        assertThat(DateKit.formatDate(date2)).isEqualTo("2015-01-15 10:00:00");
        
    }
    
    
    @Test
    public void testBetween(){
        Date date1 = DateKit.createDate(2016, 1, 13, 9, 0,0);
        Date date2 = DateKit.createDate(2016, 1, 15, 9, 0,0);
        assertThat(DateKit.preDate(date2, 1, TimeType.YEAR)).isEqualTo(DateKit.createDate(2015, 1, 15, 9, 0,0));
        assertThat(DateKit.preDate(date2, 12, TimeType.MONTH)).isEqualTo(DateKit.createDate(2015, 1, 15, 9, 0,0));
        assertThat(DateKit.preDate(date2, 2, TimeType.WEEK)).isEqualTo(DateKit.createDate(2016, 1, 1, 9, 0, 0));
        assertThat(DateKit.preDate(date2, 2, TimeType.DAY)).isEqualTo(date1);
        assertThat(DateKit.preDate(date2, 48, TimeType.HOUR)).isEqualTo(date1);
        assertThat(DateKit.preDate(date2, 3*60+25, TimeType.MIN)).isEqualTo(DateKit.createDate(2016, 1, 15, 5, 35, 0));
        assertThat(DateKit.preDate(date1, 2*24*3600+3*3600+15*60+45, TimeType.SECOND)).isEqualTo(DateKit.createDate(2016, 1, 11, 5, 44, 15));
    
        System.out.println(DateKit.formatDate(DateKit.getFirstOfWeek(new Date())));
        System.out.println(DateKit.formatDate(DateKit.getLastOfWeek(new Date())));
        System.out.println(DateKit.formatDate(DateKit.getFirstOfMonth(new Date())));
        System.out.println(DateKit.formatDate(DateKit.getLastOfMonth(new Date())));
    }
    
}
