//Caleb Barbee CIS407 Week 8: Course Project
package courseProject;

public abstract class Account {

	String accountNumber;
	final double serviceFee;
	final double interestRate;
	final double overdraftFee;
	double balance = 0;
	
	public enum TRANSACTION_TYPE {
		DEP,
		WTH,
		INT;
		
		@Override
		public String toString() {
			switch (this) {
			case DEP:
				return "Deposit";
			case INT:
				return "Interest";
			case WTH:
				return "Withdrawl";
			}
			return null;
		}
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public void applyInterest() {
		if (this.balance > 0) {
			this.balance = this.balance + (this.balance * this.interestRate);
		} else {
			System.out.println("Accounts with negative or 0 balance cannot accrue interest");
		}
	}
	
	public Account(String accountNumber, double serviceFee, double interestRate, double overdraftFee) {
		this.accountNumber = accountNumber;
		this.serviceFee = serviceFee;
		this.interestRate = interestRate;
		this.overdraftFee = overdraftFee;
	}
	
}
