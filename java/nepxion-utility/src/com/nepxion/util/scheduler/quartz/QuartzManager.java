package com.nepxion.util.scheduler.quartz;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

public class QuartzManager
	implements QuartzConstants
{
	public static void start()
		throws SchedulerException
	{
		if (!QuartzContext.getScheduler().isStarted())
		{
			QuartzContext.getScheduler().start();
		}
	}
	
	public static void scheduleJob(Class jobClass, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobClass.getName(), jobClass.getName(), jobClass.getName(), jobClass.getName(), jobClass, null, null, repeatInterval);
	}
	
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobName, jobGroup, jobTriggerName, jobTriggerGroup, jobClass, null, null, repeatInterval);
	}
	
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, Date startTime, Date endTime, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobName, jobGroup, jobTriggerName, jobTriggerGroup, jobClass, startTime, endTime, QuartzJobTrigger.REPEAT_INDEFINITELY, repeatInterval);
	}
	
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobName, jobGroup, jobTriggerName, jobTriggerGroup, false, false, false, jobClass, startTime, endTime, repeatCount, repeatInterval);
	}
	
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, boolean volatility, boolean durability, boolean recover, Class jobClass, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
		throws SchedulerException
	{
		QuartzJobDetail jobDetail = new QuartzJobDetail(jobName, jobGroup, jobClass, volatility, durability, recover);
		QuartzJobTrigger jobTrigger = new QuartzJobTrigger(jobTriggerName, jobTriggerGroup, jobName, jobGroup, startTime != null ? startTime : new Date(), endTime, repeatCount, repeatInterval);
		
		scheduleJob(jobDetail, jobTrigger);
	}
	
	public static void scheduleJob(QuartzJobDetail jobDetail, QuartzJobTrigger jobTrigger)
		throws SchedulerException
	{
		String jobName = jobDetail.getName();
		String jobGroup = jobDetail.getGroup();
		
		if (QuartzContext.getScheduler().getJobDetail(jobName, jobGroup) == null)
		{
			QuartzContext.getScheduler().scheduleJob(jobDetail, jobTrigger);
		}
	}
	
	public static void unscheduleJob(Class jobClass)
		throws SchedulerException
	{
		unscheduleJob(jobClass.getName(), jobClass.getName());
	}
	
	public static void unscheduleJob(String jobName, String jobGroup)
		throws SchedulerException
	{
		if (QuartzContext.getScheduler().getJobDetail(jobName, jobGroup) != null)
		{
			QuartzContext.getScheduler().unscheduleJob(jobName, jobGroup);
		}
	}
	
	public static boolean isScheduled(Class jobClass)
		throws SchedulerException
	{
		return isScheduled(jobClass.getName(), jobClass.getName());
	}
	
	public static boolean isScheduled(String jobName, String jobGroup)
		throws SchedulerException
	{
		return QuartzContext.getScheduler().getJobDetail(jobName, jobGroup) != null;
	}
	
	public static Scheduler getScheduler()
	{
		return QuartzContext.getScheduler();
	}
	
	public static void setContextObject(Object contextObject)
		throws SchedulerException
	{
		SchedulerContext schedulerContext = getScheduler().getContext();

		if (schedulerContext.get(CONTEXT_OBJECT) == null)
		{
			schedulerContext.put(CONTEXT_OBJECT, contextObject);
		}
	}
	
	public static Object getContextObject()
		throws SchedulerException
	{
		SchedulerContext schedulerContext = getScheduler().getContext();

		return schedulerContext.get(CONTEXT_OBJECT);
	}
}