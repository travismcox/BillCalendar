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

	private int month;
	private int day;
	/**
	 * @param name
	 * @param amount
	 */
	public AnnualTransaction(String name, Double amount, int month, int day) {
		super(name, amount);
		setMonth(month);
		setDay(day);
	}
	
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param reader
	 * @throws IOException
	 */
	public AnnualTransaction(BufferedReader reader) throws IOException {
		super(reader);
		setMonth(Integer.parseInt(FileAccess.getStringSpace(reader)));
		setDay(Integer.parseInt(FileAccess.getStringSpace(reader)));
	}
	
	@Override
	public String toString() {
		return "A" + super.toString() + month + " " + day + " " + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + month + " " + day;
	}
	
	public void edit(String name, Double amount, int month, int day) {
		super.setName(name);
		super.setAmount(amount);
		setMonth(month);
		setDay(day);
	}

}
