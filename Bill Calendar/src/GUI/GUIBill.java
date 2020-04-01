/**
 * 
 */
package GUI;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.GUIMonthlyBill.AddBillActionListener;
import main.Utility;

/**
 * @author traviscox
 *
 */
public abstract class GUIBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	JComboBox<String> recurringDateComboBox;
	JLabel nameLabel, amountLabel, recurringDateLabel;
	JButton buttonEnter, buttonGoBackAdd, buttonGoBackSelect, buttonEdit;
	String name;
	Double amount;
	Integer date;
	int selection;
	
	public GUIBill(GUIMain frame) {
		this.frame = frame;
	}
	
	public GUIBill(GUIMain frame, int selection) {
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
}
