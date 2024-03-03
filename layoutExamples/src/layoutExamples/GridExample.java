//Caleb Barbee CIS407 Week 9: Discussion Post
package layoutExamples;

import java.awt.*;

import javax.swing.*;

public class GridExample {
	
	private static void buildGUI() {

		JFrame frame = new JFrame("Animal Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,2));
		
		frame.add(new JLabel("Label: "));
		frame.add(new JTextField("Sample text", 20));
		frame.add(new JButton("Button"));
		frame.add(new JRadioButton("Radio"));
		frame.add(new JCheckBox("Check"));
		
        frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		buildGUI();
	}

}
