package com.helloweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestForSql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Found");
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("Error : "+ex.getMessage());
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root1234");
			System.out.println("Connection Successful");
			
			Statement stmt = con.createStatement();
			
//			int rowEffect = stmt.executeUpdate("insert into user_info(user_name,user_role) values('student','student')");
			
//			int rowEffect = stmt.executeUpdate("update user_info set user_role='manager' where user_role_id=4");
			
			int rowEffect = stmt.executeUpdate("delete from user_info where user_role_id=4");
			
			System.out.println("Row Effect is "+rowEffect);
			if(rowEffect == 1)
				System.out.println("Saving Successful");
			else
				System.err.println("Saving Fail");
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
