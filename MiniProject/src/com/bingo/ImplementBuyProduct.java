package com.bingo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImplementBuyProduct {

	public static void buyProduct() {
		// Buy Product

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

			System.out.print("Enter the product id to buy product: ");
			int productId = scanner.nextInt();
			System.out.print("Enter the quantity: ");
			int quantity = scanner.nextInt();
			rs = prs.executeQuery("SELECT * FROM products WHERE prod_id = " + productId);
			 boolean exit = false;
		        while (!exit) {
			if (rs.next()) {
				String productName = rs.getString("prod_name");
				double productPrice = rs.getDouble("prod_price");
				int productQuantity = rs.getInt("prod_quantity");
				if (productQuantity >= quantity) {
					Product product = new Product(productId, productName, "", productPrice, quantity);
					cart.addItem(product);
					System.out.println("Do you want to view cart (Yes/No)");
					String yesorno=scanner.next();
					exit = yesorno.equalsIgnoreCase("Yes");
				
				} else {
					System.out.println("Insufficient product quantity.");
				}
			} else {
				System.out.println("Product not found.");
			}
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		buyProduct();
	}
}