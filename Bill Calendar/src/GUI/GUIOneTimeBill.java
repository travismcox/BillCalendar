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

import GUI.GUIMonthlyBill.AddBillActionListener;
import main.MonthlyBill;
import main.OneTimeBill;

/**
 * @author traviscox
 *
 */
public class GUIOneTimeBill extends JPanel {
	GUIMain frame;
	JTextField nameTextField, amountTextField, yearTextField, monthTextField, dayTextField;
	private int selection;
	public GUIOneTimeBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel yearLabel = new JLabel("YYYY");
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		yearTextField = new JTextField();
		monthTextField = new JTextField();
		dayTextField = new JTextField();
		
		JButton buttonEnter = new JButton("Add One Time Bill");
		
		buttonEnter.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(6,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(yearLabel);
		add(yearTextField);
		add(monthLabel);
		add(monthTextField);
		add(dayLabel);
		add(dayTextField);
		add(buttonEnter);
		
	}
	
	public GUIOneTimeBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		OneTimeBill tempBill = frame.listCollection.getListOneTime().get(selection);
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel yearLabel = new JLabel("YYYY");
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		
		nameTextField = new JTextField(tempBill.getName());
		amountTextField = new JTextField(tempBill.getAmount().toString());
		yearTextField = new JTextField(String.valueOf(tempBill.getDate().get(Calendar.YEAR)));
		monthTextField = new JTextField(String.valueOf(tempBill.getDate().get(Calendar.MONTH)+1));
		dayTextField = new JTextField(String.valueOf(tempBill.getDate().get(Calendar.DAY_OF_MONTH)));
		
		JButton buttonGoBack = new JButton("Go Back");
		JButton buttonEdit = new JButton("Edit");
		
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(6,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(yearLabel);
		add(yearTextField);
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
	        if(action.contentEquals("Add One Time Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	GregorianCalendar date = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText()));
	        	frame.getListCollection().getListOneTime().add(new OneTimeBill(name, amount, date));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals("Go Back")) {
	        	frame.changeToSelect(2);
	        }
	        else if(action.contentEquals("Edit")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	GregorianCalendar date = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText()));
	        	frame.getListCollection().getListOneTime().get(selection).edit(name, amount, date);
	        	frame.changeToAdd();
	        }
	    }
	}
}
