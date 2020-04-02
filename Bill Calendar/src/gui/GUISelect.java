/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.ListCollection;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUISelect extends JPanel implements ActionListener, ListSelectionListener {

	GUIMain frame;
	ListCollection listCollection;
	int typeOfBill;
	JList selectionList;
	public GUISelect(GUIMain guiMain, int typeOfBill) {
		frame = guiMain;
		listCollection = this.frame.getListCollection();
		this.typeOfBill = typeOfBill;
		
		//select(typeOfBill);
		selectionList = new JList(select());
		JButton goBackButton = new JButton(Utility.GoBackMenu);
		JButton enterButton = new JButton(Utility.Enter);
		
		goBackButton.addActionListener(this);
		enterButton.addActionListener(this);
		selectionList.addListSelectionListener(this);
		
		this.add(selectionList);
		add(goBackButton);
		add(enterButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
        if (action.equals(Utility.GoBackMenu)) {
            frame.changeToEdit();
        }
        else if (action.equals(Utility.Enter)) {
            int selection = selectionList.getSelectedIndex();
            switch(typeOfBill) {
    		case 0: frame.changeToEditMonthly(selection);
    			break;
    		case 1: frame.changeToEditAnnual(selection);
    			break;
    		case 2: frame.changeToEditWeekly(selection);
    			break;
    		case 3: frame.changeToEditOneTime(selection);
    			break;
    		case 4: frame.changeToEditLimited(selection);
    			break;
    		}
        }
	}
	
	private String[] select() {
		ArrayList<String> arrayOfStrings = null;
		
		switch(typeOfBill) {
		case 0: arrayOfStrings = selectMonthly();
			break;
		case 1: arrayOfStrings = selectAnnual();
			break;
		case 2: arrayOfStrings = selectWeekly();
			break;
		case 3: arrayOfStrings = selectOneTime();
			break;
		case 4: arrayOfStrings = selectLimited();
			break;
		}
		
		String[] listArray = new String[arrayOfStrings.size()];
		for(int i = 0; i < arrayOfStrings.size(); i++) {
			listArray[i] = arrayOfStrings.get(i);
		}
		
		
		return listArray;
	}

	private ArrayList<String> selectLimitedBill() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListLimitedBill().size(); i++) {
			list.add(listCollection.getListLimitedBill().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectLimitedIncome() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListLimitedIncome().size(); i++) {
			list.add(listCollection.getListLimitedIncome().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectAnnualBill() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListAnnualBill().size(); i++) {
			list.add(listCollection.getListAnnualBill().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectAnnualIncome() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListAnnualIncome().size(); i++) {
			list.add(listCollection.getListAnnualIncome().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectOneTimeBill() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListOneTimeBill().size(); i++) {
			list.add(listCollection.getListOneTimeBill().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectOneTimeIncome() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListOneTimeIncome().size(); i++) {
			list.add(listCollection.getListOneTimeIncome().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectWeeklyBill() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListWeeklyBill().size(); i++) {
			list.add(listCollection.getListWeeklyBill().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectWeeklyIncome() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListWeeklyIncome().size(); i++) {
			list.add(listCollection.getListWeeklyIncome().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectMonthlyBill() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListMonthlyBill().size(); i++) {
			list.add(listCollection.getListMonthlyBill().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectMonthlyIncome() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListMonthlyIncome().size(); i++) {
			list.add(listCollection.getListMonthlyIncome().get(i).listToString());
		}
		
		return list;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
