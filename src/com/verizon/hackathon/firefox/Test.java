package com.verizon.hackathon.firefox;

import java.util.Calendar;
import java.util.List;

import com.verizon.hackathon.dao.HistoryDAO;
import com.verizon.hackathon.firefox.vo.UserHistory;
import com.verizon.hackathon.util.HackathonUtil;

public class Test {
	
	public static void main(String[] args){
		/*ReadHistory rh = new ReadHistory();
		List<UserHistory> his = rh.getFirefoxHistory();
		for(UserHistory user:his){
			System.out.println(user);
		}
		HistoryDAO hisDAO = new HistoryDAO();
		hisDAO.insertVerizonSearchHistory(his);
		*/
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(1443520978336000L);
		System.out.println(cal.getTime());
		
		cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
cal.add(Calendar.DATE, +1);
		
		System.out.println(cal.getTimeInMillis());
	}
	
	

}
