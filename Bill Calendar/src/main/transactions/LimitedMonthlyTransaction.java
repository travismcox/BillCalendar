/**
 * 
 */
package main.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

import main.FileAccess;

/**
 * @author traviscox
 *
 */
public class LimitedMonthlyTransaction extends Transaction {

	private LocalDate endDate;
	private int recurringDate;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	public LimitedMonthlyTransaction(String name, Double amount, int date, LocalDate endDate) {
		super(name, amount);
		setRecurringDate(date);
		setEndDate(endDate);
	}
	
	public LimitedMonthlyTransaction(BufferedReader reader) throws IOException {
		super(reader);
		setRecurringDate(Integer.parseInt(FileAccess.getStringSpace(reader)));
		setEndDate(LocalDate.of(Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader))));
		FileAccess.consumeNewLine(reader);
	}
	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
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
		return "" + getEndDate().getYear() + seperator + getEndDate().getMonthValue() + seperator + getEndDate().getDayOfMonth();
	}

	public void edit(String name, Double amount, Integer recurringDate, LocalDate endDate) {
		super.setName(name);
		super.setAmount(amount);
		setRecurringDate(recurringDate);
		setEndDate(endDate);
	}
	
}
