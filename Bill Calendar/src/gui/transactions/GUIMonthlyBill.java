/**
 * 
 */
package gui.transactions;

import java.awt.event.ActionEvent;

import gui.GUIMain;
import main.Utility;
import main.transactions.MonthlyTransaction;

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
		MonthlyTransaction tempBill = frame.getListCollection().getListMonthlyBill().get(selection);
		
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
	        	frame.getListCollection().getListMonthlyBill().add(new MonthlyTransaction(name, amount, recurringDate));
	        	frame.changeToAddBill();
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAddBill();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)){
	        	frame.changeToSelect(Utility.MonthlyBillValue);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListMonthlyBill().get(selection).edit(name, amount, recurringDate);
	        	frame.changeToAddBill();
	        }
	    }
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	recurringDate = recurringDateComboBox.getSelectedIndex() + 1;
	}
}
