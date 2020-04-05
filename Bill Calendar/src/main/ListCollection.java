/**
 * 
 */
package main;

import java.util.ArrayList;

import main.transactions.AnnualTransaction;
import main.transactions.LimitedMonthlyTransaction;
import main.transactions.MonthlyTransaction;
import main.transactions.OneTimeTransaction;
import main.transactions.WeeklyTransaction;

/**
 * @author traviscox
 *
 */
public class ListCollection {

	private ArrayList<MonthlyTransaction> listMonthly; 
	private ArrayList<WeeklyTransaction> listWeekly; 
	private ArrayList<OneTimeTransaction> listOneTime;
	private ArrayList<LimitedMonthlyTransaction> listLimited;
	private ArrayList<AnnualTransaction> listAnnual;
	/**
	 * 
	 */
	public ListCollection() {
		initializeTransactions();
	}
	
	private void initializeTransactions() {
		listMonthly = new ArrayList<MonthlyTransaction>(); 
		listWeekly = new ArrayList<WeeklyTransaction>(); 
		listOneTime = new ArrayList<OneTimeTransaction>();
		listLimited = new ArrayList<LimitedMonthlyTransaction>();
		listAnnual = new ArrayList<AnnualTransaction>();
	}

	/**
	 * @return the listMonthly
	 */
	public ArrayList<MonthlyTransaction> getListMonthly() {
		return listMonthly;
	}

	/**
	 * @param listMonthly the listMonthly to set
	 */
	public void setListMonthly(ArrayList<MonthlyTransaction> listMonthly) {
		this.listMonthly = listMonthly;
	}

	/**
	 * @return the listWeekly
	 */
	public ArrayList<WeeklyTransaction> getListWeekly() {
		return listWeekly;
	}

	/**
	 * @param listWeekly the listWeekly to set
	 */
	public void setListWeekly(ArrayList<WeeklyTransaction> listWeekly) {
		this.listWeekly = listWeekly;
	}

	/**
	 * @return the listOneTime
	 */
	public ArrayList<OneTimeTransaction> getListOneTime() {
		return listOneTime;
	}

	/**
	 * @param listOneTime the listOneTime to set
	 */
	public void setListOneTime(ArrayList<OneTimeTransaction> listOneTime) {
		this.listOneTime = listOneTime;
	}

	/**
	 * @return the listLimited
	 */
	public ArrayList<LimitedMonthlyTransaction> getListLimited() {
		return listLimited;
	}

	/**
	 * @param listLimited the listLimited to set
	 */
	public void setListLimited(ArrayList<LimitedMonthlyTransaction> listLimited) {
		this.listLimited = listLimited;
	}

	/**
	 * @return the listAnnual
	 */
	public ArrayList<AnnualTransaction> getListAnnual() {
		return listAnnual;
	}

	/**
	 * @param listAnnual the listAnnual to set
	 */
	public void setListAnnual(ArrayList<AnnualTransaction> listAnnual) {
		this.listAnnual = listAnnual;
	}
	
}
