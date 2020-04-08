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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1271944058884453767L;

	public GUIOneTimeBill(GUIMain frame, int transactionType) {
		super(frame, transactionType);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}
	
	public GUIOneTimeBill(GUIMain frame, int selection, int transactionType) {
		super(frame, selection, transactionType);
		OneTimeTransaction tempBill = listCollection.getListOneTime().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), String.valueOf(tempBill.getEndDate().get(Calendar.YEAR)), tempBill.getEndDate().get(Calendar.MONTH), tempBill.getEndDate().get(Calendar.DAY_OF_MONTH)-1);
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
	        	listCollection.getListOneTime().add(new OneTimeTransaction(name, amount, endDate));
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
	        	listCollection.getListOneTime().get(selection).edit(name, amount, endDate);
	        	frame.changeToSelect(Utility.OneTimeBillValue, transactionType);
	        }
	    }
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	endDate = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), monthsComboBox.getSelectedIndex(), endDateComboBox.getSelectedIndex()+1);
	}
}
