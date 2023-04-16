package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminAddProduct7 {

	public void addProduct() throws SQLException {
	    //  Implement add product logic
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			ConnectionTest connectionTest=new ConnectionTest();
			connection = connectionTest.getConnection();
			
			Scanner scanner=new Scanner(System.in);
				System.out.println("Enter Product Name");
				String pname=scanner.next();
				System.out.println("Enter Description");
				String des=scanner.next();
				System.out.println("Enter Quantity");
				int quantity=scanner.nextInt();
				System.out.println("Enter Price");
				int price=scanner.nextInt();
	
				preparedStatement=connection.prepareStatement("insert into products(prod_name,prod_description,prod_quantity,prod_price)values(?,?,?,?)");
				preparedStatement.setString(1,pname);
				preparedStatement.setString(2,des);
				preparedStatement.setInt(3,quantity);
				preparedStatement.setInt(4,price);
				preparedStatement.executeUpdate();
				
				System.out.println("Product Successfully Added>>>");
	}catch(Exception e){
		System.out.println(e);
	}finally {
		connection.close();
		preparedStatement.close();
	}
	
	
	
	
	
	
	}
	
}
