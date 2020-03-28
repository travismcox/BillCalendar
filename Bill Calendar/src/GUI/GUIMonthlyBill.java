/**
 * 
 */
package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MonthlyBill;

/**
 * @author traviscox
 *
 */
public class GUIMonthlyBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	int selection;
	public GUIMonthlyBill(GUIMain frame) {
		this.frame = frame;
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel dateLabel = new JLabel("Recurring Date");
		
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		dateTextField = new JTextField();
		
		JButton buttonEnter = new JButton("Add Monthly Bill");
		
		buttonEnter.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(4,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(dateLabel);
		add(dateTextField);
		add(buttonEnter);
	}
	
	public GUIMonthlyBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		MonthlyBill tempBill = frame.listCollection.getListMonthly().get(selection);
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel dateLabel = new JLabel("Recurring Date");
		
		nameTextField = new JTextField(tempBill.getName());
		amountTextField = new JTextField(tempBill.getAmount().toString());
		dateTextField = new JTextField(String.valueOf(tempBill.getDate()));
		
		JButton buttonGoBack = new JButton("Go Back");
		JButton buttonEdit = new JButton("Edit");
		
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(4,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(dateLabel);
		add(dateTextField);
		add(buttonGoBack);
		add(buttonEdit);
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Add Monthly Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer date = Integer.parseInt(dateTextField.getText());
	        	frame.getListCollection().getListMonthly().add(new MonthlyBill(name, amount, date));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals("Go Back")) {
	        	frame.changeToSelect(0);
	        }
	        else if(action.contentEquals("Edit")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer date = Integer.parseInt(dateTextField.getText());
	        	frame.getListCollection().getListMonthly().get(selection).edit(name, amount, date);
	        	frame.changeToAdd();
	        }
	    }
	}
}
