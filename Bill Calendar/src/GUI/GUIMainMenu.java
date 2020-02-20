/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.GUIMain.MainMenuActionListener;

/**
 * @author traviscox
 *
 */
public class GUIMainMenu extends JPanel {

	/**
	 * @param mainMenuActionListener 
	 * 
	 */
	public GUIMainMenu(MainMenuActionListener mainMenuActionListener) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 */
	public GUIMainMenu(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public GUIMainMenu(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public GUIMainMenu(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public GUIMainMenu() {
		// TODO Auto-generated constructor stub
	}

	public JPanel mainMenuPanel() {
		JPanel panelAddBill = new JPanel();
		
		
		JButton buttonAddBill = new JButton("Add Bill");
		JButton buttonCalculateBills = new JButton("Calculate Bills");
		JButton buttonEditBills = new JButton("Edit Bills");
		JButton buttonExit = new JButton("Exit");
		buttonAddBill.addActionListener(new GUIMain().new MainMenuActionListener());
		buttonCalculateBills.addActionListener(new GUIMain().new MainMenuActionListener());
		buttonEditBills.addActionListener(new GUIMain().new MainMenuActionListener());
		buttonExit.addActionListener(new GUIMain().new MainMenuActionListener());
		
		panelAddBill.setLayout(new GridLayout(4,1));
		panelAddBill.add(buttonAddBill);
		panelAddBill.add(buttonCalculateBills);
		panelAddBill.add(buttonEditBills);
		panelAddBill.add(buttonExit);
		
		return panelAddBill;
	}

}
