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
public class WeeklyIncome extends Transaction {

	/**
	 * @param name
	 * @param amount
	 */
	public WeeklyIncome(String name, Double amount) {
		super(name, amount);
	}

	/**
	 * @param reader
	 * @throws IOException
	 */
	public WeeklyIncome(BufferedReader reader) throws IOException {
		super(reader);
		FileAccess.consumeNewLine(reader);
	}
	
	public void edit(String name, Double amount)
	{
		super.setName(name);
		super.setAmount(amount);
	}

	@Override
	public String toString() {
		return "W" + super.toString() + '\n';
	}
	
	public String listToString() {
		return super.toString();
	}

}
