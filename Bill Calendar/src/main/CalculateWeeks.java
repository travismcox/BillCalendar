/**
 * 
 */
package main;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
		LocalDate startOfWeek = findNextDayOfWeekOccurance(LocalDate.now(), DayOfWeek.FRIDAY);
		LocalDate endOfWeek = findNextDayOfWeekOccurance(startOfWeek, DayOfWeek.THURSDAY);
		ArrayList<String> results = new ArrayList<String>(), tempResults;
		ArrayList<Double> pastFourWeeks = new ArrayList<Double>();
		for(int i = 0; i < Utility.FourInteger; i++) {
			pastFourWeeks.add(0.0);
		}
		
		for(int i = 0; i < weeks; i++) {
			LocalDate tempStart = startOfWeek.plusWeeks(i);
			LocalDate tempEnd = endOfWeek.plusWeeks(i);
			tempResults = calculateWeek(tempStart, tempEnd, collection, i, pastFourWeeks);
			
			for(int j = 0; j < tempResults.size(); j++) {
				results.add(tempResults.get(j));
			}
		}
		
		printWeeks(results);
		
		return results;
	}
	
	private static LocalDate findNextDayOfWeekOccurance(LocalDate start, DayOfWeek target) {
		LocalDate temp = start.plusDays(0);
		while(temp.getDayOfWeek() != target) {
			LocalDate tempDate = temp.plusDays(1);
			start = tempDate;
		}
		
		return start;
	}

	private static void printWeeks(ArrayList<String> results) {
		try {
			FileAccess.calculatedWeeksToFile(results);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static ArrayList<String> calculateWeek(LocalDate tempStart, LocalDate tempEnd, CollectionOfListCollections collection, int week, ArrayList<Double> pastFourWeeks){
		ArrayList<String> listOfBills = new ArrayList<String>();
		ArrayList<String> results = new ArrayList<String>();
		
		Double billSum = calculateTransactions(tempStart, tempEnd, collection.getBillListCollection(), week, listOfBills, results);
		Double incomeSum = calculateTransactions(tempStart, tempEnd, collection.getIncomeListCollection(), week, listOfBills, results);
		
		/*//Get Average
		pastFourWeeks.set(week%Utility.FourInteger, billSum);
		Double tempSum = 0.0;
		for(int i = 0; i < pastFourWeeks.size(); i++) {
			tempSum += pastFourWeeks.get(i);
		}
		Double average = tempSum / Utility.FourDouble;*/
		
		//Print output
		results.add(printWeek(tempStart, tempEnd, billSum, incomeSum));
		for(int i = 0; i < listOfBills.size(); i++) {
			results.add("       " + listOfBills.get(i));
		}
		return results;
	}

	private static Double calculateTransactions(LocalDate tempStart, LocalDate tempEnd, ListCollection listCollection, int week, ArrayList<String> listOfBills, ArrayList<String> results) {
		ArrayList<MonthlyTransaction> listMonthly = listCollection.getListMonthly();
		ArrayList<WeeklyTransaction> listWeekly = listCollection.getListWeekly();
		ArrayList<OneTimeTransaction> listOneTime = listCollection.getListOneTime();
		ArrayList<LimitedMonthlyTransaction> listLimited = listCollection.getListLimited();
		Double sum = 0.0;
		
		//Weekly
		for(int i = 0; i < listWeekly.size(); i++) {
			LocalDate tempDate = findNextDayOfWeekOccurance(tempStart, listWeekly.get(i).getDayOfWeek());
			sum = foundDate(listWeekly.get(i), listOfBills, sum, tempDate);
		}
		//Monthly
		for(int i = 0; i < listMonthly.size(); i++) {
			sum = monthlyCalculator(listMonthly.get(i), listOfBills, tempStart, tempEnd, sum, listMonthly.get(i).getRecurringDate());
		}
		//One Time
		for(int i = 0; i < listOneTime.size(); i++) {
			LocalDate date = listOneTime.get(i).getEndDate();
			sum = dateComparison(listOneTime.get(i), date, listOfBills, tempStart, tempEnd, sum);
		}
		//Limited Monthly
		for(int i = 0; i < listLimited.size(); i++) {
			sum = monthlyCalculator(listLimited.get(i), listOfBills, tempStart, tempEnd, sum, listLimited.get(i).getRecurringDate());
		}
		
		return sum;
	}
	
	private static Double monthlyCalculator(Transaction bill, ArrayList<String> listOfBills, LocalDate tempStart, LocalDate tempEnd, Double sum, int recurringDate) {
		LocalDate date = tempStart.withDayOfMonth(recurringDate);
		sum = dateComparison(bill, date, listOfBills, tempStart, tempEnd, sum);
		if(tempStart.getMonthValue() != tempEnd.getMonthValue()) {
			date = LocalDate.from(date).plusMonths(1);
			sum = dateComparison(bill, date, listOfBills, tempStart, tempEnd, sum);
		}
		return sum;
	}
	
	private static Double dateComparison(Transaction bill, LocalDate date, ArrayList<String> listOfBills, LocalDate tempStart, LocalDate tempEnd, Double sum) {
		if(date.isAfter(tempStart) && date.isBefore(tempEnd)) {
			sum = foundDate(bill, listOfBills, sum, date);
		}
		else if(date.isEqual(tempStart) || date.isEqual(tempEnd)) {
			sum = foundDate(bill, listOfBills, sum, date);
		}
		
		return sum;
	}
	
	private static Double foundDate(Transaction bill, ArrayList<String> listOfBills, Double sum, LocalDate tempDate) {
		listOfBills.add(bill.getName() + " - " + bill.getAmount() + " - " + printDate(tempDate));
		return sum += bill.getAmount();
	}

	private static String printWeek(LocalDate tempStart, LocalDate tempEnd, Double billSum, Double incomeSum) {
		return printDate(tempStart) + " - " + printDate(tempEnd) + " " + String.format("\tbills:%.2f", billSum) + String.format("\tincome:%.2f", incomeSum) + String.format("\ttotal:%.2f", (incomeSum-billSum));
	}
	
	private static String printDate(LocalDate tempDate) {
		return tempDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

}
