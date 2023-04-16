package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantity10 {

	// Method to check quantity
	public void checkQuantity() throws SQLException {
	    // Implement check quantity logic
	
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Id to get Product Quantity");
		int pid=scanner.nextInt();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			
			ConnectionTest connectionTest=new ConnectionTest(); 
			connection=connectionTest.getConnection();
			
			preparedStatement=connection.prepareStatement("select quantity from products where prod_id=?");
			preparedStatement.setInt(1, pid);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Product Quantity>>"+resultSet.getInt("quantity"));
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
