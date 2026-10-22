package com.java.fde.encapsulation.statements.examples.three;

import java.util.Scanner;

public class InsuranceMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		InsurancePolicyServices service = new InsurancePolicyServices();
		InsurancePolicy policy = null;

		try {

			System.out.print("Enter Policy : ");
			long id = Long.parseLong(sc.nextLine().trim());

			System.out.print("Enter Policy Holder Name : ");
			String name = sc.nextLine();

			System.out.print("Enter Premium Amount : ");
			Double amount = Double.parseDouble(sc.nextLine().trim());

			System.out.print("Enter Status (Active/Lapsed/Suspended/Cancelled): ");
			String status = sc.nextLine();

			policy = new InsurancePolicy(id, name, amount, status);
			System.out.println("\nPolicy Created Successfully");

		} catch (NumberFormatException e) {
			System.out.println("Invalid Inputs...! Please enter valid Numbers");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			sc.close();
			return;
		}
		int choice = 0;
		do {
			System.out.println("\n===== POLICY MENU =====");
			System.out.println("1. Update Premium");
			System.out.println("2. Change Policy Status");
			System.out.println("3. Policy Details");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			try {
				choice = Integer.parseInt(sc.nextLine().trim());

				switch (choice) {
				case 1:
					System.out.print("Enter New Premium : ");
					double uPremium = Double.parseDouble(sc.nextLine().trim());
					service.updatePremium(policy, uPremium);
					break;
				case 2:
					System.out.print("Enter New Status : ");
					String uStatus = sc.nextLine();
					service.changeStatus(policy, uStatus);
					break;
				case 3:
					service.displayPolicyDetails(policy);
					break;
				case 4:
					System.out.println("Thank you for Using SunFlower Insurance Service...Visit Again");
					break;

				default:
					System.out.println("Invalid choice. Try again.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid Inputs...! Please enter valid Numbers");
				choice = 0;
			}
		} while (choice != 4);
		sc.close();
	}
}