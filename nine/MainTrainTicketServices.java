package com.java.fde.encapsulation.statements.examples.nine;

public class MainTrainTicketServices {

	public static void main(String[] args) {

		TrainTicketServices services = new TrainTicketServices();

		try {
			String id = services.readTicketId();
			String name = services.readPassengerName();
			int seatNo = services.readSeatNumber();

			TrainTicket ticket = new TrainTicket(id, name, seatNo);
			System.out.println("New Ticket Generated Successfully " + " || " + " Status : " + ticket.getTicketStatus());

			boolean running = true;

			while (running) {
				try {
					int choice = services.readMenuChoice();

					if (choice == 1) {
						if (ticket.bookTicket()) {
							System.out.println(
									"Ticket Booked Successfully " + " || " + " Status : " + ticket.getTicketStatus());
						} else {
							System.out.println("Booking not allowed. Ticket is already " + ticket.getTicketStatus());
						}
					} else if (choice == 2) {
						if (ticket.cancelTicket()) {
							System.out.println("Ticket Cancelled Successfully " + " || " + " Status : "
									+ ticket.getTicketStatus());
						} else {
							System.out.println(
									"Cancellation not allowed. Only a BOOKED ticket can be cancelled. Current status :- "
											+ ticket.getTicketStatus());
						}
					} else if (choice == 3) {
						System.out.println("\n***** Train Ticket *****");
						System.out.println("Ticket Id      :- " + ticket.getTicketId());
						System.out.println("Passenger Name :- " + ticket.getPassengerName());
						System.out.println("Seat Number    :- " + ticket.getSeatNumber());
						System.out.println("Ticket Status  :- " + ticket.getTicketStatus());
					} else if (choice == 4) {
						System.out.println("Thank you. Happy Journey!");
						running = false;
					} else {
						System.out.println(" Invalid Option. Choose 1,2,3 or 4 ");
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter numbers only.");
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid input: " + e.getMessage());
		}

		catch (IllegalArgumentException e) {
			System.out.println("Invalid data: " + e.getMessage());
		} finally {
			services.close();
		}

	}

}
