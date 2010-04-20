package com.nepxion.util.schedule;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune �κƾ�
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.*;

import com.nepxion.util.time.*;

public class ScheduleExecuter
{
    private Scheduler scheduler = new Scheduler();
    private ScheduleIteratorImpl scheduleIterator = new ScheduleIteratorImpl();

    public void executeScheduler(SchedulerTask schedulerTask)
    {
        executeScheduler(schedulerTask, scheduleIterator.getIntervalDayTime());
    }

    // ��ǰʱ�俪ʼ��ʱ
    public void executeScheduler(SchedulerTask schedulerTask, int[] intervalDayTime)
    {
        executeScheduler(schedulerTask, intervalDayTime, new Date(), new int[]{TimeUtil.getCurrentHour(), TimeUtil.getCurrentMinute(), TimeUtil.getCurrentSecond()});
    }

    public void executeScheduler(SchedulerTask schedulerTask, int[] intervalDayTime, Date startDay, int[] startTime)
    {
        // ��ʱ��ʼʱ�� -- ���ڣ�ʱ��(��/Сʱ/����/��)
        scheduleIterator.setScheduleDayTime(startDay, startTime);

        // ��ʱ���ʱ�� -- ʱ��(��/Сʱ/����/��/����)
        scheduleIterator.setIntervalDayTime(intervalDayTime);

        // ��ʱ��ʼ
        scheduler.schedule(schedulerTask, scheduleIterator);
        /*try
        {
            schedulerTask.run();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }*/
    }
}