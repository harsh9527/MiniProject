package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CalculateBill8 {

	// Method to calculate bill
	public void calculateBill() throws SQLException {
		
	    //  Implement calculate bill logic
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int bill=0;
		try {
			System.out.println("Enter Username To Calculate Bill");
			Scanner scanner=new Scanner(System.in);
			String uname=scanner.next();
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement=connection.prepareStatement("select * from cart where username=?");
			preparedStatement.setString(1, uname);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Product Id="+resultSet.getInt("productId"));
				System.out.println("Product Quantity="+resultSet.getInt("quantity"));
				System.out.println("Product Price="+resultSet.getInt("price"));
				bill=bill+resultSet.getInt("price");	
			}
			System.out.println("Total Bill="+bill);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
