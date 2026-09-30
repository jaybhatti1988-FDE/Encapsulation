package com.java.fde.encapsulation.staments.examples.one;

import java.util.Scanner;
public class BankAccountEncapsulationDemo {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     BANK ACCOUNT ENCAPSULATION DEMO      ║");
        System.out.println("╚══════════════════════════════════════════╝");
		
        BankAccountServices bankservice=new BankAccountServices(sc);
        
        BankAccount accnt=bankservice.createAccount();
        accnt.DisplayDetails();
        
        bankservice.runMenu(accnt);
        sc.close();

	}

}
