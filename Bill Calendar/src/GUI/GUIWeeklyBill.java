/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.GUIMonthlyBill.AddBillActionListener;
import main.MonthlyBill;
import main.Utility;
import main.WeeklyBill;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyBill extends JPanel {

	GUIMain frame;
	JTextField nameTextField, amountTextField, dateTextField;
	JButton buttonEnter, buttonGoBack, buttonEdit;
	JLabel nameLabel, amountLabel;
	String name;
	Double amount;
	int selection;
	public GUIWeeklyBill(GUIMain frame) {
		this.frame = frame;
		
		initializeLabels();
		initializeFields();
		initializeButtonsNew();
		
		addComponentsNew();
	}
	
	private void initializeButtonsNew() {
		buttonEnter = new JButton(Utility.AddBill);
		buttonEnter.addActionListener(new AddBillActionListener());
	}

	private void initializeFields() {
		nameTextField = new JTextField();
		amountTextField = new JTextField();
	}

	private void initializeLabels() {
		nameLabel = new JLabel(Utility.Name);
		amountLabel = new JLabel(Utility.Amount);
	}

	private void addComponentsNew() {
		addComponents();
		add(buttonEnter);
	}

	private void addComponents() {
		setLayout(new GridLayout(3,2));
		add(nameLabel);
		add(nameTextField);
		add(amountLabel);
		add(amountTextField);
	}

	public GUIWeeklyBill(GUIMain frame, int selection) {
		this.frame = frame;
		this.selection = selection;
		WeeklyBill tempBill = frame.listCollection.getListWeekly().get(selection);
		
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

	private void setFields(WeeklyBill tempBill) {
		nameTextField.setText(tempBill.getName());
		amountTextField.setText(tempBill.getAmount().toString());
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
	        	frame.getListCollection().getListWeekly().add(new WeeklyBill(name, amount));
	        	frame.changeToAdd();
	        }
	        else if(action.contentEquals(Utility.GoBack)) {
	        	frame.changeToSelect(Utility.WeeklyBill);
	        }
	        if(action.contentEquals(Utility.Edit)) {
	        	getFieldInput();
	        	frame.getListCollection().getListWeekly().get(selection).edit(name, amount);
	        	frame.changeToSelect(Utility.WeeklyBill);
	        }
	    }
	}

	public void getFieldInput() {
		name = nameTextField.getText();
    	amount = Double.parseDouble(amountTextField.getText());
	}
}
