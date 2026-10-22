package com.java.fde.encapsulation.statements.examples.six;

public class LoanAccount {
	
	private final long loanId;
	private double loanAmount;
	private final double interestRate;
	private double outstandingAmount;
	
	public LoanAccount(long loanId,double loanAmount,double interestRate) {
		
		if (loanId <=0) {
			throw new IllegalArgumentException("Loan Id value should be more than 0");
		}
		
		if (loanAmount <=0) {
			throw new IllegalArgumentException("Loan Amount value should be more than 0");
		}
		
		if (interestRate <1 || interestRate>100) {
			throw new IllegalArgumentException("Interest Rate value should  between 1 to 100");
		}
		
		this.loanId=loanId;
		this.loanAmount=loanAmount;
		this.interestRate=interestRate;
		this.outstandingAmount=loanAmount;
				
	}
	
	public boolean payEMI(double emiAmount) {
		if (emiAmount<=0) {
			return false;
		}
		if (emiAmount > outstandingAmount) {
			return false;
		}
		outstandingAmount-=emiAmount;
		return true;
	}
	

	
	public boolean isLoanClosed() {
		return outstandingAmount==0;
	}

	public long getLoanId() {
		return loanId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

}
