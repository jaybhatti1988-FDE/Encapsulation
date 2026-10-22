package com.java.fde.encapsulation.statements.examples.five;

public class CreditCard {
	private final long cardNumber;
	private double currentUsage;
	private final double creditLimit;

	public CreditCard(long cardNumber, double creditLimit) {

		if (cardNumber <= 0) {
			throw new IllegalArgumentException("Credit Card Number should not negative or 0");
		}

		if (creditLimit <= 0) {
			throw new IllegalArgumentException("Credit Credit should not negative or 0");
		}

		this.cardNumber = cardNumber;
		this.creditLimit = creditLimit;
		this.currentUsage = 0;
	}

	public boolean spend(double amt) {
		if (amt <= 0) {
			return false;
		}
		if (currentUsage + amt > creditLimit) {
			return false;
		}
		currentUsage = currentUsage + amt;
		return true;
	}

	public double getAvailableCredit() {
		return creditLimit - currentUsage;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public double getCurrentUsage() {
		return currentUsage;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

}
