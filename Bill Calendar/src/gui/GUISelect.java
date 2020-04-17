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

import main.CollectionOfListCollections;
import main.ListCollection;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUISelect extends JPanel implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6232539809661294561L;
	GUIMain frame;
	CollectionOfListCollections collection;
	int typeOfBill, transactionType;
	JList<String> selectionList;
	public GUISelect(GUIMain guiMain, int typeOfBill, int transactionType) {
		frame = guiMain;
		collection = this.frame.getCollections();
		this.typeOfBill = typeOfBill;
		this.transactionType = transactionType;
		
		//select(typeOfBill);
		switch(transactionType) {
		case 0: selectionList = new JList<String>(selectTransactionPeriod(collection.getBillListCollection()));
			break;
		case 1: selectionList = new JList<String>(selectTransactionPeriod(collection.getIncomeListCollection()));
			break;
		}
		
		
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
            frame.changeToEditTransaction(transactionType);
        }
        else if (action.equals(Utility.Enter)) {
            int selection = selectionList.getSelectedIndex();
            switch(typeOfBill) {
    		case 0: frame.changeToEditMonthly(selection, transactionType);
    			break;
    		case 1: frame.changeToEditAnnual(selection, transactionType);
    			break;
    		case 2: frame.changeToEditWeekly(selection, transactionType);
    			break;
    		case 3: frame.changeToEditOneTime(selection, transactionType);
    			break;
    		case 4: frame.changeToEditLimited(selection, transactionType);
    			break;
    		}
        }
	}
	
	private String[] selectTransactionPeriod(ListCollection listCollection) {
		ArrayList<String> arrayOfStrings = null;
		
		switch(typeOfBill) {
		case 0: arrayOfStrings = selectMonthlyTransaction(listCollection);
			break;
		case 1: arrayOfStrings = selectAnnualTransaction(listCollection);
			break;
		case 2: arrayOfStrings = selectWeeklyTransaction(listCollection);
			break;
		case 3: arrayOfStrings = selectOneTimeTransaction(listCollection);
			break;
		case 4: arrayOfStrings = selectLimitedTransaction(listCollection);
			break;
		}
		
		String[] listArray = new String[arrayOfStrings.size()];
		for(int i = 0; i < arrayOfStrings.size(); i++) {
			listArray[i] = arrayOfStrings.get(i);
		}
		
		
		return listArray;
	}

	private ArrayList<String> selectLimitedTransaction(ListCollection listCollection) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListLimited().size(); i++) {
			list.add(listCollection.getListLimited().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectAnnualTransaction(ListCollection listCollection) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListAnnual().size(); i++) {
			list.add(listCollection.getListAnnual().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectOneTimeTransaction(ListCollection listCollection) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListOneTime().size(); i++) {
			list.add(listCollection.getListOneTime().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectWeeklyTransaction(ListCollection listCollection) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListWeekly().size(); i++) {
			list.add(listCollection.getListWeekly().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectMonthlyTransaction(ListCollection listCollection) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListMonthly().size(); i++) {
			list.add(listCollection.getListMonthly().get(i).listToString());
		}
		
		return list;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
