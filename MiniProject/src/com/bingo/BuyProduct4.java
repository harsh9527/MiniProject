package com.bingo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class BuyProduct4 extends Login2 {

	
	String username=super.uname;
	int price=0;
	public static int pid;
	public static int pquantity;
	
	public void getBuyProduct()throws SQLException {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product-Id to Buy Product");
		pid=scanner.nextInt();
		System.out.println("Enter Product Quantity");
		pquantity=scanner.nextInt();
		
		try {
			
				
			ConnectionTest connectionTest=new ConnectionTest();
			connection=connectionTest.getConnection();
			
				preparedStatement=connection.prepareStatement("select prod_price from products where prod_id=?");
				preparedStatement.setInt(1, pid);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					price=resultSet.getInt("prod_price");
					price=price*pquantity;
				}
					preparedStatement=connection.prepareStatement("insert into cart(username,productId,quantity,price)values(?,?,?,?)");
					preparedStatement.setString(1,username);
					preparedStatement.setInt(2,pid);
					preparedStatement.setInt(3,pquantity);
					preparedStatement.setInt(4,price);
					preparedStatement.executeQuery();
				
					System.out.println("Do you want to view Cart Yes/No");
					String result=scanner.next();
					if(result.equals("Yes")) {
						ViewCart5 viewCart5=new ViewCart5();
						viewCart5.getViewcart();
					}
					else if(result.equals("No")){
						OnlineShop onlineShop=new OnlineShop();
						onlineShop.getUserStoryDetails1();
					}
					else {
						System.out.println("Invalid Input");
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
