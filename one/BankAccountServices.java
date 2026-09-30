package com.java.fde.encapsulation.staments.examples.one;

import java.util.Scanner;

class BankAccountServices {

	private Scanner sc;

	public BankAccountServices(Scanner sc) {
		this.sc = sc;
	}

	public BankAccount createAccount() {

		System.out.print("Enter Account Number :- ");
		String acno = sc.nextLine();

		System.out.print("Enter Account Holder Name :- ");
		String acname = sc.nextLine();

		System.out.print("Enter Amount for Balancing (₹)  :-");
		while (!sc.hasNextDouble()) {
			System.out.println("Invalid Number. Enter Amount for Balancing (₹) Again :- ");
		}
		double acbal = sc.nextDouble();
		sc.nextLine(); // flushing new Line

		return new BankAccount(acno, acname, acbal);

	}

	public void runMenu(BankAccount account) {

		boolean cotinueApp = true;

		while (cotinueApp) {
			System.out.println("\n========= ACCOUNT MENU =========");
			System.out.println(" 1. Deposit");
			System.out.println(" 2. Withdraw");
			System.out.println(" 3. Display Account Details");
			System.out.println(" 4. Exit");
			System.out.println("=================================");
			System.out.print("Enter Your Choice :- ");

			while (!sc.hasNextInt()) {
				System.out.print("❌ Invalid Number. Enter Choice Again :- ");
				sc.next();
			}
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Deposit Amount (₹)  :- ");
				while (!sc.hasNextDouble()) {
					System.out.print("Invalid Number. Enter Amount Again :- ");
					sc.next();
				}
				double depositAmt = sc.nextDouble();
				sc.nextLine();
				account.Deposit(depositAmt);
				break;

			case 2:
				System.out.print("Enter WithDrawl Amount (₹)  :- ");
				while (!sc.hasNextDouble()) {
					System.out.print("Invalid Number. Enter Amount Again :- ");
					sc.next();
				}
				double withdrawAmt = sc.nextDouble();
				sc.nextLine();
				account.WithDraw(withdrawAmt);
				break;

			case 3:
				account.DisplayDetails();
				break;

			case 4:
				cotinueApp = false;
				System.out.println("Thank you for Banking With Us...!");
				break;

			default:
				break;
			}
		}
	}

}
