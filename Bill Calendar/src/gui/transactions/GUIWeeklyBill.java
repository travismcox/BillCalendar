/**
 * 
 */
package gui.transactions;

import java.awt.event.ActionEvent;

import gui.GUIMain;
import main.Utility;
import main.transactions.WeeklyTransaction;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyBill extends GUITransaction {

	public GUIWeeklyBill(GUIMain frame, int transactionType) {
		super(frame, transactionType);
		
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

	public GUIWeeklyBill(GUIMain frame, int selection, int transactionType) {
		super(frame, selection, transactionType);
		WeeklyTransaction tempBill = listCollection.getListWeekly().get(selection);
		
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
	        	listCollection.getListWeekly().add(new WeeklyTransaction(name, amount));
	        	frame.changeToAddTransaction(transactionType);
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.WeeklyBillValue, transactionType);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAddTransaction(transactionType);
	        }
	        if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	listCollection.getListWeekly().get(selection).edit(name, amount);
	        	frame.changeToSelect(Utility.WeeklyBillValue, transactionType);
	        }
	    }
	}

	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
	}
}
