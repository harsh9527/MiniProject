package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductDisplay3 extends Login2 {

	String userName = super.uname;
	String password = super.pass;

	public void getProductList() throws SQLException {
		
		BuyProduct4 buyProduct4 = new BuyProduct4();
		OnlineShop OnlineShop = new OnlineShop();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement = connection.prepareStatement("select * from products");
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count++;
				System.out.println("Product Id=" + resultSet.getInt(1));
				System.out.println("\t");
				System.out.println("Product Name=" + resultSet.getString(2));
				System.out.println("Product Description=" + resultSet.getString(3));				
				System.out.println("Price=" + resultSet.getInt(4));
				System.out.println("Product Quantity=" + resultSet.getInt(5));
				System.out.println("\t");
			}
			if (count > 0) {
				System.out.println("" + "");
				buyProduct4.getBuyProduct();
			} else {
				OnlineShop.getUserStoryDetails1();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
