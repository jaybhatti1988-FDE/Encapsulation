package com.java.fde.encapsulation.statements.examples.six;

public class MainLoanAccount {

	public static void main(String[] args) {

		LoanAccountServices services = new LoanAccountServices();

		try {

			long loanId = services.readLoanId();
			double loanAmt = services.readLoanAmount();
			double loanInterestRate = services.readInterestRate();

			LoanAccount accnt = new LoanAccount(loanId, loanAmt, loanInterestRate);
			System.out.println("\n New Loan Account Created Successfully....!");

			boolean running = true;

			while (running) {
				try {

					int choice = services.readMenuChoice();

					if (choice == 1) {

						if (accnt.isLoanClosed()) {
							System.out.println("Loan All EMI Fully Paid ");
							continue;
						}
						double emi = services.readEMIAmount();

						if (accnt.payEMI(emi)) {
						    System.out.println("EMI paid: " + emi + " | Outstanding now: " + accnt.getOutstandingAmount());

						    if (accnt.isLoanClosed()) {
						        System.out.println("Congratulations...! Loan All EMI Fully Paid ");
						    }
						} else {
						    System.out.println("Payment failed. Amount must be greater than 0 and not more than outstanding ("
						            + accnt.getOutstandingAmount() + ")");
						}
			} else if (choice == 2) {
						System.out.println("\n***** Loan Details *****");
						System.out.println("Loan Id            :- " + accnt.getLoanId());
						System.out.println("Loan Amount        :- " + accnt.getLoanAmount());
						System.out.println("Interest Rate      :- " + accnt.getInterestRate() + "%");
						System.out.println("Outstanding Amount :- " + accnt.getOutstandingAmount());
					}else if (choice == 3) {
						System.out.println("Thank you Using our Loan Service System ... Visit Again, Thank you");
						running=false;
					}else {
						System.out.println("Invalid option. Choose 1, 2 or 3.");
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid Input" + e.getMessage());
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid Input : " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Data : " + e.getMessage());
		} finally {
			services.close();
		}
		 
	}
}
