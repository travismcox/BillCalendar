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
public class GUIAddBill extends GUIMenu {

	public GUIAddBill(GUIMain frame) {
		super(frame);
		
		initializeArrays();
		initializeBills(buttonList, Utility.labelListBill, actionListenerList);
	}
	
	protected class MenuActionListener extends GUIMenu.MenuActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if (action.equals(Utility.MonthlyBill)) {
	            frame.changeToMonthly();
	        }
	        else if(action.equals(Utility.AnnualBill)) {
	        	frame.changeToAnnual();
	        }
	        else if (action.equals(Utility.WeeklyBill)) {
	            frame.changeToWeekly();
	        }
	        else if (action.equals(Utility.OneTimeBill)) {
	        	frame.changeToOneTime();
	        }
	        else if(action.contentEquals(Utility.LimitedBill)) {
	        	frame.changeToLimited();
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
