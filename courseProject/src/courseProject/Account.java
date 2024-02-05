//Caleb Barbee CIS407 Week 6: Course Project
package courseProject;

import java.util.ArrayList;
import java.util.List;

public class Account {

	String accountNumber;
	ACCOUNT_TYPE accountType;
	double serviceFee = 0;
	double interestRate = 0;
	double overdraftFee = 0;
	double balance = 0;
	
	// Enums are far more versatile than a string of predetermined options.
	// If a new account type is added, nothing will compile until all
	// instanced of match ACCOUNT_TYPE have handled the new value.
	// As the next iteration of this project will involve making Account a
	// superclass for checking and savings account classes, this is really
	// just for my benefit right now - and I'm okay with that. :D
	public enum ACCOUNT_TYPE {
		CHK,
		SAV
	}
	
	// Most data for an account can be reasonably defaulted, but account number and type should always be provided.
	// By defining *a* constructor, users can now only use defined constructors.
	// In other words, new Account() no longer works, and users must implement new Account(String, ACCOUNT_TYPE) or
	// some other explicitly defined constructor.
	public Account(String accountNumber, ACCOUNT_TYPE accountType) {
		if (0 < accountNumber.length() && accountNumber.length() <= 5) {
			this.accountNumber = accountNumber;
		} else {
			System.out.println("Invalid new account number provided. Assigning blank default.");
			this.accountNumber = "";
		}
		this.accountType = accountType;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public double getServiceFee() {
		return this.serviceFee;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setOverdraftFee(double overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
	public double getOverdraftFee() {
		return this.overdraftFee;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return this.balance;
	}
	
	public List<String> toStringList() {
		List<String> result = new ArrayList<String>();
		result.add(this.accountNumber);
		result.add(this.accountType.toString());
		result.add(String.valueOf(this.serviceFee));
		result.add(String.valueOf(this.interestRate));
		result.add(String.valueOf(this.overdraftFee));
		result.add(String.valueOf(this.balance));
		return result;
	}
	
}
