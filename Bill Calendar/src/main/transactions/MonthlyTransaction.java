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
public class MonthlyTransaction extends Transaction {

	private int recurringDate;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	
	public MonthlyTransaction(String name, Double amount, int recurringDate) {
		super(name, amount);
		setRecurringDate(recurringDate);
	}
	
	public MonthlyTransaction(BufferedReader reader) throws IOException {
		super(reader);
		setRecurringDate(Integer.parseInt(FileAccess.getStringSpace(reader)));
		FileAccess.consumeNewLine(reader);
	}
	
	public void edit(String name, Double amount, Integer date2) {
		super.setName(name);
		super.setAmount(amount);
		setRecurringDate(recurringDate);
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
	public void setRecurringDate(int recurringDate) {
		this.recurringDate = recurringDate;
	}

	@Override
	public String toString() {
		return "M" + super.toString() + recurringDate + " " + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + recurringDate;
	}

}
