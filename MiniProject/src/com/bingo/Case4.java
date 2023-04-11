-package com.bingo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Case4 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement prs = null;
		ResultSet rs = null;
		ArrayList<Product> products = new ArrayList<Product>();
		Cart cart = new Cart();

		try {
			// Establish database connection
			ConnectionTest connectionTest = new ConnectionTest();
			conn = connectionTest.getConnection();
			prs = conn.prepareStatement("SELECT * FROM products");

			System.out.println("Enter your choice:");
			System.out.println("1. View Products");
			System.out.println("2. Buy Product");
			System.out.println("3. View Cart");
			System.out.println("4. Exit");

			boolean exit = false;
			while (!exit) {
				System.out.print("Enter your choice-4: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					// View Products
					rs = prs.executeQuery();
					System.out.println("Product ID\tProduct Name\tProduct Price\tProduct Quantity");
					while (rs.next()) {
						int productId = rs.getInt("prod_id");
						String productName = rs.getString("prod_name");
						double productPrice = rs.getDouble("prod_price");
						int productQuantity = rs.getInt("prod_quantity");
						System.out.println(
								productId + "\t\t" + productName + "\t\tRS" + productPrice + "\t\t" + productQuantity);
					}
					break;
				case 2:
					// Buy Product
					System.out.print("Enter the product id to buy product: ");
					int productId = scanner.nextInt();
					System.out.print("Enter the quantity: ");
					int quantity = scanner.nextInt();
					rs = prs.executeQuery("SELECT * FROM products WHERE prod_id = " + productId);
					if (rs.next()) {
						String productName = rs.getString("prod_name");
						double productPrice = rs.getDouble("prod_price");
						int productQuantity = rs.getInt("prod_quantity");
						if (productQuantity >= quantity) {
							Product product = new Product(productId, productName, "", productPrice, quantity);
							cart.addItem(product);
							System.out.println("Product added to cart successfully.");
						} else {
							System.out.println("Insufficient product quantity.");
						}
					} else {
						System.out.println("Product not found.");
					}
					break;
				case 3:
					// View Cart
					cart.displayCart();
					System.out.println("Total Price:" + cart.getTotalPrice());
					break;
				case 4:
					// Exit
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (prs != null) {
					prs.close();
				}
				if (conn != null) {
					conn.close();
				}
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}