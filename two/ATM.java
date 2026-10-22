package com.java.fde.encapsulation.staments.examples.two;

public class ATM {

	private final long crdNumbr;
	private long pin;
	private double balance;

	public ATM(long crdNumbr, long pin, double balance) {

		if (crdNumbr <= 0) {
			throw new IllegalArgumentException("Card Number should not 0 or negative");
		}

		if (pin <= 0) {
			throw new IllegalArgumentException("Pin Number should not 0 or negative");
		}
		this.crdNumbr = crdNumbr;
		this.pin = pin;
		this.balance = (balance >= 0) ? balance : 0;
	}

	public boolean validatePin(long enteredPin) {
		return this.pin == enteredPin;
	}

	public boolean changePin(long oldPin, long newPin) {
		if (validatePin(oldPin) && newPin > 0) {
			this.pin = newPin;
			return true;
		}
		return false;
	}

	public boolean credit(double amount) {
		if (amount <= 0) {
			return false;
		}
		balance += amount;

		return true;
	}

	public boolean WithDrawl(double amount) {

		if (amount <= 0) {
			return false;
		}
		balance -= amount;

		return true;
	}

	public long getCrdNumbr() {
		return crdNumbr;
	}

	public double getBalance() {
		return balance;
	}

}
