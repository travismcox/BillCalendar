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

import gui.GUIOneTimeBill.AddBillActionListener;
import main.AnnualBill;
import main.OneTimeBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIAnnualBill extends GUITransaction {

	public GUIAnnualBill(GUIMain frame) {
		super(frame);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField, Utility.InitialIndex, Utility.InitialIndex);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
		
	}
	
	public GUIAnnualBill(GUIMain frame, int selection) {
		super(frame, selection);
		AnnualBill tempBill = frame.listCollection.getListAnnual().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), tempBill.getMonth(), tempBill.getDay());
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
    	month = monthsComboBox.getSelectedIndex();
    	recurringDate = recurringDateComboBox.getSelectedIndex() + 1;
	}
	
	protected class AddBillActionListener extends GUITransaction.AddBillActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListAnnual().add(new AnnualBill(name, amount, month, recurringDate));
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
	        	frame.getListCollection().getListAnnual().get(selection).edit(name, amount, month, recurringDate);
	        	frame.changeToSelect(Utility.OneTimeBillValue);
	        }
		}
	}
}