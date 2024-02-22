//Caleb Barbee CIS407 Week 8: Course Project
package courseProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account implements AccountInterface {
	
	public LocalDate transactionDate;
	public TRANSACTION_TYPE transactionType;
	public double transactionAmount;
	public double transactionFee;

	public SavingsAccount(String accountNumber) {
		// service fee, interest rate, overdraft are all final
		super(accountNumber, 0.25, 0.05, 0);
	}
	
	public boolean checkOverdraft() {
		return (this.balance - this.transactionAmount - this.serviceFee) > 0;
	}

	@Override
	public List<String> prepForPrint() {
		List<String> result = new ArrayList<String>();
		result.add("temp/custID");
		result.add(this.accountNumber);
		result.add("Savings");
		result.add(this.transactionDate.toString());
		result.add(this.transactionType.toString());
		result.add(String.valueOf(this.transactionAmount));
		result.add("temp/fees");
		result.add(String.valueOf(this.balance()));
		return result;
	}
	@Override
	public void performTransaction(TRANSACTION_TYPE type, double amt) throws Exception {
		this.transactionDate = LocalDate.now();
		this.transactionType = type;
		this.transactionAmount = amt;
		switch (type) {
		case DEP:
			this.deposit();
			break;
		case WTH:
			this.withdraw();
			break;
		case INT:
			this.transactionAmount = this.balance * this.interestRate;
			this.applyInterest();
			break;
		}
	}
	@Override
	public void withdraw() throws Exception {
		if (this.checkOverdraft()) {
			this.balance = this.balance - this.transactionAmount - this.serviceFee;
			this.transactionFee = this.serviceFee;
		} else {
			this.transactionFee = 0.0;
			throw new Exception("Balance insufficient for this withdrawl.");
		}
	}
	@Override
	public void deposit() {
		this.balance = this.balance + this.transactionAmount - this.serviceFee;		
		this.transactionFee = this.serviceFee;
	}
	@Override
	public double balance() {
		return this.balance;
	}
	@Override
	public double transactionFee() {
		return this.transactionFee;
	}
	
}
