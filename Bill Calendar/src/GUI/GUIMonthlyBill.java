/**
 * 
 */
package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MonthlyBill;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIMonthlyBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	JComboBox<String> daysComboBox;
	JLabel nameLabel, amountLabel, dateLabel;
	JButton buttonEnter, buttonGoBack, buttonEdit;
	String name;
	Double amount;
	Integer date;
	int selection;
	public GUIMonthlyBill(GUIMain frame) {
		this.frame = frame;
		
		initializeLabels();
		initializeFields();
		initializeButtonsNew();
		
		addComponentsNew();
	}
	
	private void initializeButtonsNew() {
		JButton buttonEnter = new JButton(Utility.AddBill);
		buttonEnter.addActionListener(new AddBillActionListener());
	}

	private void addComponentsNew() {
		addComponents();
		add(buttonEnter);
	}

	private void initializeFields() {
		nameTextField = new JTextField();
		amountTextField = new JTextField();
		daysComboBox = new JComboBox<String>(Utility.Days);
	}

	private void initializeLabels() {
		nameLabel = new JLabel(Utility.Name);
		amountLabel = new JLabel(Utility.Amount);
		dateLabel = new JLabel(Utility.RecurringDate);
	}

	public GUIMonthlyBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		MonthlyBill tempBill = frame.listCollection.getListMonthly().get(selection);
		
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

	private void addComponentsEdit() {
		addComponents();
		add(buttonGoBack);
		add(buttonEdit);
	}

	private void addComponents() {
		setLayout(new GridLayout(4,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
		add(dateLabel);
		add(daysComboBox);
	}

	private void setFields(MonthlyBill tempBill) {
		nameTextField.setText(tempBill.getName());
		amountTextField.setText(tempBill.getAmount().toString());
		daysComboBox.setSelectedIndex(tempBill.getDate());
	}

	public class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if(action.contentEquals(Utility.AddBill)) {
	        	getFieldInput();
	        	frame.getListCollection().getListMonthly().add(new MonthlyBill(name, amount, date));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBack)) {
	        	frame.changeToSelect(Utility.MonthlyBill);
	        }
	        else if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListMonthly().get(selection).edit(name, amount, date);
	        	frame.changeToAdd();
	        }
	    }
	}
	
	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
    	date = daysComboBox.getSelectedIndex() + 1;
	}
}
