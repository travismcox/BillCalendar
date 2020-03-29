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

import GUI.GUIOneTimeBill.AddBillActionListener;
import main.AnnualBill;
import main.OneTimeBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIAnnualBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField;
	JComboBox<String> monthsComboBox, daysComboBox;
	JLabel nameLabel, amountLabel, monthLabel, dayLabel;
	JButton buttonGoBack, buttonEdit, buttonEnter;
	String name;
	Double amount;
	Integer month, day;
	private int selection;
	public GUIAnnualBill(GUIMain frame) {
		this.frame = frame;
		
		initializeLabels();
		initializeFields();
		initializeButtonsNew();
		
		addComponentsNew();
		
	}
	
	private void initializeFields() {
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		monthsComboBox = new JComboBox<String>(Utility.Months);
		daysComboBox = new JComboBox<String>(Utility.Days);
	}

	private void addComponentsNew() {
		addComponents();
		add(buttonEnter);
	}

	private void initializeButtonsNew() {
		buttonEnter = new JButton(Utility.AddBill);
		buttonEnter.addActionListener(new AddBillActionListener());
	}

	public GUIAnnualBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		AnnualBill tempBill = frame.listCollection.getListAnnual().get(selection);
		
		initializeLabels();
		initializeFields();
		setFields(tempBill);
		initializeButtonsEdit();
		
		addComponentsEdit();	
	}
	
	private void addComponentsEdit() {
		addComponents();
		add(buttonGoBack);
		add(buttonEdit);
	}

	private void setFields(AnnualBill tempBill) {
		nameTextField.setText(tempBill.getName());
		amountTextField.setText(tempBill.getAmount().toString());
		monthsComboBox.setSelectedIndex(tempBill.getMonth());
		daysComboBox.setSelectedIndex(tempBill.getDay());
	}

	private void initializeButtonsEdit() {
		buttonGoBack = new JButton(Utility.GoBack);
		buttonEdit = new JButton(Utility.Edit);
		buttonGoBack.addActionListener(new AddBillActionListener());
		buttonEdit.addActionListener(new AddBillActionListener());
	}

	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListAnnual().add(new AnnualBill(name, amount, month, day));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBack)) {
	        	frame.changeToSelect(Utility.OneTimeBill);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListAnnual().get(selection).edit(name, amount, month, day);
	        	frame.changeToSelect(Utility.OneTimeBill);
	        }
		}
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	month = monthsComboBox.getSelectedIndex();
    	day = daysComboBox.getSelectedIndex() + 1;
	}
	
	private void initializeLabels() {
		nameLabel = new JLabel(Utility.Name);
		amountLabel = new JLabel(Utility.Amount);
		monthLabel = new JLabel(Utility.Month);
		dayLabel = new JLabel(Utility.Day);
	}
	
	private void addComponents() {
		setLayout(new GridLayout(5,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(monthLabel);
		add(monthsComboBox);
		add(dayLabel);
		add(daysComboBox);
	}
}
