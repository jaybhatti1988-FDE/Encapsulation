package com.java.fde.encapsulation.staments.examples.two;

import java.util.InputMismatchException;
import java.util.Scanner;
public class ATMMain {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		ATMServices service=new ATMServices();
		ATM atm=null; 
		
        try {
        	
        	System.out.print("Entered Card Number : ");
        	long cardNo=Long.parseLong(sc.nextLine().trim());
        	
        	System.out.print("Set Pin 		    : ");
        	long pin=Long.parseLong(sc.nextLine().trim());
        	
        	System.out.print("Opening Balance     : ");
        	double balance=Double.parseDouble(sc.nextLine().trim());

        	atm=new ATM(cardNo, pin, balance);
        	System.out.println("\n Account Created Successfully");
        	
        }catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter numbers only.");
			sc.close();
			return;
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			sc.close();
			return;
		}
        
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     Finance Bank ATM Service             ║");
        System.out.println("╚══════════════════════════════════════════╝");
        
        int choice=0;
        do {
        	System.out.println("\n===== ATM MENU =====");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Change PIN");
			System.out.println("4. Account Details");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");
			
			try {
				
				choice = Integer.parseInt(sc.nextLine().trim());
				
				switch (choice) {
				case 1:
					System.out.println("Enter Amount : ");
					double wAmt=Double.parseDouble(sc.nextLine().trim());
					System.out.println("Enter Pin : ");
					long wPin=Long.parseLong(sc.nextLine().trim());
					service.withdraw(atm, wAmt, wPin);
					break;
					
				case 2:
					System.out.println("Enter Amount : ");
					double dAmt=Double.parseDouble(sc.nextLine().trim());
					service.Deposit(atm, dAmt);
					break;	
				case 3:
					System.out.println("Enter Old Pin : ");
					long oldPin=Long.parseLong(sc.nextLine().trim());
					System.out.println("Enter New Pin : ");
					long newPin=Long.parseLong(sc.nextLine().trim());
					service.changePin(atm, oldPin, newPin);
					break;	
				case 4:
					service.displayATMDetails(atm);
					break;	
				case 5:
					System.out.println("Thank you for Using Finance Bank ATM Service...Visit Again");
					break;

				default:
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter numbers only.");
				sc.nextLine();
				choice=0;
			}
			
		} while (choice!=5);
        sc.close();
	}
}
