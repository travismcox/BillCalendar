/**
 * 
 */
package main;

import java.util.ArrayList;

import main.transactions.AnnualBill;
import main.transactions.AnnualTransaction;
import main.transactions.LimitedMonthlyTransaction;
import main.transactions.MonthlyTransaction;
import main.transactions.OneTimeTransaction;
import main.transactions.WeeklyTransaction;
import main.transactions.WeeklyIncome;

/**
 * @author traviscox
 *
 */
public class ListCollection {

	private ArrayList<MonthlyTransaction> listMonthlyBill; 
	private ArrayList<WeeklyTransaction> listWeeklyBill; 
	private ArrayList<OneTimeTransaction> listOneTimeBill;
	private ArrayList<LimitedMonthlyTransaction> listLimitedBill;
	private ArrayList<AnnualTransaction> listAnnualBill;
	private ArrayList<WeeklyTransaction> listWeeklyIncome;
	private ArrayList<MonthlyTransaction> listMonthlyIncome; 
	private ArrayList<OneTimeTransaction> listOneTimeIncome;
	private ArrayList<LimitedMonthlyTransaction> listLimitedIncome;
	private ArrayList<AnnualTransaction> listAnnualIncome;
	/**
	 * 
	 */
	public ListCollection() {
		initializeBills();
		initializeIncome();
	}
	private void initializeIncome() {
		listMonthlyIncome = new ArrayList<MonthlyTransaction>(); 
		listWeeklyIncome = new ArrayList<WeeklyTransaction>(); 
		listOneTimeIncome = new ArrayList<OneTimeTransaction>();
		listLimitedIncome = new ArrayList<LimitedMonthlyTransaction>();
		listAnnualIncome = new ArrayList<AnnualTransaction>();
	}
	
	private void initializeBills() {
		listMonthlyBill = new ArrayList<MonthlyTransaction>(); 
		listWeeklyBill = new ArrayList<WeeklyTransaction>(); 
		listOneTimeBill = new ArrayList<OneTimeTransaction>();
		listLimitedBill = new ArrayList<LimitedMonthlyTransaction>();
		listAnnualBill = new ArrayList<AnnualTransaction>();
	}
	/**
	 * @return the listMonthlyBill
	 */
	public ArrayList<MonthlyTransaction> getListMonthlyBill() {
		return listMonthlyBill;
	}
	/**
	 * @param listMonthlyBill the listMonthlyBill to set
	 */
	public void setListMonthlyBill(ArrayList<MonthlyTransaction> listMonthlyBill) {
		this.listMonthlyBill = listMonthlyBill;
	}
	/**
	 * @return the listWeeklyBill
	 */
	public ArrayList<WeeklyTransaction> getListWeeklyBill() {
		return listWeeklyBill;
	}
	/**
	 * @param listWeeklyBill the listWeeklyBill to set
	 */
	public void setListWeeklyBill(ArrayList<WeeklyTransaction> listWeeklyBill) {
		this.listWeeklyBill = listWeeklyBill;
	}
	/**
	 * @return the listOneTimeBill
	 */
	public ArrayList<OneTimeTransaction> getListOneTimeBill() {
		return listOneTimeBill;
	}
	/**
	 * @param listOneTimeBill the listOneTimeBill to set
	 */
	public void setListOneTimeBill(ArrayList<OneTimeTransaction> listOneTimeBill) {
		this.listOneTimeBill = listOneTimeBill;
	}
	/**
	 * @return the listLimitedBill
	 */
	public ArrayList<LimitedMonthlyTransaction> getListLimitedBill() {
		return listLimitedBill;
	}
	/**
	 * @param listLimitedBill the listLimitedBill to set
	 */
	public void setListLimitedBill(ArrayList<LimitedMonthlyTransaction> listLimitedBill) {
		this.listLimitedBill = listLimitedBill;
	}
	/**
	 * @return the listAnnualBill
	 */
	public ArrayList<AnnualTransaction> getListAnnualBill() {
		return listAnnualBill;
	}
	/**
	 * @param listAnnualBill the listAnnualBill to set
	 */
	public void setListAnnualBill(ArrayList<AnnualTransaction> listAnnualBill) {
		this.listAnnualBill = listAnnualBill;
	}
	/**
	 * @return the listWeeklyIncome
	 */
	public ArrayList<WeeklyTransaction> getListWeeklyIncome() {
		return listWeeklyIncome;
	}
	/**
	 * @param listWeeklyIncome the listWeeklyIncome to set
	 */
	public void setListWeeklyIncome(ArrayList<WeeklyTransaction> listWeeklyIncome) {
		this.listWeeklyIncome = listWeeklyIncome;
	}
	/**
	 * @return the listMonthlyIncome
	 */
	public ArrayList<MonthlyTransaction> getListMonthlyIncome() {
		return listMonthlyIncome;
	}
	/**
	 * @param listMonthlyIncome the listMonthlyIncome to set
	 */
	public void setListMonthlyIncome(ArrayList<MonthlyTransaction> listMonthlyIncome) {
		this.listMonthlyIncome = listMonthlyIncome;
	}
	/**
	 * @return the listOneTimeIncome
	 */
	public ArrayList<OneTimeTransaction> getListOneTimeIncome() {
		return listOneTimeIncome;
	}
	/**
	 * @param listOneTimeIncome the listOneTimeIncome to set
	 */
	public void setListOneTimeIncome(ArrayList<OneTimeTransaction> listOneTimeIncome) {
		this.listOneTimeIncome = listOneTimeIncome;
	}
	/**
	 * @return the listLimitedIncome
	 */
	public ArrayList<LimitedMonthlyTransaction> getListLimitedIncome() {
		return listLimitedIncome;
	}
	/**
	 * @param listLimitedIncome the listLimitedIncome to set
	 */
	public void setListLimitedIncome(ArrayList<LimitedMonthlyTransaction> listLimitedIncome) {
		this.listLimitedIncome = listLimitedIncome;
	}
	/**
	 * @return the listAnnualIncome
	 */
	public ArrayList<AnnualTransaction> getListAnnualIncome() {
		return listAnnualIncome;
	}
	/**
	 * @param listAnnualIncome the listAnnualIncome to set
	 */
	public void setListAnnualIncome(ArrayList<AnnualTransaction> listAnnualIncome) {
		this.listAnnualIncome = listAnnualIncome;
	}

	
}
