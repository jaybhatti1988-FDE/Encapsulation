package com.java.fde.encapsulation.statements.examples.four;

public class InsuranceClaim {
	private final long claimId;
	private final long policyNumber;
	private String policyStatus;
	private Double claimAmount;
	
	private static final String PENDING="PENDING";
	private static final String APPROVED="APPROVED";
	private static final String REJECTED="REJECTED";
		
	public InsuranceClaim(long claimId,long policyNumber,Double claimAmount) {
		
		if (claimId<=0) {
			throw new IllegalArgumentException("Policy Claim Id should not negative or 0");
		}
		
		if (policyNumber<=0) {
			throw new IllegalArgumentException("Policy Number should not negative or 0");
		}
		
		if (claimAmount<=0) {
			throw new IllegalArgumentException("Claim Amount should not negative or 0");
		}	
					
		this.claimId=claimId;
		this.policyNumber=policyNumber;
		this.policyStatus=PENDING;
		this.claimAmount=claimAmount;
	}
	

	public boolean approveClaim() {
		if (!policyStatus.equals(PENDING)) {
			return false;
		}
		this.policyStatus=APPROVED;
		return true;
	}
	
	public boolean rejectClaim() {
		if (!policyStatus.equals(PENDING)) {
			return false;
		}
		this.policyStatus=REJECTED;
		return true;
	}
	

	public long getClaimId() {
		return claimId;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}
	
}
