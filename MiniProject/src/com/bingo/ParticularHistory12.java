package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ParticularHistory12 {

	// Method to check user history
	public void checkUserHistory() throws SQLException {
	    //  Implement check user history logic
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int bill=0;
		try {
			System.out.println("Enter Username to check History>>");
			Scanner scanner=new Scanner(System.in);
			String uname=scanner.next();
			
			ConnectionTest connectionTest =new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement=connection.prepareStatement("select * from cart where username=?");
			preparedStatement.setString(1, uname);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Username="+resultSet.getString(1));
				System.out.println("Product Id="+resultSet.getInt(2));
				System.out.println("Quantity="+resultSet.getInt(3));
				System.out.println("Price="+resultSet.getString(4));
				bill=bill+resultSet.getInt("price");
			}
			System.out.println("Total Bill="+bill);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	
	}
}
