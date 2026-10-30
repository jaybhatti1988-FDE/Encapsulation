package com.java.fde.encapsulation.statements.examples.nine;

import java.util.Scanner;

public class TrainTicketServices {

	Scanner sc = new Scanner(System.in);

	public String readTicketId() {
		System.out.print("Enter Ticket Id : ");
		return sc.nextLine();
	}

	public String readPassengerName() {
		System.out.print("Enter Passenger Name : ");
		return sc.nextLine();
	}

	public int readSeatNumber() {
		System.out.print("Enter Seat Number : ");
		return Integer.parseInt(sc.nextLine().trim());
	}

	public int readMenuChoice() {
		System.out.println("\n1. Book Ticket");
		System.out.println("2. Cancel Ticket");
		System.out.println("3. View Ticket");
		System.out.println("4. Exit");
		System.out.print("Choose option : ");
		return Integer.parseInt(sc.nextLine().trim());
	}

	public void close() {
		sc.close();
	}

}
