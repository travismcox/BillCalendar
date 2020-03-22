/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author traviscox
 *
 */
public class OneTimeBill extends Bill {

	private GregorianCalendar date;
	/**
	 * 
	 */
	public OneTimeBill(String name, Double amount, GregorianCalendar date) {
		super(name, amount);
		setDate(date);
	}
	
	public OneTimeBill(BufferedReader reader) throws NumberFormatException, IOException {
		super(reader);
		setDate(new GregorianCalendar(Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader))));
		FileAccess.consumeNewLine(reader);
	}
	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "O" + super.toString() + getFullDate(' ') + " " + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + getFullDate('/');
	}

	private String getFullDate(char seperator) {
		return "" + getDate().get(Calendar.YEAR) + seperator + (getDate().get(Calendar.MONTH)) + seperator + getDate().get(Calendar.DAY_OF_MONTH);
	}
}
