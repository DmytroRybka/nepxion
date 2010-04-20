package com.nepxion.util.time;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune �κƾ�
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class TimeUtil
{
	/**
	 * ��ȡ��ǰ���
	 */
	public static int getCurrentYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * ��ȡ��ǰ�·�
	 */
	public static int getCurrentMonth()
	{
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	
	/**
	 * ��ȡ��ǰ����
	 */
	public static int getCurrentDay()
	{
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
	/**
	 * ��ȡ��ǰСʱ
	 */
	public static int getCurrentHour()
	{
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * ��ȡ��ǰ����
	 */
	public static int getCurrentMinute()
	{
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	/**
	 * ��ȡ��ǰ��
	 */
	public static int getCurrentSecond()
	{
		return Calendar.getInstance().get(Calendar.SECOND);
	}
	
	/**
	 * ��ȡ��ǰ����
	 */
	public static int getCurrentMilliSecond()
	{
		return Calendar.getInstance().get(Calendar.MILLISECOND);
	}
	
	/**
	 * ��ȡ��ǰ���������ں�ʱ�䣬��ʽΪyyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDateTime()
	{
		return getDateTime(new Date());
	}
	
	/**
	 * ��ȡĳʱ�̵����������ں�ʱ��, ��ʽΪyyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime(Date date)
	{
		return getFormatString(date, getDateTimeFormat());
	}
	
	/**
	 * ��ȡ��ǰ���ڣ���ʽΪyyyy-MM-dd
	 */
	public static String getCurrentDate()
	{
		return getDate(new Date());
	}
	
	/**
	 * ��ȡĳ�����ڵ��ַ�����ʽ����ʽΪyyyy-MM-dd
	 */
	public static String getDate(Date date)
	{
		return getFormatString(date, getDateFormat());
	}
	
	/**
	 * ��ȡ��ǰʱ�̵�ʱ�䣬��ʽΪHH:mm:ss
	 */
	public static String getCurrentTime()
	{
		return getTime(new Date());
	}
	
	/**
	 * ��ȡĳʱ�̵�ʱ�䣬��ʽΪHH:mm:ss
	 */
	public static String getTime(Date time)
	{
		return getFormatString(time, getTimeFormat());
	}
	
	/**
	 * ת��ʱ���ʽΪ�ַ�����ʽ��ͨ�÷���
	 */
	public static String getFormatString(Date date, DateFormat dateFormat)
	{
		return dateFormat.format(date);
	}
	
	/**
	 * ��ȡ������һ�����ڵĵڼ���
	 */
	public static int getCurrentDayOfWeek()
	{
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * ��ȡĳ����һ�����ڵĵڼ���
	 */
	public static int getDayOfWeek(int year, int month, int date)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * ��ȡ�������ڵ������ǵ��µĵڼ�������
	 */
	public static int getCurrentWeekOfMonth()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * ��ȡĳ�����ڵ������ǵ��µĵڼ�������
	 */
	public static int getWeekOfMonth(int year, int month, int date)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * ��ȡ�������ڵ�������һ��ĵڼ�������
	 */
	public static int getCurrentWeekOfYear()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * ��ȡĳ�����ڵ�������һ��ĵڼ�������
	 */
	public static int getWeekOfYear(int year, int month, int date)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * �������������ں�ʱ�䣬��ȡ���ڶ��󣬸�ʽΪyyyy-MM-dd HH:mm:ss
	 */
	public static Date parseDateTime(String date)
	{
		return parseFormatString(date, getDateTimeFormat());
	}
	
	/**
	 * �������������ڣ���ȡ���ڶ��󣬸�ʽΪyyyy-MM-dd
	 */
	public static Date parseDate(String date)
	{
		return parseFormatString(date, getDateFormat());
	}
	
	/**
	 * ����������ʱ�䣬��ȡ���ڶ��󣬸�ʽΪHH:mm:ss
	 */
	public static Date parseTime(String time)
	{
		return parseFormatString(time, getTimeFormat());
	}
	
	/**
	 * ת���ַ�����ʽΪʱ���ʽ��ͨ�÷���
	 */
	public static Date parseFormatString(String dateString, DateFormat dateFormat)
	{
		dateString = dateString.trim();
		Date date = null;
		try
		{
			date = dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * ������������ʱ��ͱ�׼ʱ��֮���ƫ�һ��ΪһСʱ���紫���Ϊ������ʱ�䣬��ƫ��ֵΪ0
	 */
	public static int getDSTOffset(Date date)
	{
		return getDSTOffset(date, TimeZone.getDefault());
	}
	
	/**
	 * ������������ʱ��ͱ�׼ʱ��֮���ƫ�һ��ΪһСʱ���紫���Ϊ������ʱ�䣬��ƫ��ֵΪ0
	 */
	public static int getDSTOffset(Date date, TimeZone timeZone)
	{				
		if (timeZone.inDaylightTime(date))
		{
			int offset = timeZone.getOffset(date.getTime()) - timeZone.getRawOffset();
			return offset;
		}
		return 0;
	}
	
	/**
	 * ����������ʱ�䣬��ȡGregorianCalendar����
	 */
	public static GregorianCalendar parseCalendar(String time)
	{
		GregorianCalendar gc = new GregorianCalendar();
		Date date = parseTime(time);
		gc.setTime(date);
		return gc;
	}
	
	/**
	 * ��ȡ������ʱ����ʱ���ʽ
	 */
	public static String getTimeInterval(long startTimeInMillis, long endTimeInMillis)
	{
		long timeInMillis = Math.abs((endTimeInMillis - startTimeInMillis) / 1000);
		
		long hours = timeInMillis / 3600;
		timeInMillis = timeInMillis - (hours * 3600);
		
		long minutes = timeInMillis / 60;
		timeInMillis = timeInMillis - (minutes * 60);
		
		long seconds = timeInMillis;
		
		return getTimeString(hours, minutes, seconds);
	}
	
	/**
	 * �ж�ʱ��time1�Ƿ���ʱ��time2֮ǰ����ʽΪyyyy-MM-dd HH:mm:ss
	 */
	public static boolean isTimeBefore(String time1, String time2)
	{
		return isTimeBefore(time1, time2, getDateTimeFormat());
	}
	
	/**
	 * �ж�ʱ��time1�Ƿ���ʱ��time2֮ǰ
	 */
	public static boolean isTimeBefore(String time1, String time2, DateFormat dateFormat)
	{
		time1 = time1.trim();
		time2 = time2.trim();
		try
		{
			return dateFormat.parse(time1).before(dateFormat.parse(time2));
		}
		catch (ParseException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �жϵ�ǰʱ���Ƿ���ʱ��time2֮ǰ����ʽΪyyyy-MM-dd HH:mm:ss
	 */
	public static boolean isTimeBefore(String time2)
	{
		return isTimeBefore(time2, getDateTimeFormat());
	}
	
	/**
	 * �жϵ�ǰʱ���Ƿ���ʱ��time2֮ǰ
	 */
	public static boolean isTimeBefore(String time2, DateFormat dateFormat)
	{
		time2 = time2.trim();
		try
		{
			Date time1 = new Date();
			return time1.before(dateFormat.parse(time2));
		}
		catch (ParseException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �õ�һ����������ʱ������ں����� 
	 */
	public static long getDateMilliSecond(Date date)
	{
		return date.getTime() - getTimeMilliSecond(date);
	}	
	
	/**
	 * �õ�һ����������ʱ���ʱ������� 
	 */
	public static long getTimeMilliSecond(Date date)
	{
		return date.getTime() % (24 * 60 * 60 * 1000);
	}
	
	/**
	 * ת��ʱ���ʽΪ����
	 */
	public static int[] parseTimeArray(String timeValue)
	{
		int[] timeArray = new int[5];
		StringTokenizer st = new StringTokenizer(timeValue, ",");
		int i = 0;
		while (st.hasMoreTokens())
		{
			timeArray[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		return timeArray;
	}
	
	/**
	 * ת��ʱ������Ϊ��
	 */
	public static long parseSecond(int[] timeArray)
	{
		return timeArray[0] * 24 * 60 * 60 + timeArray[1] * 60 * 60 + timeArray[2] * 60 + timeArray[3];
	}
	
	/**
	 * ת��ʱ������Ϊ����
	 */
	public static long parseMilliSecond(int[] timeArray)
	{
		return parseSecond(timeArray) * 1000 + timeArray[4];
	}
	
	/**
	 * ת���������ַ���
	 */
	public static String getDateString(long year, long month, long day)
	{
		String yearString = year + "";
		String monthString = null;
		String dayString = null;
		
		if (month < 10)
		{
			monthString = "0" + month;
		}
		else
		{
			monthString = "" + month;
		}
		
		if (day < 10)
		{
			dayString = "0" + day;
		}
		else
		{
			dayString = "" + day;
		}
		return yearString + "-" + monthString + "-" + dayString;
	}
	
	/**
	 * ת����ʱ���ַ���
	 */
	public static String getTimeString(long hour, long minute, long second)
	{
		String hourString = null;
		String minuteString = null;
		String secondString = null;
		
		if (hour < 10)
		{
			hourString = "0" + hour;
		}
		else
		{
			hourString = "" + hour;
		}
		
		if (minute < 10)
		{
			minuteString = "0" + minute;
		}
		else
		{
			minuteString = "" + minute;
		}
		
		if (second < 10)
		{
			secondString = "0" + second;
		}
		else
		{
			secondString = "" + second;
		}
		return hourString + ":" + minuteString + ":" + secondString;
	}
	
	/**
	 * �����ڶ��߳���Ӧ�ò���ȫ
	 */
	public static DateFormat getDateTimeFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * �����ڶ��߳���Ӧ�ò���ȫ
	 */
	public static DateFormat getDateFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd");
	}
	
	/**
	 * �����ڶ��߳���Ӧ�ò���ȫ
	 */
	public static DateFormat getMilliSecondTimeDateFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	}
	
	/**
	 * �����ڶ��߳���Ӧ�ò���ȫ
	 */
	public static DateFormat getTimeFormat()
	{
		return new SimpleDateFormat("HH:mm:ss");
	}
	
	/**
	 * �����ڶ��߳���Ӧ�ò���ȫ
	 */
	public static DateFormat getMilliSecondTimeFormat()
	{
		return new SimpleDateFormat("HH:mm:ss:SSS");
	}
	
	public static void main(String[] args)
	{		
//		System.out.println("getCurrentYear() : " + getCurrentYear());
//		System.out.println("getCurrentMonth() : " + getCurrentMonth());
//		System.out.println("getCurrentDay() : " + getCurrentDay());
//		System.out.println("getCurrentHour() : " + getCurrentHour());
//		System.out.println("getCurrentMinute() : " + getCurrentMinute());
//		System.out.println("getCurrentSecond() : " + getCurrentSecond());
//		System.out.println("getCurrentMilliSecond() : " + getCurrentMilliSecond());
//		System.out.println("getCurrentDateTime() : " + getCurrentDateTime());
//		System.out.println("getDateTime() : " + getDateTime(new Date()));
//		System.out.println("getCurrentDate() : " + getCurrentDate());
//		System.out.println("getDate() : " + getDate(new Date()));
//		System.out.println("getCurrentTime() : " + getCurrentTime());
//		System.out.println("getTime() : " + getTime(new Date()));
//		System.out.println("getCurrentDayOfWeek() : " + getCurrentDayOfWeek());
//		System.out.println("getDayOfWeek() : " + getDayOfWeek(2010, 3, 9));
//		System.out.println("getCurrentWeekOfMonth() : " + getCurrentWeekOfMonth());
//		System.out.println("getWeekOfMonth() : " + getWeekOfMonth(2209, 4, 9));
//		System.out.println("getCurrentWeekOfYear() : " + getCurrentWeekOfYear());
//		System.out.println("getWeekOfYear() : " + getWeekOfYear(2010, 3, 9));
//		System.out.println("parseDateTime() : " + parseDateTime("2010-01-01 01:01:01"));
//		System.out.println("parseDate() : " + parseDate("2012-02-02"));
//		System.out.println("parseTime() : " + parseTime("02:02:02"));
		
		Date date1 = parseDateTime("2000-10-29 00:59:59");
		System.out.println("Date : " + date1);
		
		int offset1 = getDSTOffset(date1);
		System.out.println("Offset: " + offset1);
		
		Date date2 = parseDateTime("2000-10-29 01:00:00");
		System.out.println("Date : " + date2);
		
		int offset2 = getDSTOffset(date2);
		System.out.println("Offset: " + offset2);
		
//		Date date5 = parseDateTime("2000-10-29 00:59:59:111");
//		String dateString5 = getFormatString(date5, getDateFormat());
//		
//		Date date6 = parseDateTime("2005-11-01 23:00:00:222");
//		String dataString6 = getFormatString(date6, getMilliSecondTimeFormat());
//		
//		Date date7 = parseDateTime(dateString5 + " " + dataString6);
//		System.out.println(date7);
	}
}