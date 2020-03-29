/**
 * 
 */
package GUI;

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
		JButton goBackButton = new JButton(Utility.GoBack);
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
        if (action.equals(Utility.GoBack)) {
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

	private ArrayList<String> selectLimited() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListLimited().size(); i++) {
			list.add(listCollection.getListLimited().get(i).listToString());
		}
		
		return list;
	}
	
	private ArrayList<String> selectAnnual() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListAnnual().size(); i++) {
			list.add(listCollection.getListAnnual().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectOneTime() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListOneTime().size(); i++) {
			list.add(listCollection.getListOneTime().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectWeekly() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListWeekly().size(); i++) {
			list.add(listCollection.getListWeekly().get(i).listToString());
		}
		
		return list;
	}

	private ArrayList<String> selectMonthly() {
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
