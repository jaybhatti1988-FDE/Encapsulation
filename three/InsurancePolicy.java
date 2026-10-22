package com.java.fde.encapsulation.statements.examples.three;

public class InsurancePolicy {
	private final long policyId;
	private final String policyHolderName;
	private String policyStatus;
	private Double premiumAmount;
		
	public InsurancePolicy(long policyId,String policyHolderName,double premiumAmount,String policyStatus) {
		
		if (policyId<=0) {
			throw new IllegalArgumentException("Policy Id should not blank or null");
		}
		
		if (policyHolderName==null || policyHolderName.trim().isEmpty()) {
			throw new IllegalArgumentException("Policy Holder Name should not blank or null");
		}
		
		if (!isValidateStatus(policyStatus)) {
			throw new IllegalArgumentException("Policy Status Must Active,Lapsed,Suspended or Cancelled  ");
		}
		
		if (premiumAmount<=0) {
			throw new IllegalArgumentException("Premium Amount should not 0 or negative");
		}
		
		this.policyId=policyId;
		this.policyHolderName=policyHolderName;
		this.policyStatus=policyStatus;
		this.premiumAmount=premiumAmount;
	}
	
	public boolean isValidateStatus(String status) {
		if (status==null) {
			return false;
		} else {
			String s=status.trim().toUpperCase();
			return s.equals("ACTIVE")||s.equals("LAPSED") || s.equals("SUSPENDED") ||s.equals("CANCELLED"); 
		}
	}
	
	public boolean updatePremium(double newPremium) {
		if (newPremium <= 0 || policyStatus.equals("CANCELLED")) {
			return false;
		}
		this.premiumAmount = newPremium;
		return true;
	}
	
	public boolean changePolicyStatus(String newStatus) {
		if (!isValidateStatus (newStatus) || policyStatus.equals("CANCELLED")) {
			return false;
		}
		this.policyStatus = newStatus.trim().toUpperCase();
		return true;
	}
		
	public long getPolicyId() {
		return policyId;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}
	
}
