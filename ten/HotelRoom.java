package com.java.fde.encapsulation.statements.examples.ten;

public class HotelRoom {

	private static final String LUXURY = "LUXURY";
	private static final String SUITE = "SUITE";
	private static final String PREMIUM = "PREMIUM";
	private static final String COMMON = "COMMON";

	private final String roomNumber;
	private final String roomType;
	private double pricePerNight;
	private boolean availabilityStatus;

	public HotelRoom(String roomNumber, String roomType, double pricePerNight) {

		if (roomNumber == null || roomNumber.trim().isEmpty()) {
			throw new IllegalArgumentException("Room Number should not be blank or null");
		}

		if (!isValidRoomType(roomType)) {
			throw new IllegalArgumentException("Room Type must be LUXURY, SUITE, PREMIUM or COMMON");
		}

		if (pricePerNight <= 0) {
			throw new IllegalArgumentException("Seat Number value should be positive");
		}

		this.roomNumber = roomNumber.trim();
		this.roomType = roomType.trim().toUpperCase();
		this.pricePerNight = pricePerNight;
		this.availabilityStatus = true;
	}

	public boolean isValidRoomType(String type) {
		if (type == null) {
			return false;
		}
		String t = type.trim().toUpperCase();
		return t.equals(LUXURY) || t.equals(SUITE) || t.equals(PREMIUM) || t.equals(COMMON);
	}

	public boolean bookRoom() {
		if (!availabilityStatus) {
			return false;
		}
		availabilityStatus = false;
		return true;
	}

	public boolean releaseRoom() {
		if (availabilityStatus) {
			return false;
		}
		availabilityStatus = true;
		return true;
	}

	public boolean isAvailability() {
		return availabilityStatus;
	}

	public boolean updatePricePerNight(double newPrice) {
		if (newPrice <= 0) {
			return false;
		}
		this.pricePerNight = newPrice;
		return true;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

}
