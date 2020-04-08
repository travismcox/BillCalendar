/**
 * 
 */
package main.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.DayOfWeek;

import main.FileAccess;

/**
 * @author traviscox
 *
 */
public class WeeklyTransaction extends Transaction {

	private DayOfWeek dayOfWeek;
	public WeeklyTransaction(String name, Double amount, DayOfWeek dayOfWeek) {
		super(name, amount);
		setDayOfWeek(dayOfWeek);
	}
	
	public WeeklyTransaction(BufferedReader reader) throws IOException {
		super(reader);
		setDayOfWeek(DayOfWeek.of(Integer.parseInt(FileAccess.getStringSpace(reader))));
		FileAccess.consumeNewLine(reader);
	}
	
	public void edit(String name, Double amount, DayOfWeek dayOfWeek)
	{
		super.setName(name);
		super.setAmount(amount);
		setDayOfWeek(dayOfWeek);
	}

	/**
	 * @return the dayOfWeek
	 */
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Override
	public String toString() {
		return "W" + super.toString() + '\n';
	}
	
	public String listToString() {
		return super.toString();
	}

}
