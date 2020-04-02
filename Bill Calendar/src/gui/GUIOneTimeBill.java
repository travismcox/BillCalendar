/**
 * 
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.GUIMonthlyBill.AddBillActionListener;
import main.MonthlyBill;
import main.OneTimeBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIOneTimeBill extends GUITransaction {
	
	public GUIOneTimeBill(GUIMain frame) {
		super(frame);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}
	
	public GUIOneTimeBill(GUIMain frame, int selection) {
		super(frame, selection);
		OneTimeBill tempBill = frame.listCollection.getListOneTime().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), String.valueOf(tempBill.getDate().get(Calendar.YEAR)), tempBill.getDate().get(Calendar.MONTH), tempBill.getDate().get(Calendar.DAY_OF_MONTH)-1);
		initializeButtonsEdit(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsEdit();
	}

	private void addComponentsNew() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackAdd, buttonEnter);
	}

	private void initializeLabelsAndFields(String nameField, String amountField, String yearField, Integer monthIndex, Integer endDateIndex) {
		initializeNameAndAmount(nameField, amountField);
		initializeYear(yearField);
		initializeMonth(monthIndex);
		initializeEndDate(endDateIndex);
	}

	private void addComponentsEdit() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackSelect, buttonEdit);
	}

	private void addComponents() {
		addComponentsStart(6, 2);
		addComponentsLabelAndField(yearLabel, yearTextField);
		addComponentsLabelAndField(monthLabel, monthsComboBox);
		addComponentsLabelAndField(endDateLabel, endDateComboBox);
	}

	protected class AddBillActionListener extends GUITransaction.AddBillActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListOneTime().add(new OneTimeBill(name, amount, endDate));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.OneTimeBillValue);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListOneTime().get(selection).edit(name, amount, endDate);
	        	frame.changeToSelect(Utility.OneTimeBillValue);
	        }
	    }
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	endDate = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), monthsComboBox.getSelectedIndex(), endDateComboBox.getSelectedIndex()+1);
	}
}
