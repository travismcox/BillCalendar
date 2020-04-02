/**
 * 
 */
package gui.transactions;

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

import gui.GUIMain;
import gui.transactions.GUIMonthlyBill.AddBillActionListener;
import main.Utility;
import main.transactions.LimitedMonthlyTransaction;
import main.transactions.MonthlyTransaction;

/**
 * @author traviscox
 *
 */
public class GUILimitedBill extends GUITransaction {
	
	public GUILimitedBill(GUIMain frame) {
		super(frame);
		
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

	public GUILimitedBill(GUIMain frame, int selection) {
		super(frame, selection);
		LimitedMonthlyTransaction tempBill = frame.listCollection.getListLimited().get(selection);
		
		initializeLabelsAndFields(tempBill.getName(), String.valueOf(tempBill.getAmount()), tempBill.getDate()-1, Integer.toString(tempBill.getEndDate().get(Calendar.YEAR)), tempBill.getEndDate().get(Calendar.MONTH), tempBill.getEndDate().get(Calendar.DAY_OF_MONTH)-1);
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
	        	frame.getListCollection().getListLimited().add(new LimitedMonthlyTransaction(name, amount, recurringDate, endDate));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBackSelect)) {
	        	frame.changeToSelect(Utility.LimitedBillValue);
	        }
	        else if(action.contentEquals(Utility.GoBackAdd)) {
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListLimited().get(selection).edit(name, amount, recurringDate, endDate);
	        	frame.changeToSelect(Utility.LimitedBillValue);
	        }
	    }
	}
	
	private void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	recurringDate = recurringDateComboBox.getSelectedIndex();
    	endDate = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), monthsComboBox.getSelectedIndex(), recurringDateComboBox.getSelectedIndex()+1);
    	
	}
}
