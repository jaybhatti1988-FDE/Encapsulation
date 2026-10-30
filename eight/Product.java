package com.java.fde.encapsulation.statements.examples.eight;

public class Product {

	private static final String ADMIN_PASSWORD = "admin123";

	private final String productId, productName;
	private double price;
	private int stockQuantity;

	public Product(String productId, String productName, double price, int stockQuantity) {
		if (productId == null || productId.trim().isEmpty()) {
			throw new IllegalArgumentException("product Id should not be blank or null");
		}

		if (productName == null || productName.trim().isEmpty()) {
			throw new IllegalArgumentException("product Name should not be blank or null");
		}

		if (price <= 0) {
			throw new IllegalArgumentException("Price value should be more than 0");
		}

		if (stockQuantity <= 0) {
			throw new IllegalArgumentException("Stock Quantity value should be more than 0");
		}

		this.productId = productId.trim();
		this.productName = productName.trim();
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public boolean updatePrice(double newPrice, String adminPassword) {
		if (adminPassword == null || !adminPassword.equals(ADMIN_PASSWORD)) {
			return false;
		}
		if (newPrice <= 0) {
			return false;
		}
		this.price = newPrice;
		return true;
	}

	public boolean addStock(int quantity) {

		if (quantity <= 0) {
			return false;
		}
		stockQuantity += quantity;
		return true;
	}

	public boolean reduceStock(int quantity) {
		if (quantity <= 0) {
			return false;
		}
		if (quantity > stockQuantity) {
			return false;
		}
		stockQuantity -= quantity;
		return true;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

}
