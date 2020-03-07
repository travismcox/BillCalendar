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
import java.util.ArrayList;

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
	/**
	 * @param listCollection 
	 * 
	 */
	public GUIMain(ListCollection listCollection) {
		this.listCollection = listCollection;
		
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
		getContentPane().add(new GUIMainMenu(this));
		setSize(200,300);
		run();
	}
	
	public void changeToAdd() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUIAddBill(this));
		setSize(200,300);
		run();
	}
	
	public void changeToMonthly() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUIMonthlyBill(this));
		setSize(500, 300);
		run();
	}
	
	public void changeToWeekly() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUIWeeklyBill(this));
		setSize(500, 300);
		run();
	}
	
	public void changeToOneTime() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUIOneTimeBill(this));
		setSize(500, 400);
		run();
	}
	
	public void changeToLimited() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUILimitedBill(this));
		setSize(500, 450);
		run();
	}
	
	public void printResults(ArrayList<String> results) {
		new GUIResults(results);
		changeToMain();
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

	public void changeToCalculate() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUICalculateBills(this));
		setSize(400, 250);
		run();
	}

	public void changeToEdit() {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(new GUIEditBill(this));
		setSize(200, 300);
		run();
	}

}
