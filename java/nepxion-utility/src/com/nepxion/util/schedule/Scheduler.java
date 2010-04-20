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

public class Scheduler
{
    class SchedulerTimerTask
        extends TimerTask
    {
        private SchedulerTask schedulerTask;
        private ScheduleIterator iterator;
        public SchedulerTimerTask(SchedulerTask schedulerTask, ScheduleIterator iterator)
        {
            this.schedulerTask = schedulerTask;
            this.iterator = iterator;
        }

        public void run()
        {
            schedulerTask.run();
            reschedule(schedulerTask, iterator);
        }
    }


    private final Timer timer = new Timer();

    public Scheduler()
    {
    }

    public void cancel()
    {
        timer.cancel();
    }

    public void schedule(SchedulerTask schedulerTask, ScheduleIterator iterator)
    {
        Date time = iterator.next();
        if (time == null)
        {
            schedulerTask.cancel();
        }
        else
        {
            synchronized (schedulerTask.lock)
            {
                if (schedulerTask.state != SchedulerTask.VIRGIN)
                {
                    throw new IllegalStateException("Task already scheduled " + "or cancelled");
                }
                schedulerTask.state = SchedulerTask.SCHEDULED;
                schedulerTask.timerTask = new SchedulerTimerTask(schedulerTask, iterator);
                timer.schedule(schedulerTask.timerTask, time);
            }
        }
    }

    private void reschedule(SchedulerTask schedulerTask, ScheduleIterator iterator)
    {
        Date time = iterator.next();
        if (time == null)
        {
            schedulerTask.cancel();
        }
        else
        {
            synchronized (schedulerTask.lock)
            {
                if (schedulerTask.state != SchedulerTask.CANCELLED)
                {
                    schedulerTask.timerTask = new SchedulerTimerTask(schedulerTask, iterator);
                    timer.schedule(schedulerTask.timerTask, time);
                }
            }
        }
    }
}