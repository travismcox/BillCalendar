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
public class GUIMainMenu extends GUIMenu {

	JButton[] buttonList;
	MenuActionListener[] actionListenerList;
	public GUIMainMenu(GUIMain frame) {
		super(frame);

		initializeArrays();
		initializeBills(buttonList, Utility.labelListBill, actionListenerList);
	}
	
	protected class MenuActionListener extends GUIMenu.MenuActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
			if (action.equals(Utility.AddBill)) {
	            frame.changeToAdd();
	        }
	        else if (action.equals(Utility.CalculateBills)) {
	            frame.changeToCalculate();
	        }
	        else if (action.equals(Utility.EditBill)) {
	        	frame.changeToEdit();
	        }
	        else if (action.equals(Utility.Exit)) {
	        	frame.saveAndExit();
	        }
		}
	}
	
	private void initializeArrays() {
		buttonList = new JButton[Utility.labelListBill.length];
		actionListenerList = new MenuActionListener[Utility.labelListBill.length];
	}

}
