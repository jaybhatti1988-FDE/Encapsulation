package com.java.fde.encapsulation.statements.examples.nine;

public class TrainTicket {
	
	private static final String NOT_BOOKED = "NOT BOOKED";
	private static final String BOOKED = "BOOKED";
	private static final String CANCELLED = "CANCELLED";
	
	private final String ticketId,passengerName;
	private final int seatNumber;
	private String ticketStatus;
	
	public TrainTicket(String ticketId,String passengerName,int seatNumber) {
		
		if (ticketId == null || ticketId.trim().isEmpty()) {
			throw new IllegalArgumentException("Ticket Id should not be blank or null");
		}

		if (passengerName == null || passengerName.trim().isEmpty()) {
			throw new IllegalArgumentException("Passenger Name should not be blank or null");
		}

		if (seatNumber <= 0) {
			throw new IllegalArgumentException("Seat Number value should be positive");
		}
		
		this.ticketId=ticketId.trim();
		this.passengerName=passengerName.trim();
		this.seatNumber=seatNumber;
		this.ticketStatus=NOT_BOOKED;
	}
	
	public boolean bookTicket() {
		if (!ticketStatus.equals(NOT_BOOKED)) {
			return false;
		}
		ticketStatus=BOOKED;
		return true;
	}
	
	public boolean cancelTicket() {
		if (!ticketStatus.equals(BOOKED)) {
			return false;
		}
		ticketStatus=CANCELLED;
		return true;
	}

	public String getTicketId() {
		return ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}
	
	

}
