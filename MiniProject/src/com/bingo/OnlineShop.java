package com.bingo;


import java.sql.SQLException;
import java.util.Scanner;

public class OnlineShop {
    
     

    public static void main(String[] args) throws SQLException {
      
            System.out.println("User Operation");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. User view Product item as Sorted Order");
            System.out.println("4. Buy Product");
            System.out.println("5. View Cart");
            System.out.println("6. Purchase the item");
            System.out.println("Admin Operation");
            System.out.println("7. Add product item");
            System.out.println("8. Calculate Bill");
            System.out.println("9. Display amount to End User");
            System.out.println("10. Check Quantity");
            System.out.println("11. Check registered user");
            System.out.println("12. Check the particular user history");
            System.out.println("Guest Operation");
            System.out.println("13. View product item");
            System.out.println("14. Not purchase item");
            System.out.println("Enter your choice:");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // check  newline character

            switch (choice) {
                case 1:
                    // User Registration
                    registerUser();
                    break;
                case 2:
                    // User Login
                    loginUser();
                    break;
                case 3:
                    // User view Product item as Sorted Order
                    viewProductsSorted();
                    break;
                case 4:
                    // Buy Product
                    buyProduct();
                    break;
                case 5:
                    // View Cart
                    viewCart();
                    break;
                case 6:
                    // Purchase the item
                    purchaseItem();
                    break;
                case 7:
                    // Add product item
                    addProduct();
                    break;
                case 8:
                    // Calculate Bill
                    calculateBill();
                    break;
                case 9:
                    // Display amount to End User
                    displayAmountToUser();
                    break;
                case 10:
                    // Check Quantity
                    checkQuantity();
                    break;
                case 11:
                    // Check registered user
                    checkRegisteredUser();
                    break;
                case 12:
                    // Check the particular user history
                    checkUserHistory();
                    break;
                case 13:
                    // View product item
                    viewProduct();
                    break;
                case 14:
                    // Not purchase item
                    notPurchaseItem();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
    }
            

    // Method to register a new user
    private static void registerUser() {
        //  Implement user registration logic
        System.out.println("User registration not implemented yet.");
    }

    // Method to login a user
    private static void loginUser() {
        //  Implement user login logic
        System.out.println("User login not implemented yet.");
    }

    // Method to view products as sorted order
    private static void viewProductsSorted() {
        //  Implement product view logic
        System.out.println("Product view as sorted order not implemented yet.");
    }

    // Method to buy a product
    private static void buyProduct() {
    	// Method to view the cart
    }
    	private static void viewCart() {
    	    // Implement view cart logic
    	    System.out.println("View cart not implemented yet.");
    	}

    	// Method to purchase an item
    	private static void purchaseItem() {
    	    // Implement purchase item logic
    	    System.out.println("Purchase item not implemented yet.");
    	}

    	// Method to add a product
    	private static void addProduct() {
    	    //  Implement add product logic
    	    System.out.println("Add product not implemented yet.");
    	}

    	// Method to calculate bill
    	private static void calculateBill() {
    	    //  Implement calculate bill logic
    	    System.out.println("Calculate bill not implemented yet.");
    	}

    	// Method to display amount to end user
    	private static void displayAmountToUser() {
    	    //  Implement display amount to end user logic
    	    System.out.println("Display amount to end user not implemented yet.");
    	}

    	// Method to check quantity
    	private static void checkQuantity() {
    	    // Implement check quantity logic
    	    System.out.println("Check quantity not implemented yet.");
    	}

    	// Method to check registered user
    	private static void checkRegisteredUser() {
    	    //  Implement check registered user logic
    	    System.out.println("Check registered user not implemented yet.");
    	}

    	// Method to check user history
    	private static void checkUserHistory() {
    	    //  Implement check user history logic
    	    System.out.println("Check user history not implemented yet.");
    	}

    	// Method to view a product
    	private static void viewProduct() {
    	    //  Implement view product logic
    	    System.out.println("View product not implemented yet.");
    	}

    	// Method to not purchase an item
    	private static void notPurchaseItem() {
    	    //  Implement not purchase item logic
    	    System.out.println("Not purchase item not implemented yet.");
    	}
}
        //

