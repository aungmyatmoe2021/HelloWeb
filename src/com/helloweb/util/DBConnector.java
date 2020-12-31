package com.helloweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {

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
			
			ResultSet rset = stmt.executeQuery("select user_role_id,user_name,user_role from user_info");
			
			int count = 0;
			while(rset.next()) {
				System.out.println("User ID : "+rset.getInt(1));
				System.out.println("User Name : "+rset.getString(2));
				System.out.println("User Role : "+rset.getString(3));
				System.out.println("===============================");
				count++;
			}
			System.out.println("Count is "+count);
			
			rset.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
