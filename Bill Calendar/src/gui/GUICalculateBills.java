/**
 * 
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.transactions.GUIWeeklyBill.AddBillActionListener;
import main.CalculateWeeks;
import main.transactions.WeeklyTransaction;

/**
 * @author traviscox
 *
 */
public class GUICalculateBills extends JPanel {
	GUIMain frame;
	JTextField calculateTextField;
	public GUICalculateBills(GUIMain frame) {
		this.frame = frame;
		
		JLabel calculateLabel = new JLabel("How many weeks to Calculate");
		
		calculateTextField = new JTextField();
		
		JButton buttonCalculate = new JButton("Calculate");
		
		buttonCalculate.addActionListener(new AddBillActionListener());
		
		setLayout(new GridLayout(2,2));
		add(calculateLabel);
		add(calculateTextField);
		add(buttonCalculate);
		
	}
	
	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals("Calculate")) {
	        	Integer weeks = Integer.parseInt(calculateTextField.getText());
	        	//CalculateWeeks.startCalculateWeeks(frame.getListCollection(), weeks);
	        	frame.printResults(CalculateWeeks.startCalculateWeeks(frame.getListCollection(), weeks));
	        }
	    }
	}
}
