package com.bingo;

class Product {
	
	private int productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	private int productQuantity;

	public Product(int productId, String productName, String productDescription, double productPrice,
			int productQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
}
