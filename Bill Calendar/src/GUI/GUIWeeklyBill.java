/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.GUIMonthlyBill.AddBillActionListener;
import main.MonthlyBill;
import main.WeeklyBill;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	public GUIWeeklyBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		
		JButton buttonEnter = new JButton("Add Monthly Bill");
		
		buttonEnter.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(3,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(buttonEnter);
		
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Add Monthly Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	frame.getListCollection().getListWeekly().add(new WeeklyBill(name, amount));
	        	frame.changeToAdd();
	        }
	    }
	}

}
