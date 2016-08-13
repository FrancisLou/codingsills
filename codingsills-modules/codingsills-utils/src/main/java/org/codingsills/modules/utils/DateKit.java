package org.codingsills.modules.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;

/**
 * 日期工具类，Joda-Time简单封装
 * DateUtils.java
 *
 * @date 2016年1月14日
 * 
 * @author Saber
 */
public class DateKit {
    
    public static final String DATE_TIME_FORMATER = "yyyy-MM-dd HH:mm:ss";
    
    public static final String DATE_FORMATER = "yyyy-MM-dd";
    
    public static final String TIME_FORMATER = "HH:mm:ss";
    
    /**
     * 计算指定时间之前的日期
     * @param date 待计算时间
     * @param random 待计算数
     * @param timeType 时间类型枚举
     * @see org.codingsills.modules.utils.DateKit.TimeType
     * 
     * @return Date
     * */
    public static Date preDate(Date date,int random,TimeType timeType){
        Date preDate = null;
        if(date == null){
            return preDate;
        }
        DateTime dateTime = fromDate(date);
        random = Math.abs(random);
        switch(timeType.getCode()){
        case "Y":
            preDate = dateTime.minusYears(random).toDate();
            break;
        case "M":
            preDate = dateTime.minusMonths(random).toDate();
            break;
        case "W":
            preDate = dateTime.minusWeeks(random).toDate();
            break;
        case "D":
            preDate = dateTime.minusDays(random).toDate();
            break;
        case "H":
            preDate = dateTime.minusHours(random).toDate();
            break;
        case "MIN":
            preDate = dateTime.minusMinutes(random).toDate();
            break;
        case "S":
            preDate = dateTime.minusSeconds(random).toDate();
            break;
        case "MS":
            preDate = dateTime.minusMillis(random).toDate();
            break;
        default:
            break;
        }
        
        return preDate;
    }
    
    /**
     * 计算指定时间之后的日期
     * @param date 待计算时间
     * @param random 待计算数
     * @param timeType 时间类型枚举
     * @see org.codingsills.modules.utils.DateKit.TimeType
     * 
     * @return Date
     * */
    public static Date nextDate(Date date,int random,TimeType timeType){
        Date nextDate = null;
        if(date == null){
            return nextDate;
        }
        DateTime dateTime = fromDate(date);
        random = Math.abs(random);
        switch(timeType.getCode()){
        case "Y":
            nextDate = dateTime.plusYears(random).toDate();
            break;
        case "M":
            nextDate = dateTime.plusMonths(random).toDate();
            break;
        case "W":
            nextDate = dateTime.plusWeeks(random).toDate();
            break;
        case "D":
            nextDate = dateTime.plusDays(random).toDate();
            break;
        case "H":
            nextDate = dateTime.plusHours(random).toDate();
            break;
        case "MIN":
            nextDate = dateTime.plusMinutes(random).toDate();
            break;
        case "S":
            nextDate = dateTime.plusSeconds(random).toDate();
            break;
        case "MS":
            nextDate = dateTime.plusMillis(random).toDate();
            break;
        default:
            break;
        }
        
        return nextDate;
    }
    
    /**
     * 日期转字符串
     * @param date 待处理日期
     * @param pattern, 为 null,"","  "时默认"yyyy-MM-dd HH:mm:ss"
     * 
     * @return String
     * */
    public static String formatDate(Date date,String pattern){
        if(date == null){
            return null;
        }
        DateTime dateTime = fromDate(date);
        if(StringUtils.isBlank(pattern)){
            pattern = DATE_TIME_FORMATER;
        }
        return dateTime.toString(pattern);
    }
    
    /**
     * 日期转为字符串，默认格式“yyyy-MM-dd HH:mm:ss”
     * @param date 待处理日期
     * 
     * @return String
     * */
    public static String formatDate(Date date){
        return formatDate(date, DATE_TIME_FORMATER);
    }
    
    /**
     * 字符串转日期，默认格式为yyyy-MM-dd HH:mm:ss
     * */
    public static Date parseStr(String dateStr){
        return parseStr(dateStr,null);
    }
    
    /**
     * 字符串转日期
     * @param dateStr 字符串型时间
     * @param pattern,为null,"","  "时默认“yyyy-MM-dd HH:mm:ss”
     * 
     * @return Date
     * */
    public static Date parseStr(String dateStr,String pattern){
        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        if(StringUtils.isBlank(pattern)){
            pattern = DATE_TIME_FORMATER;
        }
        return DateTimeFormat.forPattern(pattern).parseDateTime(dateStr).toDate();
    }
    
    /**
     * 计算两个日期之间的时间间隔(不计算毫秒数)
     * @param date1,date2
     * @param timeType
     * 
     * @return int
     * */
    public static int periodBtDate(Date date1,Date date2,TimeType timeType){
        if(date1 == null || date2 == null){
            throw new IllegalArgumentException("date param can not be null");
        }
        DateTime start = fromDate(date1) ;
        DateTime end = fromDate(date2);
        int period = 0;
        switch(timeType.getCode()){
        case "Y":
            period = Years.yearsBetween(start, end).getYears();
            break;
        case "M":
            period = Months.monthsBetween(start, end).getMonths();
            break;
        case "W":
            period = Weeks.weeksBetween(start, end).getWeeks();
            break;
        case "D":
            period = Days.daysBetween(start, end).getDays();
            break;
        case "H":
            period = Hours.hoursBetween(start, end).getHours();
            break;
        case "MIN":
            period = Minutes.minutesBetween(start, end).getMinutes();
            break;
        case "S":
            period = Seconds.secondsBetween(start, end).getSeconds();
            break;
        default:
            break;
        }
        return Math.abs(period);
    }
    
    /**
     * 比较时间先后
     * @param date1,date2
     * date1在前返回true，即2016-01-13在2016-01-15之前
     * 
     * @return boolean
     * */
    public static boolean beforeDate(Date date1,Date date2){
        if(date1 == null || date2 == null){
            throw new IllegalArgumentException("date param can not be null");
        }
        return fromDate(date1).isBefore(date2.getTime());
    }
    
    /**
     * 比较时间先后
     * @param date1
     * @param date2
     * date1在date2之后返回true
     * @eg.2016-01-15 在 2016-01-13 之后
     * 
     * @return boolean
     * */
    public static boolean afterDate(Date date1,Date date2){
        if(date1 == null || date2 == null){
            throw new IllegalArgumentException("date param can not be null");
        }
        
        return fromDate(date1).isAfter(date2.getTime());
    }
    
    /**
     * Date转为DateTime(Joda)
     * @param date
     * @return DateTime
     * */
    public static DateTime fromDate(Date date){
        return new DateTime(date.getTime());
    }
    
    /**
     * Constructs an instance from datetime field values
     * using <code>ISOChronology</code> in the default time zone.
     *
     * @param year  the year
     * @param monthOfYear  the month of the year, from 1 to 12
     * @param dayOfMonth  the day of the month, from 1 to 31
     * @param hourOfDay  the hour of the day, from 0 to 23
     * @param minuteOfHour  the minute of the hour, from 0 to 59
     * @param secondOfMinute  the second of the minute, from 0 to 59
     */
    public static Date createDate(int year,int monthOfYear,int dayOfMonth,int hourOfDay,int minuteOfHour,int secondOfMinute){
        DateTime dateTime = new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute);
        return dateTime.toDate();
    }
    
    /**
     * 获取日期所在周的第一天的日期
     * */
    public static Date getFirstOfWeek(Date date){
        return fromDate(date).dayOfWeek().withMinimumValue().toDate();
    }
    /**
     * 获取日期所在周的最后一天的日期
     * */
    public static Date getLastOfWeek(Date date){
        return fromDate(date).dayOfWeek().withMaximumValue().toDate();
    }
    
    /**
     * 获取日期所在月的第一天的日期
     * */
    public static Date getFirstOfMonth(Date date){
        return fromDate(date).dayOfMonth().withMinimumValue().toDate();
    }
    
    /**
     * 获取日期所在月的最后一天的日期
     * */
    public static Date getLastOfMonth(Date date){
        return fromDate(date).dayOfMonth().withMaximumValue().toDate();
    }
    
    
    enum TimeType{
        YEAR("Y"),MONTH("M"),WEEK("W"),DAY("D"),HOUR("H"),MIN("MIN"),SECOND("S"),MILLS("MS");
        private String code;
        private TimeType(String code){
            this.code = code;
        }
        
        public String getCode(){
            return this.code;
        }
    }
    
    
}
