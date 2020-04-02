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

	
}
