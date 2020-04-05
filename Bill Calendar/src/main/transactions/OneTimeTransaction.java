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
public class OneTimeTransaction extends Transaction {

	private GregorianCalendar endDate;
	/**
	 * 
	 */
	public OneTimeTransaction(String name, Double amount, GregorianCalendar date) {
		super(name, amount);
		setEndDate(date);
	}
	
	public OneTimeTransaction(BufferedReader reader) throws NumberFormatException, IOException {
		super(reader);
		setEndDate(new GregorianCalendar(Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader))));
		FileAccess.consumeNewLine(reader);
	}
	/**
	 * @return the date
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}
	/**
	 * @param date the date to set
	 */
	public void setEndDate(GregorianCalendar date) {
		this.endDate = date;
	}
	@Override
	public String toString() {
		return "O" + super.toString() + getFullDate(' ') + " " + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + getFullDate('/');
	}

	private String getFullDate(char seperator) {
		return "" + getEndDate().get(Calendar.YEAR) + seperator + (getEndDate().get(Calendar.MONTH)) + seperator + getEndDate().get(Calendar.DAY_OF_MONTH);
	}

	public void edit(String name, Double amount, GregorianCalendar date) {
		super.setName(name);
		super.setAmount(amount);
		setEndDate(date);
	}
}
