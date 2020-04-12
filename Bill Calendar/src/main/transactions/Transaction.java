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
public class Transaction {

	private String name;
	private Double amount;
	/**
	 * 
	 */
	public Transaction(String name, Double amount) {
		setName(name);
		setAmount(amount);
	}
	public Transaction(BufferedReader reader) throws IOException {
		setName(FileAccess.getStringLength(reader, Integer.parseInt(FileAccess.getStringSpace(reader))));
		setAmount(Double.parseDouble(FileAccess.getStringSpace(reader)));
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return name.length() + " " + name + amount + " ";
	}
	
	public String listToString() {
		return name + " " + amount + " ";
	}

	
}
