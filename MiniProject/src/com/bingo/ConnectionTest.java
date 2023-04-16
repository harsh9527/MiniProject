package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bingo", "root", "9527@harsh9527");

		} catch (Exception e) {
			e.printStackTrace();
			
		} 
		return connection;
		
	}

}
