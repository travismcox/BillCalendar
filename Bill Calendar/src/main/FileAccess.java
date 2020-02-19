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
		String line;
		while((line = reader.readLine()) != null) {
			String words[] = line.split(" ");
			switch(words[0]) {
			case "monthly": listCollection.getListMonthly().add(new MonthlyBill(words[1], Double.parseDouble(words[2]), Integer.parseInt(words[3])));
					break;
			case "weekly": listCollection.getListWeekly().add(new WeeklyBill(words[1], Double.parseDouble(words[2])));
					break;
			case "oneTime": listCollection.getListOneTime().add(new OneTimeBill(words[1], Double.parseDouble(words[2]), new GregorianCalendar(Integer.parseInt(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]))));
					break;
			case "limited": listCollection.getListLimited().add(new LimitedMonthlyBill(words[1], Double.parseDouble(words[2]), Integer.parseInt(words[3]), new GregorianCalendar(Integer.parseInt(words[4]), Integer.parseInt(words[5]), Integer.parseInt(words[6]))));
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
}
