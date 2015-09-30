package com.verizon.hackathon.trigger;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.verizon.hackathon.dao.HistoryDAO;
import com.verizon.hackathon.firefox.ReadHistory;
import com.verizon.hackathon.firefox.vo.UserHistory;

public class HistoryJob implements Job{


	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("Triggering History Job");
		ReadHistory rh = new ReadHistory();
		List<UserHistory> his = rh.getFirefoxHistory();
		
		HistoryDAO hisDAO = new HistoryDAO();
		hisDAO.insertVerizonSearchHistory(his);
		
	}

}
