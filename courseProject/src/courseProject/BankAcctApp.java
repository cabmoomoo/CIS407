//Caleb Barbee CIS407 Week 6: Course Project
package courseProject;

import java.util.Scanner;

import courseProject.Account.ACCOUNT_TYPE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankAcctApp {

	public static void main(String[] args) {
		
		// High-level tracker for ensuring new accounts get a unique ID
		int TOTAL_ACCOUNTS = 0;
		// Arrays are normally fixed sized; Customer[] would need either a size or initialization
		// Lists do not need a specified size
		List<Customer> allCustomers = new ArrayList<>();
		// Hashmaps are like arrays, but store data in key: value pairs
		// This enables (in an ideal environment) account retrieval times as fast as (O(1))
		// Compare to the rather slow process of iterating over an array and comparing IDs
		HashMap<String, Account> allAccounts = new HashMap<String, Account>();

		try (Scanner userInput = new Scanner(System.in)) {

			String userCont = "";
			do {
				// Make a new, blank customer
				Customer customer = new Customer();
				
				while (true) {
					try {
						System.out.print("Enter customer ID (non-blank, 5 chars max): ");
						String customerID = userInput.nextLine();
						if (!DataEntry.validateStringLength(customerID, 5)) {
							throw new Exception("Error: Customer ID must be non-blank and 5 chars max");
						}
						customer.setCustomerID(customerID);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				while (true) {
					try {
						System.out.print("Enter customer SSN (9 chars exactly, numeric): ");
						String customerSSN = userInput.nextLine();
						if (!DataEntry.validateStringExactLength(customerSSN, 9) || !DataEntry.validateStringNumeric(customerSSN)) {
							throw new Exception("Error: Customer SSN must be exactly 9 chars and numeric");
						}
						customer.setSSN(customerSSN);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				while (true) {
					try {
						System.out.print("Enter customer last name (non-blank, 20 chars max): ");
						String customerLastName = userInput.nextLine();
						if (!DataEntry.validateStringLength(customerLastName, 20)) {
							throw new Exception("Error: Customer last name must be non-blank and 20 chars max");
						}
						customer.setLastName(customerLastName);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print("Enter customer first name (non-blank, 15 chars max): ");
						String customerFirstName = userInput.nextLine();
						if (!DataEntry.validateStringLength(customerFirstName, 15)) {
							throw new Exception("Error: Customer first name must be non-blank and 15 chars max");
						}
						customer.setFirstName(customerFirstName);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print("Enter customer street name (non-blank, 20 chars max): ");
						String customerStreet = userInput.nextLine();
						if (!DataEntry.validateStringLength(customerStreet, 20)) {
							throw new Exception("Error: Customer street name must be non-blank and 20 chars max");
						}
						customer.setStreet(customerStreet);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print("Enter customer city name (non-blank, 20 chars max): ");
						String customerCity = userInput.nextLine();
						if (!DataEntry.validateStringLength(customerCity, 20)) {
							throw new Exception("Error: Customer city name must be non-blank and 20 chars max");
						}
						customer.setCity(customerCity);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print("Enter customer state (2 chars exactly): ");
						String customerState = userInput.nextLine();
						if (!DataEntry.validateStringExactLength(customerState, 2)) {
							throw new Exception("Error: Customer state must be exactly 2 chars");
						}
						customer.setState(customerState);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print("Enter customer zip code (5 chars exactly, numeric): ");
						String customerZip = userInput.nextLine();
						if (!DataEntry.validateStringExactLength(customerZip, 5) || !DataEntry.validateStringNumeric(customerZip)) {
							throw new Exception("Error: Customer zip code must be exactly 5 chars and numeric");
						}
						customer.setZip(customerZip);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				while (true) {
					try {
						System.out.print("Enter customer phone number (10 chars exactly, numeric): ");
						String customerPhone = userInput.nextLine();
						if (!DataEntry.validateStringExactLength(customerPhone, 10) || !DataEntry.validateStringNumeric(customerPhone)) {
							throw new Exception("Error: Customer phone number must be exactly 10 chars and numeric (no punctuation)");
						}
						customer.setPhone(customerPhone);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				Account customerAccount;
				
				while (true) {
					try {
						System.out.print("Enter new account type (CHK or SAV only): ");
						String accountTypeInput = userInput.nextLine();
						ACCOUNT_TYPE accountType;
						if (accountTypeInput.equals("CHK")) {
							accountType = ACCOUNT_TYPE.CHK;
						} else if (accountTypeInput.equals("SAV")) {
							accountType = ACCOUNT_TYPE.SAV;
						} else {
							throw new Exception("Error: Account type must be CHK or SAV exactly");
						}
						String accountNumber = String.valueOf(TOTAL_ACCOUNTS);
						TOTAL_ACCOUNTS += 1;
						customerAccount = new Account(accountNumber, accountType);
						customer.setAccountNumber(accountNumber);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				while (true) {
					try {
						System.out.print("Enter account service fee (between 0 and 10.00): ");
						double serviceFee = Double.valueOf(userInput.nextLine());
						if (!DataEntry.validateDecimalRange(serviceFee, 0.0, 10.0)) {
							throw new Exception();
						}
						customerAccount.setServiceFee(serviceFee);
						break;
					} catch (Exception e) {
						System.out.println("Error: Service fee must be numeric and between 0 and 10.0");
					}
				}
				
				while (true) {
					try {
						System.out.print("Enter account interest rate (between 0 and 10.0): ");
						double interestRate = Double.valueOf(userInput.nextLine());
						if (!DataEntry.validateDecimalRange(interestRate, 0.0, 10.0)) {
							throw new Exception();
						}
						customerAccount.setInterestRate(interestRate);
						break;
					} catch (Exception e) {
						System.out.println("Error: Interest rate must be numeric and between 0 and 10.0");
					}
				}
				
				while (true) {
					try {
						System.out.print("Enter account overdraft fee (decimal value): ");
						double overdraftFee = Double.valueOf(userInput.nextLine());
						customerAccount.setOverdraftFee(overdraftFee);
						break;
					} catch (Exception e) {
						System.out.println("Error: Overdraft fee must be a decimal value");
					}
				}
				
				while (true) {
					try {
						System.out.print("Enter account balance (decimal value): ");
						double balance = Double.valueOf(userInput.nextLine());
						customerAccount.setBalance(balance);
						break;
					} catch (Exception e) {
						System.out.println("Error: Balance must be a decimal value");
					}
				}
				
				// Add customer to list of all customers
				allCustomers.add(customer);
				// Add account to hashmap of all accounts
				allAccounts.put(customerAccount.getAccountNumber(), customerAccount);
				
				// Loop?
				System.out.print("Add another customer and account (y/n)? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			// Hard-code the header rows
			List<String> customerHeaderRow = new ArrayList<>() {{
				add("Customer ID");
				add("SSN");
				add("Last Name");
				add("First Name");
				add("Street");
				add("City");
				add("State");
				add("Zip Code");
				add("Phone Number");
				add("Account Number");
			}};
			List<String> accountsHeaderRow = new ArrayList<>() {{
				add("Account Number");
				add("Account Type");
				add("Service Fee");
				add("Interest Rate");
				add("Overdraft Fee");
				add("Balance");
			}};
			
			// Make the list of customer data
			List<List<String>> custData = new ArrayList<>();
			for (int i=0; i<allCustomers.size(); i++) {
				custData.add(allCustomers.get(i).toStringList());
			}
			// Make the list of account data
			List<List<String>> acctData = new ArrayList<>();
			for (String acctNum : allAccounts.keySet()) {
				acctData.add(allAccounts.get(acctNum).toStringList());
			}
			
			// Pivot into a list of columns for tabbing
			List<List<String>> custPivot = new ArrayList<>();
			for (int col=0; col<customerHeaderRow.size(); col++) {
				custPivot.add(new ArrayList<>());
				custPivot.get(col).add(customerHeaderRow.get(col));
				for (int row=0; row<allCustomers.size(); row++) {
					custPivot.get(col).add(custData.get(row).get(col));
				}
			}
			List<List<String>> acctPivot = new ArrayList<>();
			for (int col=0; col<accountsHeaderRow.size(); col++) {
				acctPivot.add(new ArrayList<>());
				acctPivot.get(col).add(accountsHeaderRow.get(col));
				for (int row=0; row<allAccounts.size(); row++) {
					acctPivot.get(col).add(acctData.get(row).get(col));
				}
			}
			
			// Send columns over to my tabber function
			List<List<String>> custTabbed = new ArrayList<>();
			for (int col=0; col<customerHeaderRow.size(); col++) {
				custTabbed.add(UltimateStringTabber.ultimateStringTabber(custPivot.get(col), false));
			}
			List<List<String>> acctTabbed = new ArrayList<>();
			for (int col=0; col<accountsHeaderRow.size(); col++) {
				acctTabbed.add(UltimateStringTabber.ultimateStringTabber(acctPivot.get(col), false));
			}
			
			// Print everything
			for (int row=0; row<allCustomers.size()+1; row++) {
				for (int col=0; col<customerHeaderRow.size(); col++) {
					System.out.print(custTabbed.get(col).get(row));
				}
				System.out.print("\n");
			}
			System.out.println();
			for (int row=0; row<allAccounts.size()+1; row++) {
				for (int col=0; col< accountsHeaderRow.size(); col++) {
					System.out.print(acctTabbed.get(col).get(row));
				}
				System.out.print("\n");
			}
			
		}

	}

}
