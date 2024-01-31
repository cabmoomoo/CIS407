//Caleb Barbee CIS407 Week 4: Course Project
package courseProject;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BankAcctApp {

	public static void main(String[] args) {

		try (Scanner userInput = new Scanner(System.in)) {
			// Arrays are normally fixed sized; Customer[] would either a size or initialization
			// Lists do not need a specified size
			List<Customer> allCustomers = new ArrayList<>();

			String userCont = "";
			do {
				// Make a new, blank customer
				Customer customer = new Customer();
				
				// Accept input for each data value
				System.out.print("Enter customer ID (non-blank, 5 chars max): ");
				String customerID = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerID, 5)) {
					System.out.println("Error: Customer ID must be non-blank and 5 chars max");
					System.out.print("Enter customer ID (non-blank, 5 chars max): ");
					customerID = userInput.nextLine();
				}
				customer.setCustomerID(customerID);
				
				System.out.print("Enter customer SSN (9 chars exactly, numeric): ");
				String customerSSN = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerSSN, 9) || !DataEntry.validateStringNumeric(customerSSN)) {
					System.out.println("Error: Customer SSN must be exactly 9 chars and numeric");
					System.out.print("Enter customer SSN (9 chars exactly, numeric): ");
					customerSSN = userInput.nextLine();
				}
				customer.setSSN(customerSSN);
				
				System.out.print("Enter customer last name (non-blank, 20 chars max): ");
				String customerLastName = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerLastName, 20)) {
					System.out.println("Error: Customer last name must be non-blank and 20 chars max");
					System.out.print("Enter customer last name (non-blank, 20 chars max): ");
					customerLastName = userInput.nextLine();
				}
				customer.setLastName(customerLastName);
				
				System.out.print("Enter customer first name (non-blank, 15 chars max): ");
				String customerFirstName = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerFirstName, 15)) {
					System.out.println("Error: Customer first name must be non-blank and 15 chars max");
					System.out.print("Enter customer first name (non-blank, 15 chars max): ");
					customerFirstName = userInput.nextLine();
				}
				customer.setFirstName(customerFirstName);
				
				System.out.print("Enter customer street name (non-blank, 20 chars max): ");
				String customerStreet = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerStreet, 20)) {
					System.out.println("Error: Customer street name must be non-blank and 20 chars max");
					System.out.print("Enter customer street name (non-blank, 20 chars max): ");
					customerStreet = userInput.nextLine();
				}
				customer.setStreet(customerStreet);

				System.out.print("Enter customer city name (non-blank, 20 chars max): ");
				String customerCity = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerCity, 20)) {
					System.out.println("Error: Customer city name must be non-blank and 20 chars max");
					System.out.print("Enter customer city name (non-blank, 20 chars max): ");
					customerCity = userInput.nextLine();
				}
				customer.setCity(customerCity);

				System.out.print("Enter customer state (2 chars exactly): ");
				String customerState = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerState, 2)) {
					System.out.println("Error: Customer state must be exactly 2 chars");
					System.out.print("Enter customer state (2 chars exactly): ");
					customerState = userInput.nextLine();
				}
				customer.setState(customerState);
				
				System.out.print("Enter customer zip code (5 chars exactly, numeric): ");
				String customerZip = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerZip, 5) || !DataEntry.validateStringNumeric(customerZip)) {
					System.out.println("Error: Customer zip code must be exactly 5 chars and numeric");
					System.out.print("Enter customer zip code (5 chars exactly, numeric): ");
					customerZip = userInput.nextLine();
				}
				customer.setZip(customerZip);
				
				System.out.print("Enter customer phone number (10 chars exactly, numeric): ");
				String customerPhone = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerPhone, 10) || !DataEntry.validateStringNumeric(customerPhone)) {
					System.out.println("Error: Customer phone number must be exactly 10 chars and numeric (no punctuation)");
					System.out.print("Enter customer phone number (10 chars exactly, numeric): ");
					customerPhone = userInput.nextLine();
				}
				customer.setPhone(customerPhone);
				
				// Add customer to list of all customers
				allCustomers.add(customer);
				
				// Loop?
				System.out.print("Add another customer (y/n)? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			// Hard-code a header row
			List<String> headerRow = new ArrayList<>() {{
				add("Customer ID");
				add("SSN");
				add("Last Name");
				add("First Name");
				add("Street");
				add("City");
				add("State");
				add("Zip Code");
				add("Phone Number");
			}};
			
			// Make the list of customer data
			List<List<String>> custData = new ArrayList<>();
			for (int i=0; i<allCustomers.size(); i++) {
				custData.add(allCustomers.get(i).toStringList());
			}
			
			// Pivot into a list of columns for tabbing
			List<List<String>> everything = new ArrayList<>();
			for (int col=0; col<headerRow.size(); col++) {
				everything.add(new ArrayList<>());
				everything.get(col).add(headerRow.get(col));
				for (int row=0; row<allCustomers.size(); row++) {
					everything.get(col).add(custData.get(row).get(col));
				}
			}
			
			// Send columns over to my tabber function
			List<List<String>> allTabbed = new ArrayList<>();
			for (int col=0; col<headerRow.size(); col++) {
				allTabbed.add(UltimateStringTabber.ultimateStringTabber(everything.get(col), false));
			}
			
			// Print everything
			for (int row=0; row<allCustomers.size()+1; row++) {
				for (int col=0; col<headerRow.size(); col++) {
					System.out.print(allTabbed.get(col).get(row));
				}
				System.out.print("\n");
			}
			
		}

	}

}
