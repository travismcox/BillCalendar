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
public class OneTimeTransaction extends Transaction {

	private LocalDate endDate;
	/**
	 * 
	 */
	public OneTimeTransaction(String name, Double amount, LocalDate date) {
		super(name, amount);
		setEndDate(date);
	}
	
	public OneTimeTransaction(BufferedReader reader) throws NumberFormatException, IOException {
		super(reader);
		setEndDate(LocalDate.of(Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader)), Integer.parseInt(FileAccess.getStringSpace(reader))));
		FileAccess.consumeNewLine(reader);
	}
	/**
	 * @return the date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/**
	 * @param date the date to set
	 */
	public void setEndDate(LocalDate date) {
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
		return "" + getEndDate().getYear() + seperator + getEndDate().getMonthValue() + seperator + getEndDate().getDayOfMonth();
	}

	public void edit(String name, Double amount, LocalDate date) {
		super.setName(name);
		super.setAmount(amount);
		setEndDate(date);
	}
}
