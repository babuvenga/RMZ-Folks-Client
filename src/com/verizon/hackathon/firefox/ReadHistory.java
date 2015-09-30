package com.verizon.hackathon.firefox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.verizon.hackathon.firefox.vo.UserHistory;
import com.verizon.hackathon.util.HackathonUtil;

public class ReadHistory {
	
	

	public List<UserHistory> getFirefoxHistory(){
		// TODO Auto-generated method stub
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<UserHistory> userHistoryList = new ArrayList<UserHistory>();
		Connection connection = null;
	    try
	    {
	      String profileName = HackathonUtil.getProfileName(Tracking.FILES_LOCATION);
	      System.out.println("Profile name:-"+profileName);
	      String accNum = profileName.replace(".default", "");
	      System.out.println("Account number:-"+accNum);
		  String connectionString = "jdbc:sqlite:" + Tracking.FILES_LOCATION + profileName+ "/places.sqlite";
		  connection = DriverManager.getConnection(connectionString);
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	      ResultSet rs = statement.executeQuery("select url as HOST_NAME, rev_host as FULL_URL, visit_date as VISIT_DATE from moz_places , moz_historyvisits  where moz_places.id = moz_historyvisits.id and moz_places.url like '%verizon%'");
	      while(rs.next())
	      {
	        // read the result set
	    	  
	    	String actualText = ""; 
	        UserHistory userHistory = new UserHistory();
	        String dateandtime = rs.getString("VISIT_DATE");
	        long dt = Long.parseLong(dateandtime);
	        //
	        Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(dt);
			SimpleDateFormat format1 = new SimpleDateFormat("MMM-dd");
			String formatted = format1.format(cal.getTime());
			userHistory.setDateVisitied(formatted);
	        String txt = rs.getString("HOST_NAME");
	        System.out.println(txt);
	        String contents[] = txt.split("=");
	         if(contents.length > 2){
	        	 actualText =  contents[2].replace("+", " ");
	         }else{
	        	 actualText = txt; 
	         }
	        userHistory.setId(accNum);
	        userHistory.setHostname(actualText);
	        userHistory.setTextSearched(HackathonUtil.reverseString(rs.getString("FULL_URL")));
	        userHistoryList.add(userHistory);
	      }
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	    return userHistoryList;
	}

}
