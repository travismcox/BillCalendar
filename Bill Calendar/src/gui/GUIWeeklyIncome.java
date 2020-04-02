/**
 * 
 */
package gui;

import gui.GUIWeeklyBill.AddBillActionListener;
import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIWeeklyIncome extends GUITransaction {

	/**
	 * @param frame
	 */
	public GUIWeeklyIncome(GUIMain frame) {
		super(frame);
		
		initializeLabelsAndFields(Utility.EmptyField, Utility.EmptyField);
		initializeButtonsNew(new AddBillActionListener(), new AddBillActionListener());
		
		addComponentsNew();
	}

	/**
	 * @param frame
	 * @param selection
	 */
	public GUIWeeklyIncome(GUIMain frame, int selection) {
		super(frame, selection);
		
	}

}
