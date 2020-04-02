/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MonthlyBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIMonthlyBill extends GUITransaction {

	public GUIMonthlyBill(GUIMain frame) {
		super(frame);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}

	public GUIMonthlyBill(GUIMain frame, int selection) {
		super(frame, selection);
		MonthlyBill tempBill = frame.listCollection.getListMonthly().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), tempBill.getDate());
		initializeButtonsEdit(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsEdit();
	}

	private void initializeLabelsAndFields(String nameField, String amountField, Integer index) {
		initializeNameAndAmount(nameField, amountField);
		initializeRecurringDate(index);
	}
	
	private void addComponents() {
		addComponentsStart(4,2);
		addComponentsLabelAndField(recurringDateLabel, recurringDateComboBox);
	}
	
	private void addComponentsNew() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackAdd, buttonEnter);
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
	        	frame.getListCollection().getListMonthly().add(new MonthlyBill(name, amount, recurringDate));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)){
	        	frame.changeToSelect(Utility.MonthlyBillValue);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListMonthly().get(selection).edit(name, amount, recurringDate);
	        	frame.changeToAdd();
	        }
	    }
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	recurringDate = recurringDateComboBox.getSelectedIndex() + 1;
	}
}
