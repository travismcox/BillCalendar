/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author traviscox
 *
 */
public abstract class FileAccess {

	/**
	 * 
	 */
	public FileAccess() {}

	public static void readFile(ListCollection listCollection) throws IOException {
		readBills(listCollection);
		readIncome(listCollection);
	}
	
	private static void readIncome(ListCollection listCollection) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(Utility.incomeFileName));
		char tempChar;
		int value;
		while((value = reader.read()) != -1) {
			tempChar = (char) value;
			switch(tempChar) {
			//case 'M': listCollection.getListMonthlyIncome().add(new MonthlyIncome(reader));
			//		break;
			case 'W': listCollection.getListWeeklyIncome().add(new WeeklyIncome(reader));
					break;
			//case 'O': listCollection.getListOneTimeIncome().add(new OneTimeIncome(reader));
			//		break;
			//case 'L': listCollection.getListLimitedIncome().add(new LimitedMonthlyIncome(reader));
			//		break;
			//case 'A': listCollection.getListAnnualIncome().add(new AnnualIncome(reader));
			//	break;
			}
		}
	}

	private static void readBills(ListCollection listCollection) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(Utility.billFileName));
		char tempChar;
		int value;
		while((value = reader.read()) != -1) {
			tempChar = (char) value;
			switch(tempChar) {
			case 'M': listCollection.getListMonthlyBill().add(new MonthlyBill(reader));
					break;
			case 'W': listCollection.getListWeeklyBill().add(new WeeklyBill(reader));
					break;
			case 'O': listCollection.getListOneTimeBill().add(new OneTimeBill(reader));
					break;
			case 'L': listCollection.getListLimitedBill().add(new LimitedMonthlyBill(reader));
					break;
			case 'A': listCollection.getListAnnualBill().add(new AnnualBill(reader));
				break;
			}
		}
	}

	public static void saveToFile(ListCollection listCollection) throws IOException {
		writeBills(listCollection);
		writeIncome(listCollection);
	}

	private static void writeIncome(ListCollection listCollection) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(Utility.billFileName));
		monthlyIncomeToFile(listCollection.getListMonthlyBill(), writer);
		weeklyIncomeToFile(listCollection.getListWeeklyBill(), writer);
		oneTimeIncomeToFile(listCollection.getListOneTimeBill(), writer);
		limitedIncomeToFile(listCollection.getListLimitedBill(), writer);
		annualIncomeToFile(listCollection.getListLimitedBill(), writer);
		writer.flush();
		writer.close();
	}

	private static void annualIncomeToFile(ArrayList<LimitedMonthlyBill> listLimitedBill, BufferedWriter writer) {
		// TODO Auto-generated method stub
		
	}

	private static void limitedIncomeToFile(ArrayList<LimitedMonthlyBill> listLimitedBill, BufferedWriter writer) {
		// TODO Auto-generated method stub
		
	}

	private static void oneTimeIncomeToFile(ArrayList<OneTimeBill> listOneTimeBill, BufferedWriter writer) {
		// TODO Auto-generated method stub
		
	}

	private static void weeklyIncomeToFile(ArrayList<WeeklyBill> listWeeklyBill, BufferedWriter writer) {
		// TODO Auto-generated method stub
		
	}

	private static void monthlyIncomeToFile(ArrayList<MonthlyBill> listMonthlyBill, BufferedWriter writer) {
		// TODO Auto-generated method stub
		
	}

	private static void writeBills(ListCollection listCollection) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(Utility.billFileName));
		monthlyBillToFile(listCollection.getListMonthlyBill(), writer);
		weeklyBillToFile(listCollection.getListWeeklyBill(), writer);
		oneTimeBillToFile(listCollection.getListOneTimeBill(), writer);
		limitedBillToFile(listCollection.getListLimitedBill(), writer);
		annualBillToFile(listCollection.getListLimitedBill(), writer);
		writer.flush();
		writer.close();
	}

	private static void annualBillToFile(ArrayList<LimitedMonthlyBill> listLimitedBill, BufferedWriter writer) {
		// TODO Auto-generated method stub
		
	}

	private static void limitedBillToFile(ArrayList<LimitedMonthlyBill> listLimited, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listLimited.size(); i++) {
			writer.write(listLimited.get(i).toString());
		}
	}

	private static void oneTimeBillToFile(ArrayList<OneTimeBill> listOneTime, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listOneTime.size(); i++) {
			writer.write(listOneTime.get(i).toString());
		}
	}

	private static void weeklyBillToFile(ArrayList<WeeklyBill> listWeekly, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listWeekly.size(); i++) {
			writer.write(listWeekly.get(i).toString());
		}
	}

	private static void monthlyBillToFile(ArrayList<MonthlyBill> listMonthly, BufferedWriter writer) throws IOException {
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
