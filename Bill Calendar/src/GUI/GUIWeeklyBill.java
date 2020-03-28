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
import main.Utility;
import main.WeeklyBill;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	int selection;
	public GUIWeeklyBill(GUIMain frame) {
		this.frame = frame;
		
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
	
	public GUIWeeklyBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		WeeklyBill tempBill = frame.listCollection.getListWeekly().get(selection);
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		
		nameTextField = new JTextField(tempBill.getName());
		amountTextField = new JTextField(tempBill.getAmount().toString());
		
		JButton buttonGoBack = new JButton("Go Back");
		JButton buttonEdit = new JButton("Edit");
		
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(3,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(buttonGoBack);
		add(buttonEdit);
		
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Add Weekly Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	frame.getListCollection().getListWeekly().add(new WeeklyBill(name, amount));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals("Go Back")) {
	        	frame.changeToSelect(Utility.WeeklyBill);
	        }
	        if(action.contentEquals("Edit")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	frame.getListCollection().getListWeekly().get(selection).edit(name, amount);
	        	frame.changeToAdd();
	        }
	    }
	}

}
