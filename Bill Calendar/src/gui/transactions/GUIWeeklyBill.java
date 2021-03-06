/**
 * 
 */
package gui.transactions;

import java.awt.event.ActionEvent;
import java.time.DayOfWeek;

import gui.GUIMain;
import main.Utility;
import main.transactions.WeeklyTransaction;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyBill extends GUITransaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5968819062882307497L;

	public GUIWeeklyBill(GUIMain frame, int transactionType) {
		super(frame, transactionType);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}

	private void initializeLabelsAndFields(String nameField, String amountField, Integer dayOfWeekIndex) {
		initializeNameAndAmount(nameField, amountField);
		initializeDayOfWeek(dayOfWeekIndex);
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
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), tempBill.getDayOfWeek().getValue()-1);
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
	        	listCollection.getListWeekly().add(new WeeklyTransaction(name, amount, dayOfWeek));
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
	        	listCollection.getListWeekly().get(selection).edit(name, amount, dayOfWeek);
	        	frame.changeToSelect(Utility.WeeklyBillValue, transactionType);
	        }
	    }
	}

	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	dayOfWeek = DayOfWeek.of(dayOfWeekComboBox.getSelectedIndex()+1);
	}
}
