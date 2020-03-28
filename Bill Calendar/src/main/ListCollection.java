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

	private ArrayList<MonthlyBill> listMonthly; 
	private ArrayList<WeeklyBill> listWeekly; 
	private ArrayList<OneTimeBill> listOneTime;
	private ArrayList<LimitedMonthlyBill> listLimited;
	private ArrayList<AnnualBill> listAnnual;
	/**
	 * 
	 */
	public ListCollection() {
		listMonthly = new ArrayList<MonthlyBill>(); 
		listWeekly = new ArrayList<WeeklyBill>(); 
		listOneTime = new ArrayList<OneTimeBill>();
		listLimited = new ArrayList<LimitedMonthlyBill>();
		listAnnual = new ArrayList<AnnualBill>();
	}
	/**
	 * @return the listMonthly
	 */
	public ArrayList<MonthlyBill> getListMonthly() {
		return listMonthly;
	}
	/**
	 * @param listMonthly the listMonthly to set
	 */
	public void setListMonthly(ArrayList<MonthlyBill> listMonthly) {
		this.listMonthly = listMonthly;
	}
	/**
	 * @return the listWeekly
	 */
	public ArrayList<WeeklyBill> getListWeekly() {
		return listWeekly;
	}
	/**
	 * @param listWeekly the listWeekly to set
	 */
	public void setListWeekly(ArrayList<WeeklyBill> listWeekly) {
		this.listWeekly = listWeekly;
	}
	/**
	 * @return the listOneTime
	 */
	public ArrayList<OneTimeBill> getListOneTime() {
		return listOneTime;
	}
	/**
	 * @param listOneTime the listOneTime to set
	 */
	public void setListOneTime(ArrayList<OneTimeBill> listOneTime) {
		this.listOneTime = listOneTime;
	}
	/**
	 * @return the listLimited
	 */
	public ArrayList<LimitedMonthlyBill> getListLimited() {
		return listLimited;
	}
	/**
	 * @param listLimited the listLimited to set
	 */
	public void setListLimited(ArrayList<LimitedMonthlyBill> listLimited) {
		this.listLimited = listLimited;
	}
	/**
	 * @return the listAnnual
	 */
	public ArrayList<AnnualBill> getListAnnual() {
		return listAnnual;
	}
	/**
	 * @param listAnnual the listAnnual to set
	 */
	public void setListAnnual(ArrayList<AnnualBill> listAnnual) {
		this.listAnnual = listAnnual;
	}

}
