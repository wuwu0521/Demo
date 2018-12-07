package com.springboot.commom.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author YaoXuYang
 * @date 2017年12月18日
 * @description
 */
public class DateUtils {

	/**
	 * 当前时间
	 * @return Date
	 */
	public static Date currentTime(){
		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(new Date()); 
		return calendar.getTime(); 
	}
	
	/**
	 * 获取当前日期
	 * 
	 * @return String
	 */
	public static String getNowTime() {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date date = calendar.getTime();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = format.format(date);
		return result;
	}
	
	/**
	 * 15天前时间
	 * @return Date
	 */
	public static Date fifteenDaysAgoTime(){
		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 15); // 7天之前的时间
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE));
		return calendar.getTime();
	}
	
	/**
	 * 七天前时间
	 * @return Date
	 */
	public static Date sevenDaysAgoTime(){
		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 7); // 7天之前的时间
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE));
		return calendar.getTime();
	}
	
	/**
	 * 获取今天开始时间
	 * @return Date
	 */
    public static String getTodayStartTime() {
		String result = "";
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = format.format(date);
		return result;
	}
	/**
	 * 获取今天结束时间
	 * @return Date
	 */
    public static String getTodayEndTime() {
		String result = "";
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = format.format(date);
		return result;
	}

	/**
	 * 获取昨天开始时间
	 * 
	 * @author litao
	 * @date 2017年12月27日
	 */
	public static String getYesterdayStartTime() {
		String result = "";
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = format.format(date);
		return result;
	}

	/**
	 * 获取当天星期几
	 * 7是星期日、1是星期一、2是星期二、3是星期三、4是星期四、5是星期五、6是星期六
	 * @return int  
	 * @author litao
	 * @date 2018年1月18日
	 */
	public static int getDayofweek(){  
		int[] dateWeek = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (week < 0) {
			week = 0;
		}
		return dateWeek[week];
	}
	
	/**
	 * Date类型装换成String
	 * 
	 * @param  date
	 * @return String  
	 * @author litao
	 * @date 2018年5月17日
	 */
	public static String getDateChangeString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = null;
		if (date != null) {
			timeStr = formatter.format(date);
		}
		return timeStr;
	}
	
	/**
	 * 分钟转化成当前日期
	 * @param clearCartTime
	 * @return
	 */
	public static String transTimeForString(Integer clearCartTime){
		long nowTime = new Date().getTime();
		long clearTime = clearCartTime * 60 * 1000;
		long time = nowTime - clearTime;
		Date date = new Date(time);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sd.format(date);
	}
	
	/**
	 * 分钟转化成当前日期
	 * @param clearCartTime
	 * @return
	 */
	public static Date transTimeForDate(Integer clearCartTime){
		long nowTime = new Date().getTime();
		long clearTime = clearCartTime * 60 * 1000;
		long time = nowTime - clearTime;
		Date date = new Date(time);
		return date;
	}
	
	/**
	 * 获取当前时间之前的几小时时间 
	 * @param count
	 * @return
	 */
	public static String getBeforeDate(int count){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar calendar = Calendar.getInstance();
	    Date date=new Date();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR, -count);
	    date = calendar.getTime();
	    return sdf.format(date);
	}
}
