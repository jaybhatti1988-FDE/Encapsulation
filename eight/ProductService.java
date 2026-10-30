package com.java.fde.encapsulation.statements.examples.eight;

import java.util.Scanner;
public class ProductService {
	
	private Scanner sc=new Scanner(System.in);
	
	public String readProductId() {
		System.out.print("Enter Product Id : ");
		return sc.nextLine();
	}
	
	public String readProductName() {
		System.out.print("Enter Product Name : ");
		return sc.nextLine();
	}
	
	public Double readProductPrice() {
		System.out.print("Enter Product Price : ");
		return Double.parseDouble(sc.nextLine().trim());
	}
	
	public int readProductStockQuantity() {
		System.out.print("Enter Product Stock : ");
		return Integer.parseInt(sc.nextLine().trim());
	}
	
	public String readAdminPassword() {
		System.out.print("Enter Admin Password : ");
		return sc.nextLine();
	}
	
	public Double readnewPrice() {
		System.out.print("Enter New Price : ");
		return Double.parseDouble(sc.nextLine().trim());
	}
	
	public int readQuantity() {
		System.out.print("Enter Quantity : ");
		return Integer.parseInt(sc.nextLine().trim());
	}
	
	public int readMenuChoice() {
		System.out.println("\n1. Update Price (Admin only)");
		System.out.println("2. Add Stock");
		System.out.println("3. Reduce Stock (Sell)");
		System.out.println("4. View Product");
		System.out.println("5. Exit");
		System.out.print("Choose option : ");
		return Integer.parseInt(sc.nextLine().trim());
	}
	
	public void close() {
		sc.close();
	}


}
