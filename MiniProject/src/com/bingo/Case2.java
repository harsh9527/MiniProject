package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//1. User Registration

public class Case2 {

	private static void loginUser(String username, String password) throws SQLException {
		// Implement user registration logic

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			// step 1 -loading the driver class
			Class.forName("com.mysql.jdbc.Driver");
			// step 2 - Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bingo", "root", "9527@harsh9527");
			// step 3 - create statement or prepared sql statement
			ps = con.prepareStatement("SELECT userName,password FROM registration WHERE username = ? AND password =?");

			ps.setString(1, username);
			ps.setString(2, password);
			res = ps.executeQuery();

			if (res.next()) {
				res.beforeFirst();
				while (res.next()) {
					String u = res.getString("userName");
					String p = res.getString("password");

					if (u.equalsIgnoreCase(username) == false)
						System.out.println("Enter valid username");

					else if (p.equalsIgnoreCase(password) == false)
						System.out.println("Enter valid password");

					else
						System.out.println("Welcomne to our Ecommers based application");
				}
			} else {
				System.out.println("No Record match");
			}

			// step 4- sumbit the sql statements

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
			ps.close();

		}

	}

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the userName>>");
		String userName = scanner.next();
		System.out.println("Enter the password>>");
		String password = scanner.next();

		Case2.loginUser(userName, password);
	}
}
