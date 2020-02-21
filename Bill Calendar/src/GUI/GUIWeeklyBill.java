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
public class GUIWeeklyBill {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	public GUIWeeklyBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		JPanel panelAddBill = new JPanel();
		
		JLabel nameLabel = new JLabel("Name");
		JLabel amountLabel = new JLabel("Amount");
		//JLabel dateLabel = new JLabel("Recurring Date");
		
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		//dateTextField = new JTextField();
		
		JButton buttonEnter = new JButton("Add Monthly Bill");
		
		//buttonMonthly.addActionListener(new GUIMain().new AddBillActionListener());
		//buttonWeekly.addActionListener(new GUIMain().new AddBillActionListener());
		//buttonOneTime.addActionListener(new GUIMain().new AddBillActionListener());
		buttonEnter.addActionListener(new AddBillActionListener());
		
		panelAddBill.setLayout(new GridLayout(3,2));
		panelAddBill.add(nameLabel);
		panelAddBill.add(nameTextField);
		panelAddBill.add(amountLabel);
		panelAddBill.add(amountTextField);
		//panelAddBill.add(dateLabel);
		//panelAddBill.add(dateTextField);
		panelAddBill.add(buttonEnter);
		
		frame.setSize(500, 300);
		frame.getContentPane().add(panelAddBill);
		frame.setVisible(true);
		
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Add Monthly Bill")) {
	        	String name = nameTextField.getText();
	        	Double amount = Double.parseDouble(amountTextField.getText());
	        	//Integer date = Integer.parseInt(dateTextField.getText());
	        	frame.getListCollection().getListWeekly().add(new WeeklyBill(name, amount));
	        	new GUIAddBill(frame);
	        }
	    }
	}

}
