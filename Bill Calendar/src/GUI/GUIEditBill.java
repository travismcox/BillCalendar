/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.GUIAddBill.MenuActionListener;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIEditBill extends GUIMenu {
	
	public GUIEditBill(GUIMain frame) {
		super(frame);
		
		initializeArrays();
		initializeBills(buttonList, Utility.labelListBill, actionListenerList);
	}
	
	protected class MenuActionListener extends GUIMenu.MenuActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if (action.equals(Utility.MonthlyBill)) {
	            frame.changeToSelect(Utility.MonthlyBillValue);
	        }
	        else if(action.equals(Utility.AnnualBill)) {
	        	frame.changeToSelect(Utility.AnnualBillValue);
	        }
	        else if (action.equals(Utility.WeeklyBill)) {
	            frame.changeToSelect(Utility.WeeklyBillValue);
	        }
	        else if (action.equals(Utility.OneTimeBill)) {
	        	frame.changeToSelect(Utility.OneTimeBillValue);
	        }
	        else if(action.contentEquals(Utility.LimitedBill)) {
	        	frame.changeToSelect(Utility.LimitedBillValue);
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
