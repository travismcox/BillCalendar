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
public abstract class BillInput {

	/**
	 * @param scan2 
	 * 
	 */
	public BillInput() {
		
	}
	
	public static void startBillInput(ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime, Scanner scan, ArrayList<LimitedMonthlyBill> listLimited) {
		System.out.print("Select 1 (Monthly), 2 (Weekly), 3 (One Time), 4 (Limited Monthly):");
		switch(scan.nextInt()) {
		case 1: monthlyBillCreator(listMonthly, scan);
				break;
		case 2: weeklyBillCreator(listWeekly, scan);
				break;
		case 3: oneTimeBillCreator(listOneTime, scan);
				break;
		case 4: limitedMonthlyBillCreator(listLimited, scan);
				break;
		default: System.out.println("Incorrect Input");
				break;
		}
	}

	private static void limitedMonthlyBillCreator(ArrayList<LimitedMonthlyBill> listLimited, Scanner scan) {
		String name = nameInput(scan);
		Double amount = amountInput(scan);
		int date = dateInput(scan);
		GregorianCalendar endDate = wholeDateInput("Bill End", scan);
		listLimited.add(new LimitedMonthlyBill(name, amount, date, endDate));
	}

	private static void oneTimeBillCreator(ArrayList<OneTimeBill> listOneTime, Scanner scan) {
		String name = nameInput(scan);
		Double amount = amountInput(scan);
		GregorianCalendar date = wholeDateInput("Bill", scan);
		listOneTime.add(new OneTimeBill(name, amount, date));
	}

	private static GregorianCalendar wholeDateInput(String modifier, Scanner scan) {
		System.out.print(modifier + " year (YYYY):");
		int year = scan.nextInt();
		System.out.print(modifier + " month (MM):");
		int month = scan.nextInt() - 1;
		System.out.print(modifier + " day (DD):");
		int day = scan.nextInt();
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		return date;
	}

	private static void weeklyBillCreator(ArrayList<WeeklyBill> listWeekly, Scanner scan) {
		String name = nameInput(scan);
		Double amount = amountInput(scan);
		listWeekly.add(new WeeklyBill(name, amount));
	}

	private static Double amountInput(Scanner scan) {
		System.out.print("Bill amount:");
		return scan.nextDouble();
	}

	private static void monthlyBillCreator(ArrayList<MonthlyBill> listMonthly, Scanner scan) {
		String name = nameInput(scan);
		Double amount = amountInput(scan);
		int date = dateInput(scan);
		listMonthly.add(new MonthlyBill(name, amount, date));
	}

	private static int dateInput(Scanner scan) {
		System.out.print("Bill date:");
		return scan.nextInt();
	}

	private static String nameInput(Scanner scan) {
		System.out.print("Bill name (no spaces):");
		return scan.next();
	}

}
