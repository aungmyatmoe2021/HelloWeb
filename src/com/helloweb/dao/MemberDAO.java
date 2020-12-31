package com.helloweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public List<String> selectAllMember() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<String> result = new ArrayList<String>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("select user_role_id,user_name,user_role from user_info");
			
			int count = 0;
			while(rset.next()) {
				List<String> column = new ArrayList<String>();
				column.add(0, rset.getString("user_role_id"));
				column.add(1, rset.getString("user_name"));
				column.add(2, rset.getString("user_role"));
				
				result.add(count,column.toString());
				count++;
			}
			System.out.println("Count is "+count);
			
			rset.close();
			stmt.close();
			con.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	
	public List<String> selectMemberByID(String strRoleID) {
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = getConnection();
			
			stmt= con.createStatement();
			
			rset= stmt.executeQuery("SELECT `user_role_id`,`user_name`,`user_role` FROM `user_info` where `user_role_id`='"+strRoleID+"'");
			
			int count=0;
			while(rset.next()) {
				List<String> lsColumn = new ArrayList<String>();
				lsColumn.add(0, rset.getString("user_role_id"));
				lsColumn.add(1, rset.getString("user_name"));
				lsColumn.add(2, rset.getString("user_role"));
				
				lsResult.add(count,lsColumn.toString());
				
				count++;
			}
			System.out.println("Total Number of Member Info is : "+count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select Member Info By ID Error : "+e.getMessage());
		}
		
		return lsResult;
		
	}
	
	public String insertMember(String user_name, String user_role) {
		Connection con = null;
		Statement stmt = null;
		String message = "fail";
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			
			int rowSet = stmt.executeUpdate("Insert user_info (user_name,user_role) values ('"+user_name+"','"+user_role+"')");
			
			System.out.println("Insert count is "+ rowSet);
			
			if(rowSet== 1)
				message = "success";
			
			stmt.close();
			con.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return message;
	}
	
	public String updateMember(String user_role_id, String user_name, String user_role) {
		Connection con = null;
		Statement stmt = null;
		String message = "fail";
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			
			int rowSet = stmt.executeUpdate("Update user_info set user_name='"+user_name+"',user_role='"+user_role+"' where user_role_id = '"+ user_role_id +"'");
			
			System.out.println("Update count is "+ rowSet);
			
			if(rowSet== 1)
				message = "success";
			
			stmt.close();
			con.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return message;
	}
	
	public String deleteMember(String user_role_id) {
		Connection con = null;
		Statement stmt = null;
		String message = "fail";
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			
			int rowSet = stmt.executeUpdate("Delete from user_info where user_role_id = '"+ user_role_id +"'");
			
			System.out.println("Delete count is "+ rowSet);
			
			if(rowSet== 1)
				message = "success";
			
			stmt.close();
			con.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return message;
		
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Found");
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("Error : "+ex.getMessage());
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root1234");
			System.out.println("Connection Successful");
		}catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
		
		return conn;
	}
	
	
	public List<String> checkUserLogin(String strUserName,String strPassword) {
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = getConnection();
			
			stmt= con.createStatement();
			
			rset= stmt.executeQuery("SELECT `user_role_id`,`user_name`,`user_role` FROM `user_info` where `user_name`='"+strUserName+"' and `user_role`='"+strPassword+"'");
			
			int count=0;
			while(rset.next()) {
				List<String> lsColumn = new ArrayList<String>();
				lsColumn.add(0, rset.getString("user_role_id"));
				lsColumn.add(1, rset.getString("user_name"));
				lsColumn.add(2, rset.getString("user_role"));
				
				lsResult.add(count,lsColumn.toString());
				
				count++;
			}
			System.out.println("Total Number of Member Info is : "+count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select Member Info By ID Error : "+e.getMessage());
		}
		
		return lsResult;
		
	}
}
