package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckRegisteredUser11 {

	// Method to check registered user
	public void checkRegisteredUser() throws SQLException {
	    //  Implement check registered user logic

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username>>");
		String uname=scanner.next();
		System.out.println("Enter Password>>");
		String pass=scanner.next();
		
		try {
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement=connection.prepareStatement("select userName,password from registration");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(uname.equals(resultSet.getString("userName")) && pass.equals(resultSet.getString("password"))) {	
					System.out.println("You are Registered User");
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
		
	}
}
