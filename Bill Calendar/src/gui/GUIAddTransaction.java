/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import gui.GUIMainMenu.MenuActionListener;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIAddTransaction extends GUIMenu {

	int transactionType;
	public GUIAddTransaction(GUIMain frame, int transactionType) {
		super(frame);
		this.transactionType = transactionType;
		
		initializeArrays();
		initializeBills(buttonList, Utility.labelListBill, actionListenerList);
	}
	
	protected class MenuActionListener extends GUIMenu.MenuActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if (action.equals(Utility.MonthlyBill)) {
	            frame.changeToMonthly(transactionType);
	        }
	        else if(action.equals(Utility.AnnualBill)) {
	        	frame.changeToAnnual(transactionType);
	        }
	        else if (action.equals(Utility.WeeklyBill)) {
	            frame.changeToWeekly(transactionType);
	        }
	        else if (action.equals(Utility.OneTimeBill)) {
	        	frame.changeToOneTime(transactionType);
	        }
	        else if(action.contentEquals(Utility.LimitedBill)) {
	        	frame.changeToLimited(transactionType);
	        }
	        else if(action.contentEquals(Utility.BackToMainMenu)) {
	        	frame.changeToMain();
	        }
	    }
	}
	
	private void initializeArrays() {
		buttonList = new JButton[Utility.labelListBill.length];
		actionListenerList = new MenuActionListener[Utility.labelListBill.length];
		for(int i = 0; i < Utility.labelListMainMenu.length; i++) {
			actionListenerList[i] = new MenuActionListener();
		}
	}

}
