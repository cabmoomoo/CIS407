//Caleb Barbee CIS407 Week 10: Course Project
package courseProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class NewCustomerGUI implements ActionListener {

	static final String[] statesArray = {"NC", "SC", "VA", "TN", "GA"};
	
	public int TOTAL_ACCOUNTS = 0;
	public HashMap<String, Customer> allCustomers = new HashMap<String,Customer>();
	public HashMap<String, CheckingAccount> checkingAccounts = new HashMap<String, CheckingAccount>();
	public HashMap<String, SavingsAccount> savingsAccounts = new HashMap<String, SavingsAccount>();
	
	private JFrame frame;
	private List<JTextField> customerCompsFields = new ArrayList<JTextField>();
	private JComboBox<String> stateField;
	private JRadioButton radioChecking;
	private JRadioButton radioSavings;
	private JLabel statusMessage;
	
	NewCustomerGUI() {

		frame = new JFrame("New Customers & Accounts");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel title = new JLabel("New Customers/Accounts");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(5, 5, 5, 5);
		frame.add(title, c);

		c.gridwidth = 1;
		c.gridy = GridBagConstraints.RELATIVE;
		c.anchor = GridBagConstraints.LINE_END;
		frame.add(new JLabel("Customer ID:"), c);
		frame.add(new JLabel("SSN:"), c);
		frame.add(new JLabel("Last Name:"), c);
		frame.add(new JLabel("First Name:"), c);
		frame.add(new JLabel("Street Address:"), c);
		frame.add(new JLabel("City:"), c);
		frame.add(new JLabel("State:"), c);
		frame.add(new JLabel("Zip Code:"), c);
		frame.add(new JLabel("Phone Number:"), c);
		
		c.gridwidth = 2;
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		JTextField customerID = new JTextField(5);
		customerCompsFields.add(customerID);
		frame.add(customerID, c);
		c.gridy = GridBagConstraints.RELATIVE;
		JTextField SSN = new JTextField(9);
		customerCompsFields.add(SSN);
		frame.add(SSN, c);
		JTextField lastName = new JTextField(20);
		customerCompsFields.add(lastName);
		frame.add(lastName, c);
		JTextField firstName = new JTextField(15);
		customerCompsFields.add(firstName);
		frame.add(firstName, c);
		JTextField street = new JTextField(20);
		customerCompsFields.add(street);
		frame.add(street, c);
		JTextField city = new JTextField(20);
		customerCompsFields.add(city);
		frame.add(city, c);
		stateField = new JComboBox<String>(statesArray);
		frame.add(stateField, c);
		JTextField zip = new JTextField(5);
		customerCompsFields.add(zip);
		frame.add(zip, c);
		JTextField phone = new JTextField(10);
		customerCompsFields.add(phone);
		frame.add(phone, c);

		c.gridx = 0;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		JPanel radioPanel = new JPanel();
		radioChecking = new JRadioButton("Checking");
		radioChecking.setSelected(true);
		radioSavings = new JRadioButton("Savings");
		radioPanel.add(radioChecking);
		radioPanel.add(radioSavings);
		frame.add(radioPanel, c);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioChecking);
		radioGroup.add(radioSavings);
		
		statusMessage = new JLabel(messageToHTML(" "));
		statusMessage.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(statusMessage, c);
		
		c.fill = GridBagConstraints.NONE;
		JButton addCustomer = new JButton("Add New Customer and Account");
		addCustomer.addActionListener(this);
		frame.add(addCustomer, c);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String customerID = customerCompsFields.get(0).getText();
		if (!DataEntry.validateStringLength(customerID, 5)) {
			changeStatus("Error: Customer ID must be non-blank and 5 chars max");
			return;
		}
		String customerSSN = customerCompsFields.get(1).getText();
		if (!DataEntry.validateStringExactLength(customerSSN, 9) || !DataEntry.validateStringNumeric(customerSSN)) {
			changeStatus("Error: Customer SSN must be exactly 9 chars and numeric");
			return;
		}
		String customerLastName = customerCompsFields.get(2).getText();
		if (!DataEntry.validateStringLength(customerLastName, 20)) {
			changeStatus("Error: Customer last name must be non-blank and 20 chars max");
			return;
		}
		String customerFirstName = customerCompsFields.get(3).getText();
		if (!DataEntry.validateStringLength(customerFirstName, 15)) {
			changeStatus("Error: Customer first name must be non-blank and 15 chars max");
			return;
		}
		String customerStreet = customerCompsFields.get(4).getText();
		if (!DataEntry.validateStringLength(customerStreet, 20)) {
			changeStatus("Error: Customer street name must be non-blank and 20 chars max");
			return;
		}
		String customerCity = customerCompsFields.get(5).getText();
		if (!DataEntry.validateStringLength(customerCity, 20)) {
			changeStatus("Error: Customer city name must be non-blank and 20 chars max");
			return;
		}
		String customerState = stateField.getItemAt(stateField.getSelectedIndex());
		String customerZip = customerCompsFields.get(6).getText();
		if (!DataEntry.validateStringExactLength(customerZip, 5) || !DataEntry.validateStringNumeric(customerZip)) {
			changeStatus("Error: Customer zip code must be exactly 5 chars and numeric");
			return;
		}
		String customerPhone = customerCompsFields.get(7).getText();
		if (!DataEntry.validateStringExactLength(customerPhone, 10) || !DataEntry.validateStringNumeric(customerPhone)) {
			changeStatus("Error: Customer phone number must be exactly 10 chars and numeric (no punctuation)");
			return;
		}
		
		Customer customer = new Customer(customerID, customerSSN, customerLastName, customerFirstName, customerStreet, customerCity, customerState, customerZip, customerPhone);
		if (radioChecking.isSelected()) {
			CheckingAccount checking = new CheckingAccount(String.valueOf(TOTAL_ACCOUNTS));
			customer.setAccountNumber(checking.accountNumber);
			checkingAccounts.put(checking.getAccountNumber(), checking);
		} else {
			SavingsAccount savings = new SavingsAccount(String.valueOf(TOTAL_ACCOUNTS));
			customer.setAccountNumber(savings.getAccountNumber());
			savingsAccounts.put(savings.getAccountNumber(), savings);
		}
		allCustomers.put(customer.getCustomerID(), customer);
		TOTAL_ACCOUNTS += 1;
		changeStatus("Customer ID " + customer.getCustomerID() + " and Account " + customer.getAccountNumber()  + " successfully added");
		
//		this.statusMessage.setText(messageToHTML("This is a really long test to see if text wrapping is going to be something I need to implement"));
//		frame.pack();
	}
	
	public void changeStatus(String content) {
		this.statusMessage.setText(messageToHTML(content));
		frame.pack();
	}
	
	String messageToHTML(String content) {
		// Normal text in Java Swing objects does not support word wrap
		// It does, however, support HTML and basic CSS, which can allow
		// for width specification and automatic word wrap
		String part1 = "<html><body style='width:250px'><p style='text-align:center'>";
		String part2 = "</p></body></html>";
		String result = part1 + content + part2;
		return result;
	}
	

}
