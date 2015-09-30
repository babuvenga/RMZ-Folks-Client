package com.verizon.hackathon.trigger;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleTrigger {

	public static void main(String[] args) throws ParseException, SchedulerException {
		// TODO Auto-generated method stub
		JobDetail job = new JobDetail();
    	job.setName("HistoryJob");
    	job.setJobClass(HistoryJob.class);
    	    	
    	CronTrigger trigger = new CronTrigger();
    	trigger.setName("FirefoxHistoryTrigger");
    	trigger.setCronExpression("0/10 * * * * ?");
    	
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
	}

}
