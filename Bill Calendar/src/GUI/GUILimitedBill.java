/**
 * 
 */
package GUI;

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

import GUI.GUIMonthlyBill.AddBillActionListener;
import main.LimitedMonthlyBill;
import main.MonthlyBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUILimitedBill extends JPanel {
	GUIMain frame;
	JTextField nameTextField, amountTextField, yearTextField;
	JComboBox<String> dateComboBox, monthsComboBox, daysComboBox;
	JLabel nameLabel, amountLabel, dateLabel, yearLabel, monthLabel, dayLabel;
	JButton buttonEnter, buttonGoBack, buttonEdit;
	String name;
	Double amount;
	Integer recurringDate;
	GregorianCalendar endDate;
	private int selection;
	public GUILimitedBill(GUIMain frame) {
		this.frame = frame;
		
		initializeLabels();
		initializeFields();
		initializeButtonsNew();
		
		addComponentsNew();
	}
	
	private void addComponentsNew() {
		addComponents();
		add(buttonEnter);
	}

	private void addComponents() {
		setLayout(new GridLayout(7,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(dateLabel);
		add(dateComboBox);
		add(yearLabel);
		add(yearTextField);
		add(monthLabel);
		add(monthsComboBox);
		add(dayLabel);
		add(daysComboBox);
	}

	private void initializeButtonsNew() {
		buttonEnter = new JButton(Utility.AddBill);
		buttonEnter.addActionListener(new AddBillActionListener());
	}

	private void initializeFields() {
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		dateComboBox = new JComboBox<String>(Utility.Days);
		yearTextField = new JTextField();
		monthsComboBox = new JComboBox<String>(Utility.Months);
		daysComboBox = new JComboBox<String>(Utility.Days);
	}

	private void initializeLabels() {
		nameLabel = new JLabel(Utility.Name);
		amountLabel = new JLabel(Utility.Amount);
		dateLabel = new JLabel(Utility.RecurringDate);
		yearLabel = new JLabel(Utility.Year);
		monthLabel = new JLabel(Utility.Month);
		dayLabel = new JLabel(Utility.Day);
	}

	public GUILimitedBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		LimitedMonthlyBill tempBill = frame.listCollection.getListLimited().get(selection);
		
		initializeLabels();
		initializeFields();
		setFields(tempBill);
		initializeButtonsEdit();
		
		addComponentsEdit();
	}
	
	private void initializeButtonsEdit() {
		buttonGoBack = new JButton(Utility.GoBack);
		buttonEdit = new JButton(Utility.Edit);
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
	}

	private void setFields(LimitedMonthlyBill tempBill) {
		nameTextField.setText(tempBill.getName());
		amountTextField.setText(tempBill.getAmount().toString());
		dateComboBox.setSelectedIndex(tempBill.getDate()-1);
		yearTextField.setText(String.valueOf(tempBill.getEndDate().get(Calendar.YEAR)));
		monthsComboBox.setSelectedIndex(tempBill.getEndDate().get(Calendar.MONTH));
		daysComboBox.setSelectedIndex(tempBill.getEndDate().get(Calendar.DAY_OF_MONTH)-1);
	}

	private void addComponentsEdit() {
		addComponents();
		add(buttonGoBack);
		add(buttonEdit);
	}

	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListLimited().add(new LimitedMonthlyBill(name, amount, recurringDate, endDate));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBack)) {
	        	frame.changeToSelect(Utility.LimitedBill);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListLimited().get(selection).edit(name, amount, recurringDate, endDate);
	        	frame.changeToSelect(Utility.LimitedBill);
	        }
	    }
	}
	
	private void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	recurringDate = dateComboBox.getSelectedIndex();
    	endDate = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), monthsComboBox.getSelectedIndex(), daysComboBox.getSelectedIndex()+1);
    	
	}
}
