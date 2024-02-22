//Caleb Barbee CIS407 Week 8: Course Project
package courseProject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Supporting functions for the Main of BankAcctApp.
 * <p>These methods could be placed in main with no difference in functionality, only readability.</p>
 */
public class AppSupport {
	
	/**
	 * Prompts the user for all the information required to generate a new Customer.
	 * Returned customer is missing only the associated account.
	 * This method was in main nearly verbatim before being pulled out in Phase 3
	 * for readability and organizational purposes.
	 * @param userInput A Scanner for console input
	 * @return A nearly complete Customer
	 */
	public static Customer newCustomer(Scanner userInput) {
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
		
		return customer;
	}
	
	public static final List<String> transactionHeader = new ArrayList<String>() {{
		add("Customer ID");
		add("Account Number");
		add("Account Type");
		add("Transaction Date");
		add("Transaction Type");
		add("Transaction Amount");
		add("Additional Fees");
		add("Balance");
	}};
	
	public static void printTransaction(List<String> accountInfo) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		for (int i = 5; i < 8; i++) {
			accountInfo.set(i, formatter.format(Double.valueOf(accountInfo.get(i))));
		}

		List<List<String>> pivoted = new ArrayList<List<String>>();
		for (int col = 0; col < transactionHeader.size(); col++) {
			pivoted.add(new ArrayList<>());
			pivoted.get(col).add(transactionHeader.get(col));
			pivoted.get(col).add(accountInfo.get(col));
		}

		List<List<String>> tabbed = new ArrayList<>();
		for (int col = 0; col < pivoted.size(); col++) {
			tabbed.add(UltimateStringTabber.ultimateStringTabber(pivoted.get(col), true));
		}

		for (int col = 0; col < tabbed.size(); col++) {
			System.out.print(tabbed.get(col).get(0));
		}
		System.out.println();
		for (int col = 0; col < tabbed.size(); col++) {
			System.out.print(tabbed.get(col).get(1));
		}
		System.out.println();
	}

}
