/**
 * 
 */
package gui.transactions;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.GUIMain;
import gui.transactions.GUIMonthlyBill.AddBillActionListener;
import main.Utility;
import main.transactions.AnnualBill;

/**
 * @author traviscox
 *
 */
public abstract class GUITransaction extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField, yearTextField;
	JComboBox<String> recurringDateComboBox, monthsComboBox, endDateComboBox;
	JLabel nameLabel, amountLabel, recurringDateLabel, monthLabel, yearLabel, endDateLabel;
	JButton buttonEnter, buttonGoBackAdd, buttonGoBackSelect, buttonEdit;
	String name;
	Double amount;
	Integer recurringDate, month;
	GregorianCalendar endDate;
	int selection;
	
	public GUITransaction(GUIMain frame) {
		this.frame = frame;
	}
	
	public GUITransaction(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
	}
	
	private void initializeNameLabel() {
		nameLabel = new JLabel(Utility.Name);
	}
	private void initializeNameField(String data) {
		nameTextField = new JTextField(data);
	}
	private void initializeAmountLabel() {
		amountLabel = new JLabel(Utility.Amount);
	}
	private void initializeAmountField(String data) {
		amountTextField = new JTextField(data);
	}
	private void initializeRecurringDateLabel() {
		recurringDateLabel = new JLabel(Utility.RecurringDate);
	}
	private void initializeRecurringDateField(Integer index) {
		recurringDateComboBox = new JComboBox<String>(Utility.Days);
		recurringDateComboBox.setSelectedIndex(index);
	}
	private void initializeMonthLabel() {
		monthLabel = new JLabel(Utility.Month);
	}
	private void initializeMonthField(Integer index) {
		monthsComboBox = new JComboBox<String>(Utility.Months);
		monthsComboBox.setSelectedIndex(index);
	}
	private void initalizeYearLabel() {
		yearLabel = new JLabel(Utility.Year);
	}
	private void initializeYearField(String yearData) {
		yearTextField = new JTextField(yearData);
	}
	private void initializeEndDateLabel() {
		endDateLabel = new JLabel(Utility.RecurringDate);
	}
	private void initializeEndDateField(Integer index) {
		endDateComboBox = new JComboBox<String>(Utility.Days);
		endDateComboBox.setSelectedIndex(index);
	}
	private void initializeButtonGoBackSelect(AddBillActionListener listener) {
		buttonGoBackSelect = new JButton(Utility.GoBackSelect);
		buttonGoBackSelect.addActionListener(listener);
	}
	private void initializeButtonGoBackAdd(AddBillActionListener listener) {
		buttonGoBackAdd = new JButton(Utility.GoBackAdd);
		buttonGoBackAdd.addActionListener(listener);
	}
	private void initializeButtonEdit(AddBillActionListener listener) {
		buttonEdit = new JButton(Utility.Edit);
		buttonEdit.addActionListener(listener);
	}
	private void initializeButtonAdd(AddBillActionListener listener) {
		buttonEnter = new JButton(Utility.AddBill);
		buttonEnter.addActionListener(listener);
	}
	protected void initializeButtonsEdit(AddBillActionListener listener1, AddBillActionListener listener2) {
		initializeButtonGoBackSelect(listener1);
		initializeButtonEdit(listener2);
	}
	protected void initializeButtonsNew(AddBillActionListener listener1, AddBillActionListener listener2) {
		initializeButtonGoBackAdd(listener1);
		initializeButtonAdd(listener2);
	}
	protected void initializeNameAndAmount(String nameData, String amountData) {
		initializeNameLabel();
		initializeNameField(nameData);
		initializeAmountLabel();
		initializeAmountField(amountData);
	}
	protected void initializeRecurringDate(Integer index) {
		initializeRecurringDateLabel();
		initializeRecurringDateField(index);
	}
	protected void initializeMonth(Integer index) {
		initializeMonthLabel();
		initializeMonthField(index);
	}
	protected void initializeYear(String yearData) {
		initalizeYearLabel();
		initializeYearField(yearData);
	}
	protected void initializeEndDate(Integer index) {
		initializeEndDateLabel();
		initializeEndDateField(index);
	}
	protected void addComponentsStart(Integer rows, Integer columns) {
		setLayout(new GridLayout(rows, columns));
		addComponentsLabelAndField(nameLabel, nameTextField);
		addComponentsLabelAndField(amountLabel, amountTextField);
		add(recurringDateLabel);
		add(recurringDateComboBox);
	}
	protected void addComponentsLabelAndField(Component component1, Component component2) {
		add(component1);
		add(component2);
	}
	
	protected abstract class AddBillActionListener implements ActionListener{};
}
