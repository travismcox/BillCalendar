/**
 * 
 */
package gui.transactions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.GUIMain;
import gui.transactions.GUIMonthlyBill.AddBillActionListener;
import main.Utility;
import main.transactions.MonthlyTransaction;
import main.transactions.WeeklyTransaction;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyBill extends GUITransaction {

	public GUIWeeklyBill(GUIMain frame) {
		super(frame);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}

	private void initializeLabelsAndFields(String nameField, String amountField) {
		initializeLabelsAndFields(nameField, amountField);
	}

	private void addComponentsNew() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackAdd, buttonEnter);
	}

	private void addComponents() {
		addComponentsStart(3, 2);
	}

	public GUIWeeklyBill(GUIMain frame, int selection) {
		super(frame, selection);
		WeeklyTransaction tempBill = frame.getListCollection().getListWeeklyBill().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()));
		initializeButtonsEdit(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsEdit();
	}

	private void addComponentsEdit() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackSelect, buttonEdit);
	}
	
	protected class AddBillActionListener extends GUITransaction.AddBillActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListWeeklyBill().add(new WeeklyTransaction(name, amount));
	        	frame.changeToAddBill();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.WeeklyBillValue);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAddBill();
	        }
	        if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListWeeklyBill().get(selection).edit(name, amount);
	        	frame.changeToSelect(Utility.WeeklyBillValue);
	        }
	    }
	}

	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
	}
}
