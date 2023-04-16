package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewProductGuest13 {

	// Method to not purchase an item
	public void getProductListGuest() throws SQLException {
	    //  Implement not purchase item logic
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			
			preparedStatement=connection.prepareStatement("select * from products");
			resultSet=preparedStatement.executeQuery();
			int count=0;
			while(resultSet.next()) {
				count++;
				System.out.println("Product Id="+resultSet.getInt(1));
				System.out.println("Product Name="+resultSet.getString(2));
				System.out.println("Product Description="+resultSet.getString(3));
				System.out.println("Product Quantity="+resultSet.getInt(4));
				System.out.println("Price="+resultSet.getInt(5));
			}
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
