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
public class WeeklyTransaction extends Transaction {

	public WeeklyTransaction(String name, Double amount) {
		super(name, amount);
		// TODO Auto-generated constructor stub
	}
	
	public WeeklyTransaction(BufferedReader reader) throws IOException {
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
