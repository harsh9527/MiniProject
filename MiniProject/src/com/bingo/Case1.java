package com.bingo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//1. User Registration

public class Case1 {

	private static void registerUser(String fname,String lname,String username,String password,String city , String mailid,String monumber) throws SQLException {
		// Implement user registration logic
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			// step 1 -loading the driver class
			Class.forName("com.mysql.jdbc.Driver");
			// step 2 - Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bingo", "root", "9527@harsh9527");
			// step 3 - create statement or prepared sql statement
			ps = con.prepareStatement(
					"insert into registration (firstName,lastName,userName,password,city,mailId,mobileNumber)values(?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, mailid);
			ps.setString(7, monumber);
			
			// step 4- sumbit the sql statements
			int a = ps.executeUpdate();
			System.out.println(a);
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
			ps.close();

		}

	}

	public static void main(String[] args) throws SQLException {

		System.out.println("Enter the first name>>");
        Scanner scanner = new Scanner(System.in);
        String firstName=scanner.next();
        System.out.println("Enter the last name>>");
		String lastName=scanner.next();
		System.out.println("Enter the userName>>");
		String userName=scanner.next();
		System.out.println("Enter the password>>");
		String password=scanner.next();
		System.out.println("Enter the city>>");
		String city=scanner.next();
		System.out.println("Enter the mail id");
		String mailId=scanner.next();
		System.out.println("Enter the mobile number>>");
		String mobileNumber=scanner.next();
		
		Case1.registerUser(firstName, lastName, userName, password, city, mailId, mobileNumber);
	}
}/*
	 * Enter your choice- 1 Enter the first name>> Enter the last name>> Enter the
	 * username>> Enter the password>> Enter the city>> Enter the mail id>> Enter
	 * the mobile number>>
	 */
