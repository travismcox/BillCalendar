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
public abstract class CalculateWeeks {

	/**
	 * @param listLimited 
	 * @param scan2 
	 * 
	 */
	public CalculateWeeks() {
		
	}
	
	public static ArrayList<String> startCalculateWeeks(ListCollection listCollection, int weeks) {
		GregorianCalendar startDate = new GregorianCalendar();
		GregorianCalendar endDate = new GregorianCalendar();
		ArrayList<String> results = new ArrayList<String>(), tempResults;
		establishDays(startDate, endDate);
		for(int i = 0; i < weeks; i++) {
			tempResults = calculateWeek(startDate, endDate, listCollection.getListMonthly(), listCollection.getListWeekly(), listCollection.getListOneTime(), listCollection.getListLimited());
			startDate.add(GregorianCalendar.DATE, 7);
			endDate.add(GregorianCalendar.DATE, 7);
			for(int j = 0; j < tempResults.size(); j++) {
				results.add(tempResults.get(j));
			}
		}
		return results;
	}
	
	private static ArrayList<String> calculateWeek(GregorianCalendar startDate, GregorianCalendar endDate, ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime, ArrayList<LimitedMonthlyBill> listLimited) {
		Double sum = 0.0;
		ArrayList<String> listOfBills = new ArrayList<String>();
		ArrayList<String> results = new ArrayList<String>();
		//Weekly
		for(int i = 0; i < listWeekly.size(); i++) {
			sum = foundDate(listWeekly.get(i), listOfBills, sum);
		}
		//Monthly
		for(int i = 0; i < listMonthly.size(); i++) {
			sum = monthlyCalculator(listMonthly.get(i), listOfBills, startDate, endDate, sum, listMonthly.get(i).getDate());
		}
		//One Time
		for(int i = 0; i < listOneTime.size(); i++) {
			GregorianCalendar date = listOneTime.get(i).getDate();
			sum = dateComparison(listOneTime.get(i), date, listOfBills, startDate, endDate, sum);
		}
		//Limited Monthly
		for(int i = 0; i < listLimited.size(); i++) {
			if(!startDate.after(listLimited.get(i).getEndDate())) {
				sum = monthlyCalculator(listLimited.get(i), listOfBills, startDate, endDate, sum, listLimited.get(i).getDate());
			}
		}
		
		//Print output
		results.add(printWeek(startDate, endDate, sum));
		for(int i = 0; i < listOfBills.size(); i++) {
			//System.out.println('\t' + listOfBills.get(i));
			results.add('\t' + listOfBills.get(i));
		}
		return results;
	}
	
	private static Double monthlyCalculator(Bill bill, ArrayList<String> listOfBills, GregorianCalendar startDate, GregorianCalendar endDate, Double sum, int recurringDate) {
		GregorianCalendar date = new GregorianCalendar(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), recurringDate);
		sum = dateComparison(bill, date, listOfBills, startDate, endDate, sum);
		if(startDate.get(Calendar.MONTH) != endDate.get(Calendar.MONTH)) {
			date.add(GregorianCalendar.MONTH, 1);
			sum = dateComparison(bill, date, listOfBills, startDate, endDate, sum);
		}
		return sum;
	}
	
	private static Double dateComparison(Bill bill, GregorianCalendar date, ArrayList<String> listOfBills, GregorianCalendar startDate, GregorianCalendar endDate, Double sum) {
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
	
	private static Double foundDate(Bill bill, ArrayList<String> listOfBills, Double sum) {
		listOfBills.add(bill.getName() + " " + bill.getAmount());
		return sum += bill.getAmount();
	}

	private static String printWeek(GregorianCalendar startDate, GregorianCalendar endDate, Double sum) {
		DateFormat dformat = new SimpleDateFormat("yyyy/MM/dd");
		String dates = "";
		dates += dformat.format(startDate.getTime()) + " - ";
		dates += dformat.format(endDate.getTime()) + " ";
		dates += String.format("\t%.2f", sum);
		//System.out.print(dformat.format(startDate.getTime()) + " - ");
		//System.out.print(dformat.format(endDate.getTime()) + " ");
		//System.out.println(String.format("\t%.2f", sum));
		
		return dates;
	}

	public static void establishDays(GregorianCalendar startDate, GregorianCalendar endDate) {
		while(startDate.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.FRIDAY) {
			startDate.add(GregorianCalendar.DATE, 1);
			
		}
		endDate.set(startDate.get(GregorianCalendar.YEAR), startDate.get(GregorianCalendar.MONTH), startDate.get(GregorianCalendar.DAY_OF_MONTH));
		endDate.add(GregorianCalendar.DATE, 6);
	}

}
