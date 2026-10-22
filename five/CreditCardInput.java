package com.java.fde.encapsulation.statements.examples.five;

import java.util.Scanner;
public class CreditCardInput {
	
	private Scanner sc=new Scanner(System.in);
	
	public long readCardNumber() {
		System.out.print("Enter Card Number : ");
		return Long.parseLong(sc.nextLine().trim());
	}
	
	public double readCreditLimit() {
		System.out.print("Enter Credit Limit : ");
		return Double.parseDouble(sc.nextLine().trim());
	}
	
	public double readSpendAmount() {
		System.out.print("Enter Amount to Spend : ");
		return Double.parseDouble(sc.nextLine().trim());
	}
	
	public int readMenuChoice() {
		System.out.println("\n1. Spend");
		System.out.println("2. View Available Credit");
		System.out.println("3. Exit");
		System.out.print("Choose option : ");
		return Integer.parseInt(sc.nextLine().trim());
	}
	
	public void close() {
		sc.close();
	}

}
