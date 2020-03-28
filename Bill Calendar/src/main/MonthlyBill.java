/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author traviscox
 *
 */
public class MonthlyBill extends Bill {

	private int date;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	
	public MonthlyBill(String name, Double amount, int date) {
		super(name, amount);
		setDate(date);
	}
	
	public MonthlyBill(BufferedReader reader) throws IOException {
		super(reader);
		setDate(Integer.parseInt(FileAccess.getStringSpace(reader)));
		FileAccess.consumeNewLine(reader);
	}
	
	public void edit(String name, Double amount, Integer date2) {
		super.setName(name);
		super.setAmount(amount);
		setDate(date);
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
		return "M" + super.toString() + date + " " + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + date;
	}

}
