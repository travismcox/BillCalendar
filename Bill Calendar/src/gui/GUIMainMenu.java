/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Utility;


/**
 * @author traviscox
 *
 */
public class GUIMainMenu extends GUIMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728939881900207545L;

	public GUIMainMenu(GUIMain frame) {
		super(frame);

		initializeArrays();
		initializeBills(buttonList, Utility.labelListMainMenu, actionListenerList);
	}
	
	protected class MenuActionListener extends GUIMenu.MenuActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
			if (action.equals(Utility.AddBill)) {
	            frame.changeToAddTransaction(Utility.BILL);
	        }
			else if (action.equals(Utility.AddIncome)) {
	            frame.changeToAddTransaction(Utility.INCOME);
	        }
	        else if (action.equals(Utility.CalculateBills)) {
	            frame.changeToCalculate();
	        }
	        else if (action.equals(Utility.EditBill)) {
	        	frame.changeToEditTransaction(Utility.BILL);
	        }
	        else if (action.equals(Utility.EditIncome)) {
	            frame.changeToEditTransaction(Utility.INCOME);
	        }
	        else if (action.equals(Utility.Exit)) {
	        	frame.saveAndExit();
	        }
		}
	}
	
	private void initializeArrays() {
		buttonList = new JButton[Utility.labelListMainMenu.length];
		actionListenerList = new MenuActionListener[Utility.labelListMainMenu.length];
		for(int i = 0; i < Utility.labelListMainMenu.length; i++) {
			actionListenerList[i] = new MenuActionListener();
		}
	}

}
