/**
 * 
 */
package GUI;

import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.FileAccess;
import main.ListCollection;

/**
 * @author traviscox
 *
 */
public class GUIMain extends JFrame{

	ListCollection listCollection;
	JPanel panelAddBill, panelMainMenu, panelMonthlyBill, panelWeeklyBill, panelOneTimeBill, panelLimitedBill;
	/**
	 * @param listCollection 
	 * 
	 */
	public GUIMain(ListCollection listCollection) {
		this.listCollection = listCollection;
		
		panelAddBill = new GUIAddBill(this);
		panelMainMenu = new GUIMainMenu(this);
		panelMonthlyBill = new GUIMonthlyBill(this);
		panelWeeklyBill = new GUIWeeklyBill(this);
		panelOneTimeBill = new GUIOneTimeBill(this);
		panelLimitedBill = new GUILimitedBill(this);
		
		this.setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setLocationRelativeTo(null);
	}
	
	public void run() {
		setVisible(true);
	}
	
	public void openMainMenu() {
		new GUIMainMenu(this);
	}
	
	public ListCollection getListCollection() {
		return listCollection;
	}
	
	public void changeToMain() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panelMainMenu);
		setSize(200,300);
		run();
	}
	
	public void changeToAdd() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panelAddBill);
		setSize(200,300);
		run();
	}
	
	public void changeToMonthly() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panelMonthlyBill);
		setSize(500, 300);
		run();
	}
	
	public void changeToWeekly() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panelWeeklyBill);
		setSize(500, 300);
		run();
	}
	
	public void changeToOneTime() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panelOneTimeBill);
		setSize(500, 400);
		run();
	}
	
	public void changeToLimited() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panelLimitedBill);
		setSize(500, 450);
;		run();
	}

	public void saveAndExit() {
		try {
			FileAccess.saveToFile(listCollection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
