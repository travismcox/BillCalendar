/**
 * 
 */
package gui.transactions;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import gui.GUIMain;
import main.Utility;
import main.transactions.LimitedMonthlyTransaction;

/**
 * @author traviscox
 *
 */
public class GUILimitedBill extends GUITransaction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6917256282447426216L;

	public GUILimitedBill(GUIMain frame, int transactionType) {
		super(frame, transactionType);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex, Utility.EmptyField, Utility.InitialIndex, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}
	
	private void addComponentsNew() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackAdd, buttonEnter);
	}

	private void addComponents() {
		this.addComponentsStart(7, 2);
		this.addComponentsLabelAndField(recurringDateLabel, recurringDateComboBox);
		this.addComponentsLabelAndField(yearLabel, yearTextField);
		this.addComponentsLabelAndField(monthLabel, monthsComboBox);
		this.addComponentsLabelAndField(endDateLabel, endDateComboBox);
	}

	private void initializeLabelsAndFields(String nameField, String amountField, Integer recurringDateIndex, String yearField, Integer endMonthIndex, Integer endDateIndex) {
		this.initializeNameAndAmount(nameField, amountField);
		this.initializeRecurringDate(recurringDateIndex);
		this.initializeYear(yearField);
		this.initializeMonth(endMonthIndex);
		this.initializeEndDate(endDateIndex);
	}

	public GUILimitedBill(GUIMain frame, int selection, int transactionType) {
		super(frame, selection, transactionType);
		LimitedMonthlyTransaction tempBill = listCollection.getListLimited().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), tempBill.getRecurringDate()-1, Integer.toString(tempBill.getEndDate().getYear()), tempBill.getEndDate().getMonthValue(), tempBill.getEndDate().getDayOfMonth()-1);
		initializeButtonsEdit(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsEdit();
	}

	private void addComponentsEdit() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackSelect, buttonEdit);
	}

	public class AddBillActionListener extends GUITransaction.AddBillActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	listCollection.getListLimited().add(new LimitedMonthlyTransaction(name, amount, recurringDate, endDate));
	        	frame.changeToAddTransaction(transactionType);
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.LimitedBillValue, transactionType);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAddTransaction(transactionType);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	listCollection.getListLimited().get(selection).edit(name, amount, recurringDate, endDate);
	        	frame.changeToSelect(Utility.LimitedBillValue, transactionType);
	        }
	    }
	}
	
	private void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	recurringDate = recurringDateComboBox.getSelectedIndex()+1;
    	endDate = LocalDate.of(Integer.parseInt(yearTextField.getText()), monthsComboBox.getSelectedIndex()+1, endDateComboBox.getSelectedIndex()+1);
    	
	}
}
