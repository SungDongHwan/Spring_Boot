package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogDaoH2 implements LogDao  {
	
	Connection con;
	Statement st;
	PreparedStatement psmt;
	ResultSet rs;
	public LogDaoH2() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.h2.Driver");
			con =DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB 연결성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB연결중 에러");
		}
	}

	public void addLog(String method, String query, boolean success) {
		try {
			String sql = "Insert into DBlog (method, sqlString, success)"
					+ "values(?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, method);
			psmt.setString(2, query);
			psmt.setBoolean(3, success);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void addLog(String method, String url, Object result) {
		addLog(method, url, (result!=null)?true:false); 
	}
	@Override
	public void addLogdao() {
		// TODO Auto-generated method stub
		
	}
	
}
