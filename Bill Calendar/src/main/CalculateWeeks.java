/**
 * 
 */
package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author traviscox
 *
 */
public class CalculateWeeks {

	/**
	 * @param scan2 
	 * 
	 */
	public CalculateWeeks(ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime, Scanner scan) {
		System.out.print("How many weeks would you like to calculate?");
		//Scanner scan = new Scanner (System.in);
		int weeks = scan.nextInt();
		GregorianCalendar startDate = new GregorianCalendar();
		GregorianCalendar endDate = new GregorianCalendar();
		establishDays(startDate, endDate);
		for(int i = 0; i < weeks; i++) {
			calculateWeek(startDate, endDate, listMonthly, listWeekly, listOneTime);
			startDate.add(GregorianCalendar.DATE, 7);
			endDate.add(GregorianCalendar.DATE, 7);
		}
	}
	
	private void calculateWeek(GregorianCalendar startDate, GregorianCalendar endDate, ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime) {
		Double sum = 0.0;
		ArrayList<String> listOfBills = new ArrayList<String>();
		for(int i = 0; i < listWeekly.size(); i++) {
			sum = foundDate(listWeekly.get(i), listOfBills, sum);
		}
		
		for(int i = 0; i < listMonthly.size(); i++) {
			GregorianCalendar date = new GregorianCalendar(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), listMonthly.get(i).getDate());
			sum = dateComparison(listMonthly.get(i), date, listOfBills, startDate, endDate, sum);
			if(startDate.get(Calendar.MONTH) != endDate.get(Calendar.MONTH)) {
				date.add(GregorianCalendar.MONTH, 1);
				sum = dateComparison(listMonthly.get(i), date, listOfBills, startDate, endDate, sum);
			}
		}
		
		for(int i = 0; i < listOneTime.size(); i++) {
			GregorianCalendar date = listOneTime.get(i).getDate();
			sum = dateComparison(listOneTime.get(i), date, listOfBills, startDate, endDate, sum);
		}
		
		printWeek(startDate, endDate, sum);
		for(int i = 0; i < listOfBills.size(); i++) {
			System.out.println('\t' + listOfBills.get(i));
		}
	}
	
	private Double dateComparison(Bill bill, GregorianCalendar date, ArrayList<String> listOfBills, GregorianCalendar startDate, GregorianCalendar endDate, Double sum) {
		if(date.after(startDate) && date.before(endDate)) {
			sum = foundDate(bill, listOfBills, sum);
		}
		else if(date.get(Calendar.YEAR) == startDate.get(Calendar.YEAR) && date.get(Calendar.MONTH) == startDate.get(Calendar.MONTH) && date.get(Calendar.DAY_OF_MONTH) == startDate.get(Calendar.DAY_OF_MONTH)) {
			sum = foundDate(bill, listOfBills, sum);
		}
		else if(date.get(Calendar.YEAR) == endDate.get(Calendar.YEAR) && date.get(Calendar.MONTH) == endDate.get(Calendar.MONTH) && date.get(Calendar.DAY_OF_MONTH) == endDate.get(Calendar.DAY_OF_MONTH)) {
			sum = foundDate(bill, listOfBills, sum);
		}
		return sum;
	}
	
	private Double foundDate(Bill bill, ArrayList<String> listOfBills, Double sum) {
		listOfBills.add(bill.getName() + " " + bill.getAmount());
		return sum += bill.getAmount();
	}

	private void printWeek(GregorianCalendar startDate, GregorianCalendar endDate, Double sum) {
		DateFormat dformat = new SimpleDateFormat("yyyy/MM/dd");
		System.out.print(dformat.format(startDate.getTime()) + " - ");
		System.out.print(dformat.format(endDate.getTime()) + " ");
		System.out.println(String.format("\t%.2f", sum));
		
	}

	public void establishDays(GregorianCalendar startDate, GregorianCalendar endDate) {
		while(startDate.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.FRIDAY) {
			startDate.add(GregorianCalendar.DATE, 1);
			
		}
		endDate.set(startDate.get(GregorianCalendar.YEAR), startDate.get(GregorianCalendar.MONTH), startDate.get(GregorianCalendar.DAY_OF_MONTH));
		endDate.add(GregorianCalendar.DATE, 6);
	}

}
