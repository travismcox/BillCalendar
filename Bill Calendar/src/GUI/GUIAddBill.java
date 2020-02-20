/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.GUIMain.MainMenuActionListener;

/**
 * @author traviscox
 *
 */
public class GUIAddBill extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GUIAddBill() {
		
	}
	
	public JPanel addBillPanel() {
		JPanel panelAddBill = new JPanel();
		
		JButton buttonMonthly = new JButton("Monthly Bill");
		JButton buttonWeekly = new JButton("Weekly Bill");
		JButton buttonOneTime = new JButton("One Time Bill");
		JButton buttonLimited = new JButton("Limited Monthly Bill");
		buttonMonthly.addActionListener(new GUIMain().new AddBillActionListener());
		buttonWeekly.addActionListener(new GUIMain().new AddBillActionListener());
		buttonOneTime.addActionListener(new GUIMain().new AddBillActionListener());
		buttonLimited.addActionListener(new GUIMain().new AddBillActionListener());
		
		panelAddBill.setLayout(new GridLayout(4,1));
		panelAddBill.add(buttonMonthly);
		panelAddBill.add(buttonWeekly);
		panelAddBill.add(buttonOneTime);
		panelAddBill.add(buttonLimited);
		
		return panelAddBill;
	}

	
}
