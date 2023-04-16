package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PurchaseItem6 extends BuyProduct4 {

	public void getPurchaseItem() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int productid = super.pid;
		int quantity = super.pquantity;
		int bill = 0;
		System.out.println("Do you want to purchase Item? Yes/No");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next();
		if (answer.equals("Yes")) {
			try {

				ConnectionTest connectionTest=new ConnectionTest();
				connection=connectionTest.getConnection();
				
				
				preparedStatement = connection.prepareStatement("select * from cart where productId=?");
				preparedStatement.setInt(1, productid);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					System.out.println("Username=" + resultSet.getString("username"));
					System.out.println("Product Id=" + resultSet.getInt("productId"));
					System.out.println("Price=" + resultSet.getString("price"));
					bill = bill + resultSet.getInt("price");
				}
				System.out.println("Total Bill=" + bill);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			}
		}
	}
}
