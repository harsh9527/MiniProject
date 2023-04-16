package com.bingo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration1 {

	// Method to register a new user
    public static void registerUser() throws SQLException {
        //  Implement user registration logic
    
    	OnlineShop onlineShop=new OnlineShop();
    	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter First Name");
			String fname=scanner.next();
			System.out.println("Enter Last Name");
			String lname=scanner.next();
			System.out.println("Enter Username");
			String uname=scanner.next();
			System.out.println("Enter password");
			String pass=scanner.next();
			System.out.println("Enter City");
			String city=scanner.next();
			System.out.println("Enter E-mail");
			String email=scanner.next();
			System.out.println("Enter Mobile");
			String mobile=scanner.next();
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement=connection.prepareStatement("insert into registration(firstName,lastName,userName,password,city,mailId,mobileNumber)values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1,fname);
			preparedStatement.setString(2,lname);
			preparedStatement.setString(3,uname);
			preparedStatement.setString(4,pass);
			preparedStatement.setString(5,city);
			preparedStatement.setString(6,email);
			preparedStatement.setString(7,mobile);
			preparedStatement.executeUpdate();
			System.out.println("Registration Successfull>>");
			onlineShop.getUserStoryDetails1();
		}catch(Exception e){
			System.out.println(e);
		}finally {
			connection.close();
			preparedStatement.close();
			
		}
   
	
    }
}
