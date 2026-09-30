package com.java.fde.encapsulation.staments.examples.one;

public class BankAccount {
	
	private String acNumber,acHolderName;
	private double acBalance;
	
	public BankAccount(String acNumber, String acHolderName,double acBalance) {
		this.acNumber=acNumber;
		this.acHolderName=acHolderName;
		this.acBalance=(acBalance>=0)?acBalance:0;
	}

	public void setAcNumber(String acNumber) {
		if (acNumber.trim().isEmpty()||acNumber==null) {
			System.out.println("Account Number cant't be empty");
		} else {
			this.acNumber = acNumber;
		}
		
	}

	public void setAcHolderName(String acHolderName) {
		if (acHolderName.trim().isEmpty()||acHolderName==null) {
			System.out.println("Account Name cant't be empty");
		} else {
			this.acHolderName = acHolderName;
		}
	}

	public void Deposit(double amount) {
		if (amount<=0) {
			System.out.println("Invalid Deposit Amount can't be Zero or Negative");
		} else {
			acBalance=acBalance+amount;
			System.out.printf("Amount Credited in Account Successfully & Added Amount is ₹%.2f%n",amount);
			displayBalance();
		}
	}

	public void WithDraw(double amount) {
	
		if (amount<=0) {
			System.out.println("Invalid Withdraw Amount can't be Zero or Negative");
		} else if(amount>acBalance){
			System.out.println("Insufficient Balance");
			displayBalance();
		}else {
			acBalance=acBalance-amount;
			System.out.printf("Amount Debited in Account Successfully & Deduct Amount is ₹%.2f%n",amount);
			displayBalance();
		}
	}
	
	public void displayBalance() {
		 System.out.printf("   Updated Balance : ₹%.2f%n", acBalance);
	}
	
	public void DisplayDetails() {
		System.out.println("\n------------------------------------------");
        System.out.println("           ACCOUNT DETAILS                 ");
        System.out.println("------------------------------------------");
        System.out.println("Account Number   : " + acNumber);
        System.out.println("Account Holder   : " + acHolderName);
        System.out.printf ("Balance          : ₹%.2f%n", acBalance);
        System.out.println("------------------------------------------");
	}
	
	public String getAcNumber() {
		return acNumber;
	}
	
	public String getAcHolderName() {
		return acHolderName;
	}
	
	public double getAcBalance() {
		return acBalance;
	}

}
