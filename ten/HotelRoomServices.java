package com.java.fde.encapsulation.statements.examples.ten;

import java.util.Scanner;

public class HotelRoomServices {

	Scanner sc = new Scanner(System.in);

	public String readRoomNumber() {
		System.out.print(" Enter Room Number : ");
		return sc.nextLine();

	}

	public String readRoomType() {
		System.out.print(" Enter Room Type (LUXURY/SUITE/PREMIUM/COMMON) : ");
		return sc.nextLine();
	}

	public double readPricePerNight() {
		System.out.print(" Enter Room Price Per Night : ");
		return Double.parseDouble(sc.nextLine().trim());
	}

	public int readMenuChoice() {
		System.out.println("\n1. Book Room");
		System.out.println("2. Release Room (Check-out)");
		System.out.println("3. Update Price");
		System.out.println("4. View Room");
		System.out.println("5. Exit");
		System.out.print("Choose option : ");
		return Integer.parseInt(sc.nextLine().trim());
	}

	public void close() {
		sc.close();
	}

}
