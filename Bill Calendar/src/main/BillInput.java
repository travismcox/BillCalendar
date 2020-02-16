/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author traviscox
 *
 */
public class BillInput {

	Scanner scan;
	/**
	 * @param scan2 
	 * 
	 */
	public BillInput(ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime, Scanner scan) {
		this.scan = scan;
		System.out.print("Select 1 (Monthly), 2 (Weekly), 3 (One Time)");
		switch(scan.nextInt()) {
		case 1: monthlyBillCreator(listMonthly);
				break;
		case 2: weeklyBillCreator(listWeekly);
				break;
		case 3: oneTimeBillCreator(listOneTime);
				break;
		}
	}

	private void oneTimeBillCreator(ArrayList<OneTimeBill> listOneTime) {
		String name = nameInput();
		Double amount = amountInput();
		GregorianCalendar date = wholeDateInput();
		listOneTime.add(new OneTimeBill(name, amount, date));
	}

	private GregorianCalendar wholeDateInput() {
		System.out.print("Bill year (YYYY):");
		int year = scan.nextInt();
		System.out.print("Bill month (MM):");
		int month = scan.nextInt() - 1;
		System.out.print("Bill day (DD):");
		int day = scan.nextInt();
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		return date;
	}

	private void weeklyBillCreator(ArrayList<WeeklyBill> listWeekly) {
		String name = nameInput();
		Double amount = amountInput();
		listWeekly.add(new WeeklyBill(name, amount));
	}

	private Double amountInput() {
		System.out.print("Bill amount:");
		return scan.nextDouble();
	}

	private void monthlyBillCreator(ArrayList<MonthlyBill> listMonthly) {
		String name = nameInput();
		Double amount = amountInput();
		int date = dateInput();
		listMonthly.add(new MonthlyBill(name, amount, date));
	}

	private int dateInput() {
		System.out.print("Bill date:");
		return scan.nextInt();
	}

	private String nameInput() {
		System.out.print("Bill name (no spaces):");
		return scan.next();
	}

}
