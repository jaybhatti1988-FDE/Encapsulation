package com.java.fde.encapsulation.statements.examples.six;

import java.util.*;
public class LoanAccountServices {

	private Scanner input=new Scanner(System.in);
	
	public long readLoanId() {
		System.out.print("Enter Loan Id : ");
		return Long.parseLong(input.nextLine());
	}

	public double readLoanAmount() {
		System.out.print("Enter Loan Amount : ");
		return Double.parseDouble(input.nextLine());
	}

	public double readInterestRate() {
		System.out.print("Enter Interest Rate : ");
		return Double.parseDouble(input.nextLine());
	}

	public double readEMIAmount() {
		System.out.print("Enter You want to Pay EMI Amount : ");
		return Double.parseDouble(input.nextLine());
	}
	
	public int readMenuChoice() {
		System.out.println("\n1. Pay EMI");
		System.out.println("2. View Loan Details");
		System.out.println("3. Exit");
		System.out.print("Choose option : ");
		return Integer.parseInt(input.nextLine());
	}
	
	public void close() {
		input.close();
	}
}
