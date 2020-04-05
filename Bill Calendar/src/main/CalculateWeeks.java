/**
 * 
 */
package main;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import main.transactions.LimitedMonthlyTransaction;
import main.transactions.MonthlyTransaction;
import main.transactions.OneTimeTransaction;
import main.transactions.Transaction;
import main.transactions.WeeklyTransaction;

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
	
	public static ArrayList<String> startCalculateWeeks(CollectionOfListCollections collection, int weeks) {
		GregorianCalendar startDate = new GregorianCalendar();
		GregorianCalendar endDate = new GregorianCalendar();
		ArrayList<String> results = new ArrayList<String>(), tempResults;
		ArrayList<Double> pastFourWeeks = new ArrayList<Double>();
		for(int i = 0; i < Utility.FourInteger; i++) {
			pastFourWeeks.add(0.0);
		}
		establishDays(startDate, endDate);
		for(int i = 0; i < weeks; i++) {
			tempResults = calculateWeek(startDate, endDate, collection, i, pastFourWeeks);
			
			startDate.add(GregorianCalendar.DATE, 7);
			endDate.add(GregorianCalendar.DATE, 7);
			for(int j = 0; j < tempResults.size(); j++) {
				results.add(tempResults.get(j));
			}
		}
		
		printWeeks(results);
		
		return results;
	}
	
	private static void printWeeks(ArrayList<String> results) {
		try {
			FileAccess.calculatedWeeksToFile(results);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static ArrayList<String> calculateWeek(GregorianCalendar startDate, GregorianCalendar endDate, CollectionOfListCollections collection, int week, ArrayList<Double> pastFourWeeks){
		ArrayList<String> listOfBills = new ArrayList<String>();
		ArrayList<String> results = new ArrayList<String>();
		
		Double billSum = calculateTransactions(startDate, endDate, collection.getBillListCollection(), week, listOfBills, results);
		Double incomeSum = calculateTransactions(startDate, endDate, collection.getIncomeListCollection(), week, listOfBills, results);
		
		/*//Get Average
		pastFourWeeks.set(week%Utility.FourInteger, billSum);
		Double tempSum = 0.0;
		for(int i = 0; i < pastFourWeeks.size(); i++) {
			tempSum += pastFourWeeks.get(i);
		}
		Double average = tempSum / Utility.FourDouble;*/
		
		//Print output
		results.add(printWeek(startDate, endDate, billSum, incomeSum));
		for(int i = 0; i < listOfBills.size(); i++) {
			results.add("       " + listOfBills.get(i));
		}
		return results;
	}

	private static Double calculateTransactions(GregorianCalendar startDate, GregorianCalendar endDate, ListCollection listCollection, int week, ArrayList<String> listOfBills, ArrayList<String> results) {
		ArrayList<MonthlyTransaction> listMonthly = listCollection.getListMonthly();
		ArrayList<WeeklyTransaction> listWeekly = listCollection.getListWeekly();
		ArrayList<OneTimeTransaction> listOneTime = listCollection.getListOneTime();
		ArrayList<LimitedMonthlyTransaction> listLimited = listCollection.getListLimited();
		Double sum = 0.0;
		
		//Weekly
		for(int i = 0; i < listWeekly.size(); i++) {
			GregorianCalendar tempDate = new GregorianCalendar();
			tempDate.set(Calendar.YEAR, startDate.get(Calendar.YEAR));
			tempDate.set(Calendar.MONTH, startDate.get(Calendar.MONTH));
			tempDate.set(Calendar.DAY_OF_MONTH, startDate.get(Calendar.DAY_OF_MONTH));
			tempDate.add(Calendar.DAY_OF_MONTH, 5);
			sum = foundDate(listWeekly.get(i), listOfBills, sum, tempDate);
		}
		//Monthly
		for(int i = 0; i < listMonthly.size(); i++) {
			sum = monthlyCalculator(listMonthly.get(i), listOfBills, startDate, endDate, sum, listMonthly.get(i).getRecurringDate());
		}
		//One Time
		for(int i = 0; i < listOneTime.size(); i++) {
			GregorianCalendar date = listOneTime.get(i).getEndDate();
			sum = dateComparison(listOneTime.get(i), date, listOfBills, startDate, endDate, sum);
		}
		//Limited Monthly
		for(int i = 0; i < listLimited.size(); i++) {
			if(startDateEndDateComparison(startDate, listLimited.get(i).getEndDate())) {
				sum = monthlyCalculator(listLimited.get(i), listOfBills, startDate, endDate, sum, listLimited.get(i).getRecurringDate());
			}
		}
		
		return sum;
	}
	
	private static boolean startDateEndDateComparison(GregorianCalendar startDate, GregorianCalendar endDate) {
		boolean result = startDate.before(endDate);
		if(!result) {
			result = (startDate.get(Calendar.YEAR) == endDate.get(Calendar.YEAR)) 
					&& (startDate.get(Calendar.MONTH) == endDate.get(Calendar.MONTH)) 
					&& (startDate.get(Calendar.DAY_OF_MONTH) == endDate.get(Calendar.DAY_OF_MONTH));
		}
		
		return result;
		
	}
	
	private static Double monthlyCalculator(Transaction bill, ArrayList<String> listOfBills, GregorianCalendar startDate, GregorianCalendar endDate, Double sum, int recurringDate) {
		GregorianCalendar date = new GregorianCalendar(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), recurringDate);
		sum = dateComparison(bill, date, listOfBills, startDate, endDate, sum);
		if(startDate.get(Calendar.MONTH) != endDate.get(Calendar.MONTH)) {
			date.add(GregorianCalendar.MONTH, 1);
			sum = dateComparison(bill, date, listOfBills, startDate, endDate, sum);
		}
		return sum;
	}
	
	private static Double dateComparison(Transaction bill, GregorianCalendar date, ArrayList<String> listOfBills, GregorianCalendar startDate, GregorianCalendar endDate, Double sum) {
		if(date.after(startDate) && date.before(endDate)) {
			sum = foundDate(bill, listOfBills, sum, date);
		}
		else if(date.get(Calendar.YEAR) == startDate.get(Calendar.YEAR) && date.get(Calendar.MONTH) == startDate.get(Calendar.MONTH) && date.get(Calendar.DAY_OF_MONTH) == startDate.get(Calendar.DAY_OF_MONTH)) {
			sum = foundDate(bill, listOfBills, sum, date);
		}
		else if(date.get(Calendar.YEAR) == endDate.get(Calendar.YEAR) && date.get(Calendar.MONTH) == endDate.get(Calendar.MONTH) && date.get(Calendar.DAY_OF_MONTH) == endDate.get(Calendar.DAY_OF_MONTH)) {
			sum = foundDate(bill, listOfBills, sum, date);
		}
		return sum;
	}
	
	private static Double foundDate(Transaction bill, ArrayList<String> listOfBills, Double sum, GregorianCalendar date) {
		listOfBills.add(bill.getName() + " - " + bill.getAmount() + " - " + printDate(date));
		return sum += bill.getAmount();
	}

	private static String printWeek(GregorianCalendar startDate, GregorianCalendar endDate, Double billSum, Double incomeSum) {
		return printDate(startDate) + " - " + printDate(endDate) + " " + String.format("\t%.2f", billSum) + "\tavg: " + String.format("\t%.2f", incomeSum) + "\ttotal: " + String.format("\t%.2f", (incomeSum-billSum));
	}
	
	private static String printDate(GregorianCalendar date) {
		DateFormat dformat = new SimpleDateFormat("yyyy/MM/dd");
		
		return dformat.format(date.getTime());
	}

	public static void establishDays(GregorianCalendar startDate, GregorianCalendar endDate) {
		while(startDate.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.FRIDAY) {
			startDate.add(GregorianCalendar.DATE, -1);
			
		}
		endDate.set(startDate.get(GregorianCalendar.YEAR), startDate.get(GregorianCalendar.MONTH), startDate.get(GregorianCalendar.DAY_OF_MONTH));
		endDate.add(GregorianCalendar.DATE, 6);
	}

	
}
