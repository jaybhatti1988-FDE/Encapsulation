package com.java.fde.encapsulation.statements.examples.five;

public class CreditCardLimitMain {

	public static void main(String[] args) {

		CreditCardInput input = new CreditCardInput();

		try {
			long crdNo = input.readCardNumber();
			double limit = input.readCreditLimit();

			CreditCard card = new CreditCard(crdNo, limit);
			System.out.println("\nNew Virtual Card Created Successfully");

			boolean running = true;

			while (running) {
				try {

					int choice = input.readMenuChoice();

					if (choice == 1) {
						double amt = input.readSpendAmount();
						if (card.spend(amt)) {
							System.out.printf("Payment Successfull Spent : ₹%.2f%n",  amt);
						} else {
							System.out.println("Payment declined. Amount is invalid or exceeds available credit ("
									+ card.getAvailableCredit() + ")");
						}
					} else if (choice == 2) {
						System.out.println("\n***** Card Details *****");
						System.out.println("Card Number      :- " + card.getCardNumber());
						System.out.printf("Credit Limit     :- ₹%.2f%n",  card.getCreditLimit());
						System.out.printf("Current Usage    :- ₹%.2f%n", card.getCurrentUsage());
						System.out.printf("Available Credit :- ₹%.2f%n", card.getAvailableCredit());
					} else if (choice == 3) {
						System.out.println("Thank you... Good Bye");
						running = false;
					} else {
						System.out.println("Invalid Inputs Please enter 1,2 or 3");
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid inputs Please Enter Numeric values only");
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid Inputs...!" + e.getMessage());

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Inputs...!" + e.getMessage());
		} finally {
			input.close();
		}
	}
}