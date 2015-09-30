package com.verizon.hackathon.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

import com.verizon.hackathon.firefox.vo.UserHistory;

public class HistoryDAO {
	
	public static final String dbUrl = "jdbc:oracle:thin:@113.128.163.225:1521:XE";
	public static final String dbUserName = "rmzfolks";
	public static final String dbPwd = "rmzfolks";
	
	public void insertVerizonSearchHistory(List<UserHistory> uHistory)
	{
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPwd);
			String sqlQuery = "insert into USER_SEARCH_HISTORY (ACCOUNT_NUMBER,SEARCH_STRING,WEBSITE,INSERTED_DATE) values (?,?,?,?)";
			stmt = con.prepareStatement(sqlQuery);
			for(UserHistory history:uHistory){
				stmt.setString(1, history.getId());
				stmt.setString(2, history.getHostname());
				stmt.setString(3, history.getTextSearched());
				stmt.setString(4, history.getDateVisitied());
				try{
					stmt.executeUpdate();
				}
				catch (SQLIntegrityConstraintViolationException violation){
					System.out.println("Value already found in database");
				}
			}
			 
		}
		
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
}
