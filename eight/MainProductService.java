package com.java.fde.encapsulation.statements.examples.eight;

public class MainProductService {

	public static void main(String[] args) {

		ProductService services = new ProductService();

		try {

			String id = services.readProductId();
			String name = services.readProductName();
			double price = services.readProductPrice();
			int stock = services.readProductStockQuantity();

			Product product = new Product(id, name, price, stock);
			System.out.println(" \n Product Created Successfully. ");

			boolean running = true;

			while (running) {
				try {

					int choice = services.readMenuChoice();

					if (choice == 1) {
						String password = services.readAdminPassword();
						double newPrice = services.readnewPrice();

						if (product.updatePrice(newPrice, password)) {
							System.out.printf("Price pdated. new Prices :   ₹%.2f%n", product.getPrice());
						} else {
							System.out.println("Update Failed. You Entered Wrong Password");
						}

					} else if (choice == 2) {
						int qty = services.readQuantity();
						if (product.addStock(qty)) {
							System.out.println("Stock Added Current Stock : " + product.getStockQuantity());
						} else {
							System.out.println("Failed Quantity must be greater than 0");
						}
					} else if (choice == 3) {
						int qty = services.readQuantity();
						if (product.addStock(qty)) {
							System.out.println("Stock Reduced Current Stock : " + product.getStockQuantity());
						} else {
							System.out.println("Failed. Quantity must be greater than 0 and not more than stock ("
									+ product.getStockQuantity() + ")");
						}
					} else if (choice == 4) {
						System.out.println("\n***** Product Details *****");
						System.out.println("Product Id    :- " + product.getProductId());
						System.out.println("Product Name  :- " + product.getProductName());
						System.out.printf("Price         :- ₹%.2f%n", product.getPrice());
						System.out.println("Stock         :- " + product.getStockQuantity());
					} else if (choice == 5) {
						System.out.println("Thank you. Goodbye!");
						running = false;

					} else {
						System.out.println("Invalid option. Choose 1 to 5.");
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid input Enter Numbers Only");
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid input" + e.getMessage());
		}

		catch (IllegalArgumentException e) {
			System.out.println("Invalid data" + e.getMessage());

		}

		finally {
			services.close();
		}

	}

}
