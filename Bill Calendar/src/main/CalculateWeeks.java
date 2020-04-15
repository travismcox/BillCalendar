/**
 * 
 */
package main;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import main.transactions.OneTimeTransaction;
import main.transactions.Transaction;

/**
 * @author traviscox
 *
 */
public abstract class CalculateWeeks {
	
	public CalculateWeeks() {
		
	}
	
	public static ArrayList<String> startCalculateWeeks(CollectionOfListCollections collection, int weeks) {
		LocalDate startOfWeek = findNextDayOfWeekOccurance(LocalDate.now(), DayOfWeek.FRIDAY, -1);
		LocalDate endOfWeek = findNextDayOfWeekOccurance(startOfWeek, DayOfWeek.THURSDAY, 1);
		ArrayList<OneTimeTransaction> tempResultsBill, tempResultsIncome; 
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<Double> totalTotals = new ArrayList<Double>(), bills = new ArrayList<Double>(), incomes = new ArrayList<Double>();
		
		for(int i = 0; i < weeks; i++) {
			LocalDate tempStart = startOfWeek.plusWeeks(i);
			LocalDate tempEnd = endOfWeek.plusWeeks(i);
			tempResultsBill = new ArrayList<OneTimeTransaction>();
			tempResultsIncome = new ArrayList<OneTimeTransaction>();
			calculateWeek(tempStart, tempEnd, collection, i, totalTotals, bills, incomes, tempResultsBill, tempResultsIncome);
			addWeekToOutput(tempResultsBill, tempResultsIncome, results, tempStart, tempEnd, i, bills, incomes, totalTotals);
		}
		printWeeks(results);
		
		return results;
	}
	
	private static void addWeekToOutput(ArrayList<OneTimeTransaction> tempResultsBill, ArrayList<OneTimeTransaction> tempResultsIncome, ArrayList<String> results, LocalDate tempStart, LocalDate tempEnd, int week, ArrayList<Double> bills, ArrayList<Double> incomes, ArrayList<Double> totalTotals) {
		results.add(printDate(tempStart) + " - " + printDate(tempEnd));
		results.add(String.format("bills:%.2f", bills.get(week)) + String.format("\tincome:%.2f", incomes.get(week)) + String.format("\tremaining:%.2f", (incomes.get(week)-bills.get(week))) + String.format("\tTOTAL:%.2f", totalTotals.get(week)));
		addTransactionToOutput(tempResultsBill, results);
		addTransactionToOutput(tempResultsIncome, results);
	}

	private static void addTransactionToOutput(ArrayList<OneTimeTransaction> tempResults, ArrayList<String> results) {
		for(int i = 0; i< tempResults.size(); i++) {
			results.add("     " + tempResults.get(i).listToString());
		}
	}

	private static LocalDate findNextDayOfWeekOccurance(LocalDate start, DayOfWeek target, int increment) {
		LocalDate temp = start.plusDays(0);
		while(temp.getDayOfWeek().getValue() != target.getValue()) {
			LocalDate tempDate = temp.plusDays(increment);
			temp = tempDate;
		}
		
		return temp;
	}

	private static void printWeeks(ArrayList<String> results) {
		try {
			FileAccess.calculatedWeeksToFile(results);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void calculateWeek(LocalDate tempStart, LocalDate tempEnd, CollectionOfListCollections collection, int week, ArrayList<Double> totalTotals, ArrayList<Double> bills, ArrayList<Double> incomes, ArrayList<OneTimeTransaction> tempResultsBill, ArrayList<OneTimeTransaction> tempResultsIncome){
		bills.add(calculateTransactions(tempStart, tempEnd, collection.getBillListCollection(), week, tempResultsBill));
		incomes.add(calculateTransactions(tempStart, tempEnd, collection.getIncomeListCollection(), week, tempResultsIncome));
		
		totalTotals.add(incomes.get(week)-bills.get(week));
		if(week > 0) {
			totalTotals.set(week, totalTotals.get(week)+totalTotals.get(week-1));
		}
	}

	private static Double calculateTransactions(LocalDate tempStart, LocalDate tempEnd, ListCollection listCollection, int week, ArrayList<OneTimeTransaction> tempResults) {
		//Weekly
		for(int i = 0; i < listCollection.getListWeekly().size(); i++) {
			foundDate(listCollection.getListWeekly().get(i), findNextDayOfWeekOccurance(tempStart, listCollection.getListWeekly().get(i).getDayOfWeek(), 1), tempResults);
		}
		//Monthly
		for(int i = 0; i < listCollection.getListMonthly().size(); i++) {
			monthlyCalculator(listCollection.getListMonthly().get(i), tempStart, tempEnd, listCollection.getListMonthly().get(i).getRecurringDate(), tempResults);
		}
		//One Time
		for(int i = 0; i < listCollection.getListOneTime().size(); i++) {
			dateComparison(listCollection.getListOneTime().get(i), listCollection.getListOneTime().get(i).getEndDate(), tempStart, tempEnd, tempResults);
		}
		//Limited Monthly
		for(int i = 0; i < listCollection.getListLimited().size(); i++) {
			if(listCollection.getListLimited().get(i).getEndDate().isAfter(tempStart.minusDays(1))) {
				monthlyCalculator(listCollection.getListLimited().get(i), tempStart, tempEnd, listCollection.getListLimited().get(i).getRecurringDate(), tempResults);
			}
		}
		
		return sumTransactions(tempResults);
	}
	
	private static Double sumTransactions(ArrayList<OneTimeTransaction> tempResults) {
		Double sum = 0.0;
		for(int i = 0; i < tempResults.size(); i++) {
			sum += tempResults.get(i).getAmount();
		}
		return sum;
	}

	private static void monthlyCalculator(Transaction bill, LocalDate tempStart, LocalDate tempEnd, int recurringDate, ArrayList<OneTimeTransaction> tempResults) {
		dateComparison(bill, tempStart.withDayOfMonth(recurringDate), tempStart, tempEnd, tempResults);
		if(tempStart.getMonthValue() != tempEnd.getMonthValue()) {
			dateComparison(bill, tempStart.withDayOfMonth(recurringDate).plusMonths(1), tempStart, tempEnd, tempResults);
		}
	}
	
	private static void dateComparison(Transaction bill, LocalDate date, LocalDate tempStart, LocalDate tempEnd, ArrayList<OneTimeTransaction> tempResults) {
		if((date.isAfter(tempStart) && date.isBefore(tempEnd)) || date.isEqual(tempStart) || date.isEqual(tempEnd)) {
			foundDate(bill, date, tempResults);
		}
	}
	
	private static void foundDate(Transaction bill, LocalDate tempDate, ArrayList<OneTimeTransaction> tempResults) {
		tempResults.add(new OneTimeTransaction(bill.getName(), bill.getAmount(), tempDate));
	}
	
	private static String printDate(LocalDate tempDate) {
		return tempDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

}
