package com.java.fde.encapsulation.statements.examples.seven;

public class Customer {
	
	private final long customerId;
	private final String customerName,customerEmail;
	private double walletBalance;
	
	public Customer(long customerId,String customerName,String customerEmail) {
		if (customerId <=0) {
			throw new IllegalArgumentException("Customer Id value should be more than 0");
		}
		
		if (customerName ==null || customerName.trim().isEmpty()) {
			throw new IllegalArgumentException("Customer Name should not be blank or null");
		}
		
		if (customerEmail ==null || customerEmail.trim().isEmpty()) {
			throw new IllegalArgumentException("Customer Email should not be blank or null");
		}
		
		if (!customerEmail.contains("@")  || !customerEmail.contains(".")) {
			throw new IllegalArgumentException("Customer Email is not valid");
		}
		
		this.customerId=customerId;
		this.customerName=customerName.trim();
		this.customerEmail=customerEmail.trim();
		this.walletBalance=0;
	}
	
	public boolean rechargeWallet(double amount) {
		
		if (amount<0) {
			System.out.println("Insufficient Blance...! Wallet Recharge");
			return false;
		}
		walletBalance+=amount; 
			System.out.printf("Amount Adding in Wallet : ₹%.2f%n ", this.walletBalance);
			return true;
		}
			
	public boolean makePayment(double amount) {
		if (amount<0) {
			return false;
		}
		if (amount>walletBalance) {
			System.out.println("Insufficient Balance");
			return false;
		}
		walletBalance-=amount;
		return true;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public double getWalletBalance() {
		return walletBalance;
	}
}
