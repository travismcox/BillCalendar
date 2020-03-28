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
import main.LimitedMonthlyBill;
import main.MonthlyBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUILimitedBill extends JPanel {
	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField, yearTextField, monthTextField, dayTextField;
	private int selection;
	public GUILimitedBill(GUIMain frame) {
		this.frame = frame;
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel dateLabel = new JLabel("Recurring Date");
		JLabel yearLabel = new JLabel("YYYY");
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		dateTextField = new JTextField();
		yearTextField = new JTextField();
		monthTextField = new JTextField();
		dayTextField = new JTextField();
		
		JButton buttonEnter = new JButton("Add Monthly Bill");
		
		buttonEnter.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(7,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(dateLabel);
		add(dateTextField);
		add(yearLabel);
		add(yearTextField);
		add(monthLabel);
		add(monthTextField);
		add(dayLabel);
		add(dayTextField);
		add(buttonEnter);
		
	}
	
	public GUILimitedBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		LimitedMonthlyBill tempBill = frame.listCollection.getListLimited().get(selection);
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		JLabel dateLabel = new JLabel("Recurring Date");
		JLabel yearLabel = new JLabel("YYYY");
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		
		nameTextField = new JTextField(tempBill.getName());
		amountTextField = new JTextField(tempBill.getAmount().toString());
		dateTextField = new JTextField(String.valueOf(tempBill.getDate()));
		yearTextField = new JTextField(String.valueOf(tempBill.getEndDate().get(Calendar.YEAR)));
		monthTextField = new JTextField(String.valueOf(tempBill.getEndDate().get(Calendar.MONTH)+1));
		dayTextField = new JTextField(String.valueOf(tempBill.getEndDate().get(Calendar.DAY_OF_MONTH)));
		
		JButton buttonGoBack = new JButton("Go Back");
		JButton buttonEdit = new JButton("Edit");
		
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(7,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(dateLabel);
		add(dateTextField);
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
	        if(action.contentEquals("Add Monthly Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer recurringDate = Integer.parseInt(dateTextField.getText());
	        	GregorianCalendar endDate = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText()));
	        	frame.getListCollection().getListLimited().add(new LimitedMonthlyBill(name, amount, recurringDate, endDate));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals("Go Back")) {
	        	frame.changeToSelect(Utility.LimitedBill);
	        }
	        else if(action.contentEquals("Edit")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer recurringDate = Integer.parseInt(dateTextField.getText());
	        	GregorianCalendar endDate = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText()));
	        	frame.getListCollection().getListLimited().get(selection).edit(name, amount, recurringDate, endDate);
	        	frame.changeToAdd();
	        }
	    }
	}
}
