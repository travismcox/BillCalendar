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
	public FileAccess() {
		// TODO Auto-generated constructor stub
	}

	public static void readFile(ListCollection listCollection) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(Utility.billFileName));
		char tempChar;
		int value;
		while((value = reader.read()) != -1) {
			tempChar = (char) value;
			switch(tempChar) {
			case 'M': listCollection.getListMonthly().add(new MonthlyBill(reader));
					break;
			case 'W': listCollection.getListWeekly().add(new WeeklyBill(reader));
					break;
			case 'O': listCollection.getListOneTime().add(new OneTimeBill(reader));
					break;
			case 'L': listCollection.getListLimited().add(new LimitedMonthlyBill(reader));
					break;
			}
		}
	}
	
	public static void saveToFile(ListCollection listCollection) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(Utility.billFileName));
		monthlyToFile(listCollection.getListMonthly(), writer);
		weeklyToFile(listCollection.getListWeekly(), writer);
		oneTimeToFile(listCollection.getListOneTime(), writer);
		limitedToFile(listCollection.getListLimited(), writer);
		writer.flush();
		writer.close();
	}

	private static void limitedToFile(ArrayList<LimitedMonthlyBill> listLimited, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listLimited.size(); i++) {
			writer.write(listLimited.get(i).toString());
		}
	}

	private static void oneTimeToFile(ArrayList<OneTimeBill> listOneTime, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listOneTime.size(); i++) {
			writer.write(listOneTime.get(i).toString());
		}
	}

	private static void weeklyToFile(ArrayList<WeeklyBill> listWeekly, BufferedWriter writer) throws IOException {
		for(int i = 0; i < listWeekly.size(); i++) {
			writer.write(listWeekly.get(i).toString());
		}
	}

	private static void monthlyToFile(ArrayList<MonthlyBill> listMonthly, BufferedWriter writer) throws IOException {
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
