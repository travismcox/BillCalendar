/**
 * 
 */
package gui.transactions;

import java.awt.event.ActionEvent;

import gui.GUIMain;
import main.Utility;
import main.transactions.AnnualTransaction;

/**
 * @author traviscox
 *
 */
public class GUIAnnualBill extends GUITransaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6998344743527896901L;

	public GUIAnnualBill(GUIMain frame, int transactionType) {
		super(frame, transactionType);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
		
	}
	
	public GUIAnnualBill(GUIMain frame, int selection, int transactionType) {
		super(frame, selection, transactionType);
		AnnualTransaction tempBill = listCollection.getListAnnual().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), tempBill.getRecurringMonth(), tempBill.getRecurringDate());
		initializeButtonsEdit(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsEdit();	
	}
	
	private void initializeLabelsAndFields(String nameField, String amountField, Integer monthIndex, Integer dayIndex) {
		initializeNameAndAmount(nameField, amountField);
		initializeMonth(monthIndex);
		initializeRecurringDate(dayIndex);
	}
	
	private void addComponents() {
		addComponentsStart(5, 2);
		addComponentsLabelAndField(monthLabel, monthsComboBox);
		addComponentsLabelAndField(recurringDateLabel, recurringDateComboBox);
	}

	private void addComponentsEdit() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackSelect, buttonEdit);
	}

	private void addComponentsNew() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackAdd, buttonEnter);
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	month = monthsComboBox.getSelectedIndex()+1;
    	recurringDate = recurringDateComboBox.getSelectedIndex()+1;
	}
	
	protected class AddBillActionListener extends GUITransaction.AddBillActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	listCollection.getListAnnual().add(new AnnualTransaction(name, amount, month, recurringDate));
	        	frame.changeToAddTransaction(transactionType);
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.OneTimeBillValue, transactionType);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAddTransaction(transactionType);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	listCollection.getListAnnual().get(selection).edit(name, amount, month, recurringDate);
	        	frame.changeToSelect(Utility.OneTimeBillValue, transactionType);
	        }
		}
	}
}
