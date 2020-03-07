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

import main.ListCollection;

/**
 * @author traviscox
 *
 */
public class GUISelect extends JPanel implements ActionListener {

	GUIMain guiMain;
	ListCollection listCollection;
	public GUISelect(GUIMain guiMain, int typeOfBill) {
		this.guiMain = guiMain;
		listCollection = this.guiMain.getListCollection();
		
		//select(typeOfBill);
		JList selectionList = new JList(select(typeOfBill));
		JButton goBackButton = new JButton("Go Back");
		JButton enterButton = new JButton("Enter");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	private String[] select(int typeOfBill) {
		String[] arrayOfStrings = null;
		switch(typeOfBill) {
		case 0: arrayOfStrings = selectMonthly();
			break;
		case 1: arrayOfStrings = selectWeekly();
			break;
		case 2: arrayOfStrings = selectOneTime();
			break;
		case 3: arrayOfStrings = selectLimited();
			break;
		}
		
		return arrayOfStrings;
	}

	private String[] selectLimited() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListLimited().size(); i++) {
			list.add(listCollection.getListLimited().get(i).listToString());
		}
		
		return (String[]) list.toArray();
	}

	private String[] selectOneTime() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListOneTime().size(); i++) {
			list.add(listCollection.getListOneTime().get(i).listToString());
		}
		
		return (String[]) list.toArray();
	}

	private String[] selectWeekly() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListWeekly().size(); i++) {
			list.add(listCollection.getListWeekly().get(i).listToString());
		}
		
		return (String[]) list.toArray();
	}

	private String[] selectMonthly() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < listCollection.getListMonthly().size(); i++) {
			list.add(listCollection.getListMonthly().get(i).listToString());
		}
		
		return (String[]) list.toArray();
	}

}
