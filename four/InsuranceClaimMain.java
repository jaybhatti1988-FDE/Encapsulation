package com.java.fde.encapsulation.statements.examples.four;

import java.util.*;

public class InsuranceClaimMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		

		try {

			System.out.print("Enter Policy Claim ID : ");
			long claimId = Long.parseLong(sc.nextLine().trim());

			System.out.print("Enter Policy Number : ");
			long policyNo = Long.parseLong(sc.nextLine().trim());

			System.out.print("Enter Policy Claim Amount : ");
			Double claimAmount = Double.parseDouble(sc.nextLine().trim());

			InsuranceClaim claim=new InsuranceClaim(claimId, policyNo, claimAmount);
			System.out.println("\nClaim Created Successfully :- " +claim.getPolicyStatus());

			System.out.println("TYPE APPROVE/REJECT");
			String action=sc.nextLine().trim().toUpperCase();
			
			boolean result;
			
			if (action.equals("APPROVE")) {
				result=claim.approveClaim();
			} else if (action.equals("REJECT")) {
				result=claim.rejectClaim();
			}else {
				System.out.println("Invalid action. Claim remains " + claim.getPolicyStatus());
				return;
			}if (!result) {
				System.out.println("Action not allowed. Claim is already " + claim.getPolicyStatus());
			}
			
			System.out.println("\n***** Claim Details *****");
			System.out.println("Claim Id :- " + claim.getClaimId());
			System.out.println("Policy Number :- " + claim.getPolicyNumber());
			System.out.println("Claim Amount :- " + claim.getClaimAmount());
			System.out.println("Claim Status :- " + claim.getPolicyStatus());

		
			} catch (NumberFormatException e) {
				System.out.println("Invalid Inputs...!"+e.getMessage());
			
			} catch (IllegalArgumentException  e) {
				System.out.println("Invalid Inputs...!"+e.getMessage());
			}finally {
				sc.close();
		}
	}
}