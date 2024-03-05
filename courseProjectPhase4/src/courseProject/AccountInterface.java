//Caleb Barbee CIS407 Week 10: Course Project
package courseProject;

import java.time.LocalDate;
import java.util.List;

import courseProject.Account.TRANSACTION_TYPE;

public interface AccountInterface {

	List<String> prepForPrint();
	void performTransaction(TRANSACTION_TYPE type, double amt, LocalDate date) throws Exception;
	void withdraw() throws Exception;
	void deposit();
	void applyInterest() throws Exception; // Both classes already inherit this from Account.java, so this effectively just exposes it
	double balance();
	double transactionFee();
	
}
