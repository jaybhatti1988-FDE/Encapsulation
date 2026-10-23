package com.java.fde.encapsulation.statements.examples.seven;

import java.util.Scanner;

public class CustomerServices {
	
	Scanner sc=new Scanner(System.in);
	
	public long readCustomerId() {
		System.out.print("Enter Customer ID : ");
		return Long.parseLong(sc.nextLine());
	}

	public String readCustomerName() {
		System.out.print("Enter Customer Name : ");
		return sc.nextLine();
	}

	public String readCustomerEmail() {
		System.out.print("Enter Customer Email : ");
		return sc.nextLine();
	}

	public double readRechargeAmount() {
		System.out.print("Enter Amount to Recharge : ");
		return Double.parseDouble(sc.nextLine());
	}
	
	public double readPaymentAmount() {
		System.out.print("Enter Amount to Pay: ");
		return Double.parseDouble(sc.nextLine());
	}
	
	public int readMenuChoice() {
		System.out.println("\n1. Recharge Wallet");
		System.out.println("2. Make Payment");
		System.out.println("3. View Profile");
		System.out.println("4. Exit");
		System.out.print("Choose option : ");
		return Integer.parseInt(sc.nextLine().trim());
	}
	
	public void close() {
		sc.close();
	}

}
