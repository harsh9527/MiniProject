package com.bingo;

import java.sql.SQLException;
import java.util.Scanner;

public class OnlineShop {

	

	public static void getUserStoryDetails1() throws SQLException {
		
        System.out.println("Welcome to E-Commerce based application");
        
        System.out.println("\t");        
		System.out.println("User Operation");
		System.out.println("\t");

		System.out.println("1. User Registration");
		System.out.println("2. User Login");
		System.out.println("3. User view Product item as Sorted Order");
		System.out.println("4. Buy Product");
		System.out.println("5. View Cart");
		System.out.println("6. Purchase the item");
		
		System.out.println("\t");
		System.out.println("Admin Operation");
		System.out.println("\t");
		
		System.out.println("7. Add product item");
		System.out.println("8. Calculate Bill");
		System.out.println("9. Display amount to End User");
		System.out.println("10. Check Quantity");
		System.out.println("11. Check registered user");
		System.out.println("12. Check the particular user history");
		
		System.out.println("\t");
		System.out.println("Guest Operation");
		System.out.println("\t");

		System.out.println("13. View product item");
		System.out.println("14. Not purchase item");
		
		System.out.println("\t");
		
		System.out.println("Enter your choice:");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.nextLine(); // check newline character
		

		switch (choice) {
		case 1:
			// User Registration
			Registration1 registration1=new Registration1();
			registration1.registerUser();
			
			break;
		case 2:
			// User Login
			Login2 login2 = new Login2();
			login2.getLogin();
			
			break;
		case 3:
			// User view Product item as Sorted Order
			ProductDisplay3 productDisplay =new ProductDisplay3();
			productDisplay.getProductList();
			
			break;
		case 4:
			// Buy Product
			BuyProduct4 buyProduct4 =new BuyProduct4();
			buyProduct4.getBuyProduct();
			
			break;
		case 5:
			// View Cart
			ViewCart5 viewCart5=new ViewCart5();
			viewCart5.getViewcart();
			break;
		case 6:
			// Purchase the item
			PurchaseItem6 purchaseItem6=new PurchaseItem6();
			purchaseItem6.getPurchaseItem();
			
			
			break;
		case 7:
			// Add product item
			AdminAddProduct7 adminAddProduct7=new AdminAddProduct7();
			adminAddProduct7.addProduct();
			
			break;
		case 8:
			// Calculate Bill
			CalculateBill8 calculateBill8=new CalculateBill8();
			calculateBill8.calculateBill();
			
			break;
		case 9:
			// Display amount to End User
			DisplayAmount9 displayAmount9=new DisplayAmount9();
			displayAmount9.displayAmountToUser();
			
			
			break;
		case 10:
			// Check Quantity
			CheckQuantity10 checkQuantity10 =new CheckQuantity10();
			checkQuantity10.checkQuantity();
			
			
			
			break;
		case 11:
			// Check registered user
			CheckRegisteredUser11 checkRegisteredUser11 =new CheckRegisteredUser11();
			checkRegisteredUser11.checkRegisteredUser();
			
			
			break;
		case 12:
			// Check the particular user history
			ParticularHistory12 particularHistory12=new ParticularHistory12();
			particularHistory12.checkUserHistory();
			
			
			
			break;
		case 13:
			// View product item
			ViewProductGuest13 viewProductGuest13=new ViewProductGuest13();
			viewProductGuest13.getProductListGuest();
			
			
			break;
		case 14:
			// Not purchase item
			System.out.println("To buy any product you have to login first>> ");
			Login2 login=new Login2();
			login.getLogin();
			break;

		default:
			System.out.println("Invalid choice. Please try again.");
			break;
			
		   }
			
    }
	
}
