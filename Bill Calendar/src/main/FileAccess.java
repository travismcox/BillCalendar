/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.transactions.AnnualTransaction;
import main.transactions.LimitedMonthlyTransaction;
import main.transactions.MonthlyTransaction;
import main.transactions.OneTimeTransaction;
import main.transactions.WeeklyTransaction;
/**
 * @author traviscox
 *
 */
public abstract class FileAccess {

	/**
	 * 
	 */
	public FileAccess() {}

	public static void readFile(CollectionOfListCollections collection) throws IOException {		
		readTransactionsFromFile(collection.getBillListCollection(), Utility.billFileName);
		readTransactionsFromFile(collection.getIncomeListCollection(), Utility.incomeFileName);
	}

	private static void readTransactionsFromFile(ListCollection listCollection, String fileName) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		char tempChar;
		int value;
		while((value = reader.read()) != -1) {
			tempChar = (char) value;
			switch(tempChar) {
			case 'M': listCollection.getListMonthly().add(new MonthlyTransaction(reader));
					break;
			case 'W': listCollection.getListWeekly().add(new WeeklyTransaction(reader));
					break;
			case 'O': listCollection.getListOneTime().add(new OneTimeTransaction(reader));
					break;
			case 'L': listCollection.getListLimited().add(new LimitedMonthlyTransaction(reader));
					break;
			case 'A': listCollection.getListAnnual().add(new AnnualTransaction(reader));
				break;
			}
		}
	}

	public static void saveToFile(CollectionOfListCollections collection) throws IOException {		
		writeTransactionsToFile(collection.getBillListCollection(), Utility.billFileName);
		writeTransactionsToFile(collection.getIncomeListCollection(), Utility.incomeFileName);
	}

	private static void writeTransactionsToFile(ListCollection listCollection, String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		monthlyTransactionToFile(listCollection.getListMonthly(), writer);
		weeklyTransactionToFile(listCollection.getListWeekly(), writer);
		oneTimeTransactionToFile(listCollection.getListOneTime(), writer);
		limitedTransactionToFile(listCollection.getListLimited(), writer);
		annualTransactionToFile(listCollection.getListAnnual(), writer);
		writer.flush();
		writer.close();
	}

	private static void annualTransactionToFile(ArrayList<AnnualTransaction> listAnnual, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listAnnual.size(); i++) {
			writer.write(listAnnual.get(i).toString());
		}
	}

	private static void limitedTransactionToFile(ArrayList<LimitedMonthlyTransaction> listLimited, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listLimited.size(); i++) {
			writer.write(listLimited.get(i).toString());
		}
	}

	private static void oneTimeTransactionToFile(ArrayList<OneTimeTransaction> listOneTime, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listOneTime.size(); i++) {
			writer.write(listOneTime.get(i).toString());
		}
	}

	private static void weeklyTransactionToFile(ArrayList<WeeklyTransaction> listWeekly, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listWeekly.size(); i++) {
			writer.write(listWeekly.get(i).toString());
		}
	}

	private static void monthlyTransactionToFile(ArrayList<MonthlyTransaction> listMonthly, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listMonthly.size(); i++) {
			String test = listMonthly.get(i).toString();
			writer.write(test);
		}
	}

	
	public static void calculatedWeeksToFile(ArrayList<String> results) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(Utility.resultsFileName));
		for(int i = 0; i < results.size(); i++) {
			writer.write(results.get(i).toString() + '\n');
		}
		writer.flush();
		writer.close();
	}

	public static String getStringSpace(BufferedReader reader) throws IOException {
		char tempChar;
		String tempString = "";
		while((tempChar = (char) reader.read()) != ' ') {
			tempString += tempChar;
		}
		
		return tempString;
	}
	
	public static String getStringLength(BufferedReader reader, int length) throws IOException {
		String tempString = "";
		for(int i = 0; i < length; i++) {
			tempString += (char) reader.read();
		}
		
		return tempString;
	}

	public static void consumeNewLine(BufferedReader reader) throws IOException {
		reader.read();
	}
}
