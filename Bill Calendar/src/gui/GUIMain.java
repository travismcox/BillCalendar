/**
 * 
 */
package gui;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import gui.transactions.GUIAnnualBill;
import gui.transactions.GUILimitedBill;
import gui.transactions.GUIMonthlyBill;
import gui.transactions.GUIOneTimeBill;
import gui.transactions.GUIWeeklyBill;
import main.CollectionOfListCollections;
import main.FileAccess;

/**
 * @author traviscox
 *
 */
public class GUIMain extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4599239660108201481L;
	CollectionOfListCollections listCollection;
	/**
	 * @param collection 
	 * 
	 */
	public GUIMain(CollectionOfListCollections collection) {
		this.listCollection = collection;
		
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
	
	public CollectionOfListCollections getCollections() {
		return listCollection;
	}
	
	public void changeToMain() {
		cleanUp(new GUIMainMenu(this), 200, 300);
	}
	
	public void changeToAddTransaction(int transactionType) {
		cleanUp(new GUIAddTransaction(this, transactionType), 200, 300);
	}
	
	public void changeToMonthly(int transactionType) {
		cleanUp(new GUIMonthlyBill(this, transactionType), 500, 300);
	}
	
	public void changeToWeekly(int transactionType) {
		cleanUp(new GUIWeeklyBill(this, transactionType), 500, 300);
	}
	
	public void changeToOneTime(int transactionType) {
		cleanUp(new GUIOneTimeBill(this, transactionType), 500, 400);
	}
	
	public void changeToLimited(int transactionType) {
		cleanUp(new GUILimitedBill(this, transactionType), 500, 450);
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
		cleanUp(new GUICalculateBills(this), 400, 250);
	}

	public void changeToEditTransaction(int transactionType) {
		cleanUp(new GUIEditTransaction(this, transactionType), 200, 300);
	}

	public void changeToSelect(int timeType, int transactionType) {
		cleanUp(new GUISelect(this, timeType, transactionType), 200, 300);
	}

	public void changeToEditMonthly(int selection) {
		cleanUp(new GUIMonthlyBill(this, selection), 500, 300);
	}

	public void changeToEditWeekly(int selection) {
		cleanUp(new GUIWeeklyBill(this, selection), 500, 300);
	}

	public void changeToEditOneTime(int selection) {
		cleanUp(new GUIOneTimeBill(this, selection), 500, 400);
	}

	public void changeToEditLimited(int selection) {
		cleanUp(new GUILimitedBill(this, selection), 500, 450);
	}

	public void changeToAnnual(int transactionType) {
		cleanUp(new GUIAnnualBill(this, transactionType), 500, 350);
	}

	public void changeToEditAnnual(int selection) {
		cleanUp(new GUIAnnualBill(this, selection), 500, 350);
	}
	
	private void cleanUp(Component component, int x, int y) {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(component);
		setSize(x, y);
		run();
	}

}
