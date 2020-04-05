/**
 * 
 */
package main.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import main.FileAccess;

/**
 * @author traviscox
 *
 */
public class LimitedMonthlyTransaction extends Transaction {

	private GregorianCalendar endDate;
	private int recurringDate;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	public LimitedMonthlyTransaction(String name, Double amount, int date, GregorianCalendar endDate) {
		super(name, amount);
		setRecurringDate(date);
		setEndDate(endDate);
	}
	
	public LimitedMonthlyTransaction(BufferedReader reader) throws IOException {
		super(reader);
		setRecurringDate(Integer.parseInt(FileAccess.getStringSpace(reader)));
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
	public int getRecurringDate() {
		return recurringDate;
	}
	/**
	 * @param date the date to set
	 */
	public void setRecurringDate(int date) {
		this.recurringDate = date;
	}
	@Override
	public String toString() {
		return "L" + super.toString() + getRecurringDate() + " " + getFullDate(' ') + " " + '\n';
	}

	public String listToString() {
		return super.toString() + " " + getRecurringDate() + " " + getFullDate('/');
	}
	
	private String getFullDate(char seperator) {
		return "" + getEndDate().get(Calendar.YEAR) + seperator + (getEndDate().get(Calendar.MONTH)) + seperator + getEndDate().get(Calendar.DAY_OF_MONTH);
	}

	public void edit(String name, Double amount, Integer recurringDate, GregorianCalendar endDate) {
		super.setName(name);
		super.setAmount(amount);
		setRecurringDate(recurringDate);
		setEndDate(endDate);
	}
	
}
