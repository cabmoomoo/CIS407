//Caleb Barbee CIS407 Week 8: Course Project
package courseProject;

import java.util.Scanner;

import courseProject.Account.TRANSACTION_TYPE;

import java.util.HashMap;
import java.util.List;

public class BankAcctApp {

	public static void main(String[] args) {
		
		// High-level tracker for ensuring new accounts get a unique ID
		int TOTAL_ACCOUNTS = 0;
		// Hashmaps are like arrays, but store data in key: value pairs
		// This enables (in an ideal environment) account retrieval times as fast as (O(1))
		// Compare to the rather slow process of iterating over an array and comparing IDs
		HashMap<String, Customer> allCustomers = new HashMap<String,Customer>();
		HashMap<String, CheckingAccount> checkingAccounts = new HashMap<String, CheckingAccount>();
		HashMap<String, SavingsAccount> savingsAccounts = new HashMap<String, SavingsAccount>();

		try (Scanner userInput = new Scanner(System.in)) {

			String userCont = "";
			do {
				// Make a new, blank customer
				Customer customer = AppSupport.newCustomer(userInput);

				while (true) {
					try {
						System.out.print("Enter new account type (CHK or SAV only): ");
						String accountTypeInput = userInput.nextLine();
						if (accountTypeInput.equalsIgnoreCase("CHK")) {
							CheckingAccount account = new CheckingAccount(String.valueOf(TOTAL_ACCOUNTS));
							customer.setAccountNumber(account.getAccountNumber());
							checkingAccounts.put(account.getAccountNumber(), account);
						} else if (accountTypeInput.equalsIgnoreCase("SAV")) {
							SavingsAccount account = new SavingsAccount(String.valueOf(TOTAL_ACCOUNTS));
							customer.setAccountNumber(account.accountNumber);
							savingsAccounts.put(account.getAccountNumber(), account);
						} else {
							throw new Exception("Error: Account type must be CHK or SAV exactly");
						}
						TOTAL_ACCOUNTS += 1;
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				// Add customer to list of all customers
				allCustomers.put(customer.getCustomerID(), customer);
				
				// Loop?
				System.out.print("Add another customer and account (y/n)? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			System.out.println("\nBeginning transactions...\n");
			
			userCont = "";
			do {
				// account can be any object that implements AccountInterface
				AccountInterface account;
				Customer customer;
				
				// Get an account to work on
				while (true) {
					try {
						System.out.print("Enter customer ID: ");
						String customerID = userInput.nextLine();
						if (allCustomers.containsKey(customerID)) {
							customer = allCustomers.get(customerID);
							String accountID = customer.getAccountNumber();
							if (checkingAccounts.containsKey(accountID)) {
								account = checkingAccounts.get(accountID);
							} else if (savingsAccounts.containsKey(accountID)) {
								account = savingsAccounts.get(accountID);
							} else {
								// With the current implementation, this should not be possible
								throw new Exception("Error: Customer with ID " + customerID + " does not have an account");
							}
						} else {
							throw new Exception("Error: Account with ID " + customerID + " was not found");
						}
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				// Start doing transactions
				transaction: while (true) {
					System.out.println("\nWorking on account number: " + customer.getAccountNumber());
					TRANSACTION_TYPE type = TRANSACTION_TYPE.DEP;
					double transactionAmount = 0;
					
					// Get the type
					while (true) {
						try {
							System.out.print("Enter transaction type (DEP, WTH, INT, QUIT only): ");
							String transactionTypeInput = userInput.nextLine();
							if (transactionTypeInput.equalsIgnoreCase("QUIT")) {
								break transaction;
							} else if (transactionTypeInput.equalsIgnoreCase("DEP")) {
								type = TRANSACTION_TYPE.DEP;
							} else if (transactionTypeInput.equalsIgnoreCase("WTH")) {
								type = TRANSACTION_TYPE.WTH;
							} else if (transactionTypeInput.equalsIgnoreCase("INT")) {
								type = TRANSACTION_TYPE.INT;
							} else {
								throw new Exception("Error: Transaction type must be DEP, WTH, INT, or QUIT only");
							}
							break;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					
					// Get the amount
					amount: while (true) {
						switch (type) {
						// Break out of getting user input as interest is calculated, not input
						case INT: break amount;
						}
						try {
							System.out.print("Enter transaction amount: ");
							transactionAmount = Double.valueOf(userInput.nextLine());
							break;
						} catch (Exception e) {
							System.out.println("Error: Input could not be cast to a double. Please input a decimal value.");
						}
					}
					
					// Perform the transaction
					try {
						account.performTransaction(type, transactionAmount);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					// Print the transaction
					List<String> accountInfo = account.prepForPrint();
					accountInfo.set(0, customer.getCustomerID());
					double fees = 0;
					switch (type) {
					case DEP:
					case WTH:
						fees = account.transactionFee();
						break;
					case INT: // Fees are already 0, and interest does not incur fees
						break;
					}
					accountInfo.set(6, String.valueOf(fees));
					AppSupport.printTransaction(accountInfo);
				}
				
				// Work on a new account or quit
				System.out.print("Change account? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
		}
		
		System.out.println("\nThanks for banking");

	}

}
