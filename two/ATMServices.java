package com.java.fde.encapsulation.staments.examples.two;

class ATMServices {
	public void withdraw(ATM atm, double amount, long entredPin) {
		if (!atm.validatePin(entredPin)) {
			System.out.println("Invalid Pin");
		} else if (amount <= 0) {
			System.out.println("Amount should not be 0 or negative");
		} else if (amount > atm.getBalance()) {
			System.out.println("Insufficient Balance");
			displayBalance(atm);
		} else {
			atm.WithDrawl(amount);
			System.out.println("Transaction Successfull");
			System.out.printf("Amount Debited in Account Successfully & Deduct Amount is ₹%.2f%n", amount);
		}
	}

	public void Deposit(ATM atm, double amount) {
		if (atm.credit(amount)) {
			System.out.printf("Amount Credited in Account Successfully & Credited Amount is ₹%.2f%n", amount);
			displayBalance(atm);
		} else {
			System.out.println("Invalid Amount...! you enter zero or negative value");
		}
	}

	public void changePin(ATM atm, long oldPin, long newPin) {
		if (atm.changePin(oldPin, newPin)) {
			System.out.println("Pin Change Successfully");
		} else {
			System.out.println("Invalid Pin");
		}
	}

	public void displayBalance(ATM atm) {
		System.out.printf("Update Balance is : ₹%.2f%n", atm.getBalance());
	}

	public void displayATMDetails(ATM atm) {
		System.out.println("\n------------------------------------------");
		System.out.println("           ACCOUNT DETAILS                ");
		System.out.println("------------------------------------------");
		System.out.println("Card Number : " + atm.getCrdNumbr());
		System.out.printf("Balance     : ₹%.2f%n", atm.getBalance());
		System.out.println("------------------------------------------");
	}
}
