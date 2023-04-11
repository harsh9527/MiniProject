package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Case3 {

	public static void viewProductsSorted() throws SQLException {
		// Implement view product logic
	

		Connection con = null;
		PreparedStatement prs = null;
		ResultSet rs=null;
		try {
			// step 1 -loading the driver class
			ConnectionTest connectionTest = new ConnectionTest();
			con = connectionTest.getConnection();
			prs = con.prepareStatement("SELECT * FROM products order by prod_price asc");
			// step 3 - create statement or prepared sql statement
			rs = prs.executeQuery();
			// step 4 submit the sql statement

					// View Products
					
					
					while (rs.next()) {
						int productId = rs.getInt("prod_id");
						String productName = rs.getString("prod_name");
						String productDescription=rs.getString("prod_description");
						double productPrice = rs.getDouble("prod_price");
						int productQuantity = rs.getInt("prod_quantity");
						System.out.println("Product Id>>"+productId);
						System.out.println("Product Name>>"+productName);
						System.out.println("Product Description>>"+productDescription);
						System.out.println("Price>>"+productPrice);
						System.out.println("Available Quantity>>"+productQuantity);
						System.out.println("\t");
			}

		} catch (Exception e) {
			e.printStackTrace();
			

		} finally {
			con.close();
			prs.close();
			rs.close();
			
			
		}
	
	}
	public static void main(String[] args) throws SQLException {
		 Case3.viewProductsSorted();
	}
}
/*Product Id>> 101
Product Name>> Apple MacBook 2020
Product Description>> 8 GB RAM, 256 SSD
Available Quantity>>5
Price>> 85000
*/