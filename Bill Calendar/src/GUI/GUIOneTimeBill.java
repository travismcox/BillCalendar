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
import main.MonthlyBill;
import main.OneTimeBill;

/**
 * @author traviscox
 *
 */
public class GUIOneTimeBill {
	GUIMain frame;
	JTextField nameTextField, amountTextField, yearTextField, monthTextField, dayTextField;
	public GUIOneTimeBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		JPanel panelAddBill = new JPanel();
		
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
		
		JButton buttonEnter = new JButton("Add Monthly Bill");
		
		//buttonMonthly.addActionListener(new GUIMain().new AddBillActionListener());
		//buttonWeekly.addActionListener(new GUIMain().new AddBillActionListener());
		//buttonOneTime.addActionListener(new GUIMain().new AddBillActionListener());
		buttonEnter.addActionListener(new AddBillActionListener());
		
		panelAddBill.setLayout(new GridLayout(6,2));
		panelAddBill.add(nameLabel);
		panelAddBill.add(nameTextField);
		panelAddBill.add(amountLabel);
		panelAddBill.add(amountTextField);
		panelAddBill.add(yearLabel);
		panelAddBill.add(yearTextField);
		panelAddBill.add(monthLabel);
		panelAddBill.add(monthTextField);
		panelAddBill.add(dayLabel);
		panelAddBill.add(dayTextField);
		panelAddBill.add(buttonEnter);
		
		frame.setSize(600, 300);
		frame.getContentPane().add(panelAddBill);
		frame.setVisible(true);
		
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Add Monthly Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	Integer year = Integer.parseInt(yearTextField.getText());
	        	Integer month = Integer.parseInt(monthTextField.getText());
	        	Integer day = Integer.parseInt(dayTextField.getText());
	        	GregorianCalendar date = new GregorianCalendar(year, month, day);
	        	frame.getListCollection().getListOneTime().add(new OneTimeBill(name, amount, date));
	        	new GUIAddBill(frame);
	        }
	    }
	}
}
