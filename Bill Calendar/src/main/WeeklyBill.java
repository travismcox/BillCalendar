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
public class WeeklyBill extends Bill {

	public WeeklyBill(String name, Double amount) {
		super(name, amount);
		// TODO Auto-generated constructor stub
	}
	
	public WeeklyBill(BufferedReader reader) throws IOException {
		super(reader);
		FileAccess.consumeNewLine(reader);
	}

	@Override
	public String toString() {
		return "W" + super.toString() + '\n';
	}
	
	public String listToString() {
		return super.toString();
	}

}
