package me.mushen.examples.java.simple.convert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Desc 日期时间工具类
 * @Author Remilia
 * @Create 2016-09-05
 */
public final class Dates {

    public static Date addDay(Date date, int day) {
        return addHour(date, day * 24L);
    }

    /**
     * 将给定的日期时间, 往后推给定的小时
     * @param date java.util.Date
     * @param hour 小时
     * @return
     */
    public static Date addHour(Date date, long hour){
        return addMinute(date, hour * 60L);
    }

    /**
     * 将给定的日期时间, 往后推给定的分钟
     * @param date java.util.Date
     * @param minute 分钟
     * @return
     */
    public static Date addMinute(Date date, long minute){
        return addSecond(date, minute * 60L);
    }

    /**
     * 将给定的日期时间, 往后推给定的秒
     * @param date java.util.Date
     * @param second 秒
     * @return
     */
    public static Date addSecond(Date date, long second){
        if(date == null){
            return null;
        }else {
            long millis = date.getTime() + second * 1000L;
            return new Date(millis);
        }
    }

    /**
     * 当前时间是否处于两个时间之间
     * @param beginTime java.util.Date
     * @param endTime java.util.Date
     * @return
     */
    public static boolean isBetweenNow(Date beginTime, Date endTime){
        return isBetween(beginTime, endTime, new Date());
    }

    /**
     * 给定时间是否早于当前时间
     * @param date java.util.Date
     * @return
     */
    public static boolean isBeforeNow(Date date){
        return isBefore(date, new Date());
    }

    /**
     * 给定时间是否晚于当前时间
     * @param date java.util.Date
     * @return
     */
    public static boolean isAfterNow(Date date){
        return isAfter(date, new Date());
    }

    /**
     * date是否位于beginTime和endTime之间
     * 如果有任意时间为空, 则返回false
     * @param beginTime java.util.Date
     * @param endTime java.util.Date
     * @param date java.util.Date
     * @return
     */
    public static boolean isBetween(Date beginTime, Date endTime, Date date) {
        return  isAllNotNull(beginTime, endTime, date) &&
                !beginTime.after(date) && !endTime.before(date);
    }

    /**
     * date1和date2是否相等
     * 如果有任意时间为空, 则返回false
     * @param date1 java.util.Date
     * @param date2 java.util.Date
     * @return
     */
    public static boolean isEqual(Date date1, Date date2) {
        return isAllNotNull(date1, date2) && date1.compareTo(date2) == 0;
    }

    /**
     * date1是否早于date2
     * 如果有任意时间为空, 则返回false
     * @param date1 java.util.Date
     * @param date2 java.util.Date
     * @return
     */
    public static boolean isBefore(Date date1, Date date2){
        return isAllNotNull(date1, date2) && date1.compareTo(date2) < 0;
    }

    /**
     * date1是否晚于date2
     * 如果有任意时间为空, 则返回false
     * @param date1 java.util.Date
     * @param date2 java.util.Date
     * @return
     */
    public static boolean isAfter(Date date1, Date date2){
        return isAllNotNull(date1, date2) && date1.compareTo(date2) > 0;
    }

    public static Date endOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    public static Date beginOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取当天23点59分59秒Date
     * @return
     */
    public static Date endOfCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return calendar.getTime();
    }

    /**
     *  获取当天0点0分0秒Date
     * @return
     */
    public static Date beginOfCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return calendar.getTime();
    }

    /**
     * 将java.util.Date格式化成yyyy-MM-dd HH:mm:ss形式
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return date == null ? "" : format.format(date);
    }

    /**
     * 获取java.util.Date日期的时间戳
     * @param date
     * @return
     */
    public static long dateToTimestamp(Date date) {
        return date == null ? 0L : date.getTime();
    }

    /**
     * 将日期时间戳格式化成yyyy-MM-dd HH:mm:ss形式
     * @param timestamp
     * @return
     */
    public static String timestampToString(long timestamp) {
        return timestamp == 0L ? "" : dateToString(new Date(timestamp));
    }

    /**
     * 将日期字符串转换成java.util.Date对象, 格式: yyyy-MM-dd HH:mm:ss
     * @param dateString 日期字符串
     * @return
     */
    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期字符串转换成java.util.Date对象
     * @param dateString 日期字符串
     * @param format 格式化日期格式
     * @return
     */
    public static Date stringToDate(String dateString, String format) {
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat(format);
            timeFormat.setLenient(false);
            return timeFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    public static String nowStr() {
        return dateToString(new Date());
    }

    /**
     * 给定的日期时间是否都不为空
     * @param dates java.util.Date
     * @return
     */
    private static boolean isAllNotNull(Date... dates){
        for(Date date : dates){
            if(date == null){
                return false;
            }
        }
        return true;
    }

    // 禁止实例化该类
    private Dates(){}
}
