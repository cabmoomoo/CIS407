//Caleb Barbee CIS407 Week 9: Discussion Post
package layoutExamples;

import java.awt.*;
import javax.swing.*;

public class GridBagExample {
	
	private static void buildGUI() {

		JFrame frame = new JFrame("GridBag Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel label = new JLabel("Label: ");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		frame.add(label, c);
		
		JTextField text = new JTextField("Sample text");
		c.gridx = 1;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		frame.add(text, c);
		
		JButton button = new JButton("Button");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		frame.add(button, c);
		
		JRadioButton radio = new JRadioButton("Radio");
		c.gridx = 1;
		frame.add(radio, c);
		
		JCheckBox check = new JCheckBox("Check");
		c.gridx = 2;
		frame.add(check, c);

        frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		buildGUI();
	}

}
