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
public class LimitedMonthlyBill extends Bill {

	private GregorianCalendar endDate;
	private int date;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	public LimitedMonthlyBill(String name, Double amount, int date, GregorianCalendar endDate) {
		super(name, amount);
		setDate(date);
		setEndDate(endDate);
	}
	
	public LimitedMonthlyBill(BufferedReader reader) throws IOException {
		super(reader);
		setDate(Integer.parseInt(FileAccess.getStringSpace(reader)));
		setEndDate(new GregorianCalendar(Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader))));
		FileAccess.consumeNewLine(reader);
	}
	/**
	 * @return the endDate
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "L" + super.toString() + getDate() + " " + getFullDate(' ') + " " + '\n';
	}

	public String listToString() {
		return super.toString() + " " + getDate() + " " + getFullDate('/');
	}
	
	private String getFullDate(char seperator) {
		return "" + getEndDate().get(Calendar.YEAR) + seperator + (getEndDate().get(Calendar.MONTH)) + seperator + getEndDate().get(Calendar.DAY_OF_MONTH);
	}

	public void edit(String name, Double amount, Integer recurringDate, GregorianCalendar endDate) {
		super.setName(name);
		super.setAmount(amount);
		setDate(recurringDate);
		setEndDate(endDate);
	}
	
}
