/**
 * 
 */
package main.transactions;

import java.io.BufferedReader;
import java.io.IOException;

import main.FileAccess;

/**
 * @author traviscox
 *
 */
public class AnnualTransaction extends Transaction {

	private int recurringMonth;
	private int recurringDate;
	/**
	 * @param name
	 * @param amount
	 */
	public AnnualTransaction(String name, Double amount, int month, int day) {
		super(name, amount);
		setRecurringMonth(month);
		setRecurringDate(day);
	}
	
	/**
	 * @return the month
	 */
	public int getRecurringMonth() {
		return recurringMonth;
	}

	/**
	 * @param month the month to set
	 */
	public void setRecurringMonth(int month) {
		this.recurringMonth = month;
	}

	/**
	 * @return the day
	 */
	public int getRecurringDate() {
		return recurringDate;
	}

	/**
	 * @param day the day to set
	 */
	public void setRecurringDate(int day) {
		this.recurringDate = day;
	}

	/**
	 * @param reader
	 * @throws IOException
	 */
	public AnnualTransaction(BufferedReader reader) throws IOException {
		super(reader);
		setRecurringMonth(Integer.parseInt(FileAccess.getStringSpace(reader)));
		setRecurringDate(Integer.parseInt(FileAccess.getStringSpace(reader)));
	}
	
	@Override
	public String toString() {
		return "A" + super.toString() + recurringMonth + " " + recurringMonth + " " + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + recurringMonth + " " + recurringMonth;
	}
	
	public void edit(String name, Double amount, int month, int day) {
		super.setName(name);
		super.setAmount(amount);
		setRecurringMonth(month);
		setRecurringDate(day);
	}

}
