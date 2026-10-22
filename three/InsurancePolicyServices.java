package com.java.fde.encapsulation.statements.examples.three;

public class InsurancePolicyServices {
	
	public void updatePremium(InsurancePolicy policy,double newPremium) {
		if (policy.updatePremium(newPremium)) {
			System.out.printf("Premium Update Successfull New Premium : ₹%.2f%n",policy.getPremiumAmount());
		}
		else {
			System.out.printf("Premium Update Failed...! Amount must be Positive and policy must not to be Cancelled ");
		}
	}
	
	public void changeStatus(InsurancePolicy policy,String newStatus) {
		if (policy.changePolicyStatus(newStatus)) {
			System.out.printf("Policy Status Update changes to : %s%n",policy.getPolicyStatus());
		}
		else {
			System.out.printf("Policy Status Failed...! Use ACTIVE, LAPSED , SUSPENDED or CANCELLED (a cancelled policy can't be changed).");
		}
	}
	
	public void displayPolicyDetails(InsurancePolicy policy) {
		System.out.println("\n------------------------------------------");
		System.out.println("            POLICY DETAILS                ");
		System.out.println("------------------------------------------");
		System.out.println("Policy Id     : " + policy.getPolicyId());
		System.out.println("Holder Name   : " + policy.getPolicyHolderName());
		System.out.printf("Premium       : ₹%.2f%n", policy.getPremiumAmount());
		System.out.println("Status        : " + policy.getPolicyStatus());
		System.out.println("------------------------------------------");
	}
}
