package com.bingo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewCart5 extends BuyProduct4 {

	public void getViewcart() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PurchaseItem6 purchaseItem6 = new PurchaseItem6();

		Scanner scanner = new Scanner(System.in);
		int productid = super.pid;
		int quantity = super.pquantity;
		String uname = super.username;
		
		try {
			
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
			preparedStatement = connection.prepareStatement("select * from cart where productId=? and quantity=?");
			preparedStatement.setInt(1, productid);
			preparedStatement.setInt(2, quantity);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("Username=" + resultSet.getString(1));
				System.out.println("Product Id=" + resultSet.getInt(2));
				System.out.println("Quantity=" + resultSet.getInt(3));
				System.out.println("Price=" + resultSet.getString(4));
			}
			purchaseItem6.getPurchaseItem();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
