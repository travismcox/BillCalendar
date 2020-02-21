/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.GUIMonthlyBill.AddBillActionListener;
import main.LimitedMonthlyBill;
import main.MonthlyBill;

/**
 * @author traviscox
 *
 */
public class GUILimitedBill {
	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField, yearTextField, monthTextField, dayTextField;
	public GUILimitedBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		JPanel panelAddBill = new JPanel();
		
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
		
		panelAddBill.setLayout(new GridLayout(7,2));
		panelAddBill.add(nameLabel);
		panelAddBill.add(nameTextField);
		panelAddBill.add(amountLabel);
		panelAddBill.add(amountTextField);
		panelAddBill.add(dateLabel);
		panelAddBill.add(dateTextField);
		panelAddBill.add(yearLabel);
		panelAddBill.add(yearTextField);
		panelAddBill.add(monthLabel);
		panelAddBill.add(monthTextField);
		panelAddBill.add(dayLabel);
		panelAddBill.add(dayTextField);
		panelAddBill.add(buttonEnter);
		
		frame.setSize(700, 300);
		frame.getContentPane().add(panelAddBill);
		frame.setVisible(true);
		
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
	        	new GUIAddBill(frame);
	        }
	    }
	}
}
