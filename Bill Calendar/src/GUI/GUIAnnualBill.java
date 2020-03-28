/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.GUIOneTimeBill.AddBillActionListener;
import main.AnnualBill;
import main.OneTimeBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIAnnualBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, yearTextField, monthTextField, dayTextField;
	private int selection;
	public GUIAnnualBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		monthTextField = new JTextField();
		dayTextField = new JTextField();
		
		JButton buttonEnter = new JButton("Add Annual Bill");
		
		buttonEnter.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(5,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(monthLabel);
		add(monthTextField);
		add(dayLabel);
		add(dayTextField);
		add(buttonEnter);
		
	}
	
	public GUIAnnualBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		AnnualBill tempBill = frame.listCollection.getListAnnual().get(selection);
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		
		nameTextField = new JTextField(tempBill.getName());
		amountTextField = new JTextField(tempBill.getAmount().toString());
		monthTextField = new JTextField(String.valueOf(tempBill.getMonth()));
		dayTextField = new JTextField(String.valueOf(tempBill.getDay()));
		
		JButton buttonGoBack = new JButton("Go Back");
		JButton buttonEdit = new JButton("Edit");
		
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(5,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(monthLabel);
		add(monthTextField);
		add(dayLabel);
		add(dayTextField);
		add(buttonGoBack);
		add(buttonEdit);
		
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Add Annual Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer month = Integer.parseInt(monthTextField.getText());
	        	Integer day = Integer.parseInt(dayTextField.getText());
	        	frame.getListCollection().getListAnnual().add(new AnnualBill(name, amount, month, day));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals("Go Back")) {
	        	frame.changeToSelect(Utility.OneTimeBill);
	        }
	        else if(action.contentEquals("Edit")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer month = Integer.parseInt(monthTextField.getText());
	        	Integer day = Integer.parseInt(dayTextField.getText());
	        	frame.getListCollection().getListAnnual().get(selection).edit(name, amount, month, day);
	        	frame.changeToAdd();
	        }
	    }
	}
}
