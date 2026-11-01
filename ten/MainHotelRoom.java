package com.java.fde.encapsulation.statements.examples.ten;

public class MainHotelRoom {

	public static void main(String[] args) {
		HotelRoomServices services = new HotelRoomServices();

		try {

			String roomNo = services.readRoomNumber();
			String type = services.readRoomType();
			double price = services.readPricePerNight();

			HotelRoom room = new HotelRoom(roomNo, type, price);

			boolean running = true;

			while (running) {

				try {

					int choice = services.readMenuChoice();

					if (choice == 1) {
						if (room.bookRoom()) {
							System.out.println("Room booked Successfully...!");
						} else {
							System.out.println("Booking failed...! Room/s are not available...!");
						}
					}

					else if (choice == 2) {
						if (room.releaseRoom()) {
							System.out.println("Room/s released...! it's available again ");
						} else {
							System.out.println("Released Failed...! Room is already Available ");
						}
					} else if (choice == 3) {
						double newPrice = services.readPricePerNight();

						if (room.updatePricePerNight(newPrice)) {
							System.out.printf("Price Updated...! New Price : ₹%.2f%n", room.getPricePerNight());
						} else {
							System.out.printf(" Price mus be positive and higher than 0 ");
						}
					} else if (choice == 4) {
						System.out.println("\n***** Room Details *****");
						System.out.println("Room Number   :- " + room.getRoomNumber());
						System.out.println("Room Type     :- " + room.getRoomType());
						System.out.printf("Price/Night   :- ₹%.2f%n", room.getPricePerNight());
						System.out.println("Available     :- " + (room.isAvailability() ? "YES" : "NO"));
					} else if (choice == 5) {
						System.out.println("Thank you...! Visit Again");
						running = false;
					} else {
						System.out.println("Invalid Option. Choose between 1 to 5");
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter numbers only.");
				}
			}

		}

		catch (NumberFormatException e) {
			System.out.println("Invalid input: " + e.getMessage());
		}

		catch (IllegalArgumentException e) {
			System.out.println("Invalid data: " + e.getMessage());
		}

		finally {
			services.close();
		}

	}

}
