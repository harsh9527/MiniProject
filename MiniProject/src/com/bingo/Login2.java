package com.bingo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Login2 {

	// Method to login a user
	
	public static  String uname;
	public static String pass;
	
	public void getLogin() throws SQLException {
		
		ProductDisplay3 productDisplay3=new ProductDisplay3();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username>>");
		this.uname=scanner.next();
		System.out.println("Enter Password>>");
		this.pass=scanner.next();
		int count=0;
		try {
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement=connection.prepareStatement("select userName,password from registration");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(uname.equals(resultSet.getString("userName")) && pass.equals(resultSet.getString("password"))) {	
					System.out.println("Successfully Login");
					count++;
				}
			}
			if(count>0) {
				productDisplay3.getProductList();
			}
			if(count==0) {
				System.out.println("Something Went wrong");
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
