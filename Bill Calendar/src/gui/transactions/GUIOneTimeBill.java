/**
 * 
 */
package gui.transactions;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import gui.GUIMain;
import main.Utility;
import main.transactions.OneTimeTransaction;

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
		OneTimeTransaction tempBill = frame.getListCollection().getListOneTimeBill().get(selection);
		
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
	        	frame.getListCollection().getListOneTimeBill().add(new OneTimeTransaction(name, amount, endDate));
	        	frame.changeToAddBill();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.OneTimeBillValue);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAddBill();
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListOneTimeBill().get(selection).edit(name, amount, endDate);
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
