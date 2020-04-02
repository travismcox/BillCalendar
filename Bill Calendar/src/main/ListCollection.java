/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author traviscox
 *
 */
public class ListCollection {

	private ArrayList<MonthlyBill> listMonthlyBill; 
	private ArrayList<WeeklyBill> listWeeklyBill; 
	private ArrayList<OneTimeBill> listOneTimeBill;
	private ArrayList<LimitedMonthlyBill> listLimitedBill;
	private ArrayList<AnnualBill> listAnnualBill;
	private ArrayList<WeeklyIncome> listWeeklyIncome;
	/**
	 * 
	 */
	public ListCollection() {
		initializeBills();
		initializeIncome();
	}
	private void initializeIncome() {
		listWeeklyIncome = new ArrayList<WeeklyIncome>();
	}
	/**
	 * @return the listWeeklyIncome
	 */
	public ArrayList<WeeklyIncome> getListWeeklyIncome() {
		return listWeeklyIncome;
	}
	/**
	 * @param listWeeklyIncome the listWeeklyIncome to set
	 */
	public void setListWeeklyIncome(ArrayList<WeeklyIncome> listWeeklyIncome) {
		this.listWeeklyIncome = listWeeklyIncome;
	}
	private void initializeBills() {
		listMonthlyBill = new ArrayList<MonthlyBill>(); 
		listWeeklyBill = new ArrayList<WeeklyBill>(); 
		listOneTimeBill = new ArrayList<OneTimeBill>();
		listLimitedBill = new ArrayList<LimitedMonthlyBill>();
		listAnnualBill = new ArrayList<AnnualBill>();
	}
	/**
	 * @return the listMonthlyBill
	 */
	public ArrayList<MonthlyBill> getListMonthlyBill() {
		return listMonthlyBill;
	}
	/**
	 * @param listMonthlyBill the listMonthlyBill to set
	 */
	public void setListMonthlyBill(ArrayList<MonthlyBill> listMonthlyBill) {
		this.listMonthlyBill = listMonthlyBill;
	}
	/**
	 * @return the listWeeklyBill
	 */
	public ArrayList<WeeklyBill> getListWeeklyBill() {
		return listWeeklyBill;
	}
	/**
	 * @param listWeeklyBill the listWeeklyBill to set
	 */
	public void setListWeeklyBill(ArrayList<WeeklyBill> listWeeklyBill) {
		this.listWeeklyBill = listWeeklyBill;
	}
	/**
	 * @return the listOneTimeBill
	 */
	public ArrayList<OneTimeBill> getListOneTimeBill() {
		return listOneTimeBill;
	}
	/**
	 * @param listOneTimeBill the listOneTimeBill to set
	 */
	public void setListOneTimeBill(ArrayList<OneTimeBill> listOneTimeBill) {
		this.listOneTimeBill = listOneTimeBill;
	}
	/**
	 * @return the listLimitedBill
	 */
	public ArrayList<LimitedMonthlyBill> getListLimitedBill() {
		return listLimitedBill;
	}
	/**
	 * @param listLimitedBill the listLimitedBill to set
	 */
	public void setListLimitedBill(ArrayList<LimitedMonthlyBill> listLimitedBill) {
		this.listLimitedBill = listLimitedBill;
	}
	/**
	 * @return the listAnnualBill
	 */
	public ArrayList<AnnualBill> getListAnnualBill() {
		return listAnnualBill;
	}
	/**
	 * @param listAnnualBill the listAnnualBill to set
	 */
	public void setListAnnualBill(ArrayList<AnnualBill> listAnnualBill) {
		this.listAnnualBill = listAnnualBill;
	}
	

}
