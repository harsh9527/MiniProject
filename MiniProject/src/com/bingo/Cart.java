package com.bingo;

import java.util.ArrayList;

class Cart {
    private ArrayList<Product> items = new ArrayList<Product>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Items:");
            for (Product product : items) {
                System.out.println("Product ID: " + product.getProductId() +
                        ", Product Name: " + product.getProductName() +
                        ", Product Price:" + product.getProductPrice());
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getProductPrice();
        }
        return totalPrice;
    }
}