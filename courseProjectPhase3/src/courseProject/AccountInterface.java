//Caleb Barbee CIS407 Week 8: Course Project
package courseProject;

import java.util.List;

import courseProject.Account.TRANSACTION_TYPE;

public interface AccountInterface {

	List<String> prepForPrint();
	void performTransaction(TRANSACTION_TYPE type, double amt) throws Exception;
	void withdraw() throws Exception;
	void deposit();
	void applyInterest(); // Both classes already inherit this from Account.java, so this effectively just exposes it
	double balance();
	double transactionFee();
	
}
