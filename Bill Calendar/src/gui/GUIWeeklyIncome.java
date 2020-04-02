/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;

import gui.GUIWeeklyBill.AddBillActionListener;
import main.Utility;
import main.WeeklyBill;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyIncome extends GUITransaction {

	/**
	 * @param frame
	 */
	public GUIWeeklyIncome(GUIMain frame) {
		super(frame);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}

	/**
	 * @param frame
	 * @param selection
	 */
	public GUIWeeklyIncome(GUIMain frame, int selection) {
		super(frame, selection);
		WeeklyBill tempBill = frame.listCollection.getListWeekly().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()));
		initializeButtonsEdit(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsEdit();
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
	
	private void addComponentsEdit() {
		addComponents();
		addComponentsLabelAndField(buttonGoBackSelect, buttonEdit);
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
	}

	protected class AddBillActionListener extends GUITransaction.AddBillActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListWeekly().add(new WeeklyBill(name, amount));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.WeeklyBillValue);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAdd();
	        }
	        if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListWeekly().get(selection).edit(name, amount);
	        	frame.changeToSelect(Utility.WeeklyBillValue);
	        }
	    }
	}
}