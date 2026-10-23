package com.java.fde.encapsulation.statements.examples.seven;

public class MainCustomer {

	public static void main(String[] args) {

		CustomerServices services = new CustomerServices();

		try {

			long id = services.readCustomerId();
			String name = services.readCustomerName();
			String email = services.readCustomerEmail();

			Customer customer = new Customer(id, name, email);
			System.out.println("\nNew Guest Customer Account Created Successfull");

			boolean running = true;

			while (running) {
				try {

					int choice = services.readMenuChoice();

					if (choice == 1) {

						double amount = services.readRechargeAmount();

						if (customer.rechargeWallet(amount)) {
						    System.out.printf("Wallet recharged: ₹%.2f | Wallet balance: ₹%.2f%n",
						            amount, customer.getWalletBalance());
						} else {
						    System.out.println("Recharge failed. Amount must be greater than 0.");
						}
					} else if (choice == 2) {
						double amount = services.readPaymentAmount();

						if (customer.makePayment(amount)) {
						    System.out.printf("Payment successful: ₹%.2f | Wallet balance: ₹%.2f%n",
						            amount, customer.getWalletBalance());
						} else {
						    System.out.printf("Payment failed. Amount must be greater than 0 and not more than wallet balance (₹%.2f)%n",
						            customer.getWalletBalance());
						}
					} else if (choice == 3) {
						System.out.println("\n***** Customer Profile *****");
						System.out.println("Customer Id    :- " + customer.getCustomerId());
						System.out.println("Name           :- " + customer.getCustomerName());
						System.out.println("Email          :- " + customer.getCustomerEmail());
						System.out.printf("Wallet Balance :- ₹%.2f%n " , customer.getWalletBalance());

					} else if (choice == 4) {
						System.out.println("Thank you for shopping with us. Visit again!");
						running = false;

					} else {
						System.out.println("Invalid option. Choose 1, 2, 3 or 4.");
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter numbers only.");
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid input: " + e.getMessage());

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid data: " + e.getMessage());

		} finally {
			services.close();

		}
	}
}
