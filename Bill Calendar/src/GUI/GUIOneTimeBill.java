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
import main.MonthlyBill;
import main.OneTimeBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIOneTimeBill extends JPanel {
	GUIMain frame;
	JTextField nameTextField, amountTextField, yearTextField;
	JComboBox<String> monthsComboBox, daysComboBox;
	JLabel nameLabel, amountLabel, yearLabel, monthLabel, dayLabel;
	JButton buttonEnter, buttonGoBack, buttonEdit;
	String name;
	Double amount;
	GregorianCalendar date;
	private int selection;
	public GUIOneTimeBill(GUIMain frame) {
		this.frame = frame;
		
		initializeLabels();
		initializeFields();
		initializeButtonsNew();
		
		addComponentsNew();
	}
	
	public GUIOneTimeBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		OneTimeBill tempBill = frame.listCollection.getListOneTime().get(selection);
		
		initializeLabels();
		initializeFields();
		setFields(tempBill);
		initializeButtonsEdit();
		
		addComponentsEdit();
	}
	
	private void initializeButtonsNew() {
		buttonEnter = new JButton(Utility.AddBill);
		buttonEnter.addActionListener(new AddBillActionListener());
	}

	private void initializeFields() {
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		yearTextField = new JTextField();
		monthsComboBox = new JComboBox<String>(Utility.Months);
		daysComboBox = new JComboBox<String>(Utility.Days);
	}

	private void addComponentsNew() {
		addComponents();
		add(buttonEnter);
	}

	private void initializeLabels() {
		nameLabel = new JLabel(Utility.Name);
		amountLabel = new JLabel(Utility.Amount);
		yearLabel = new JLabel(Utility.Year);
		monthLabel = new JLabel(Utility.Month);
		dayLabel = new JLabel(Utility.Day);
	}

	private void setFields(OneTimeBill tempBill) {
		nameTextField.setText(tempBill.getName());
		amountTextField.setText(tempBill.getAmount().toString());
		yearTextField.setText(String.valueOf(tempBill.getDate().get(Calendar.YEAR)));
		monthsComboBox.setSelectedIndex(tempBill.getDate().get(Calendar.MONTH));
		daysComboBox.setSelectedIndex(tempBill.getDate().get(Calendar.DAY_OF_MONTH)-1);
		
	}

	private void initializeButtonsEdit() {
		buttonGoBack = new JButton(Utility.GoBack);
		buttonEdit = new JButton(Utility.Edit);
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
	}

	private void addComponentsEdit() {
		addComponents();
		add(buttonGoBack);
		add(buttonEdit);
	}

	private void addComponents() {
		setLayout(new GridLayout(6,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(yearLabel);
		add(yearTextField);
		add(monthLabel);
		add(monthsComboBox);
		add(dayLabel);
		add(daysComboBox);
	}

	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListOneTime().add(new OneTimeBill(name, amount, date));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBack)) {
	        	frame.changeToSelect(Utility.OneTimeBill);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListOneTime().get(selection).edit(name, amount, date);
	        	frame.changeToSelect(Utility.OneTimeBill);
	        }
	    }
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	date = new GregorianCalendar(Integer.parseInt(yearTextField.getText()), monthsComboBox.getSelectedIndex(), daysComboBox.getSelectedIndex()+1);
	}
}
