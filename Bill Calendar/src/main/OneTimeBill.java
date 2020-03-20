/**
 * 
 */
package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author traviscox
 *
 */
public class OneTimeBill extends Bill {

	private GregorianCalendar date;
	/**
	 * 
	 */
	public OneTimeBill(String name, Double amount, GregorianCalendar date) {
		super(name, amount);
		setDate(date);
	}
	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "oneTime " + super.toString() + " " + getFullDate(' ') + '\n';
	}
	
	public String listToString() {
		return super.toString() + " " + getFullDate('/');
	}

	private String getFullDate(char seperator) {
		return "" + getDate().get(Calendar.YEAR) + seperator + (getDate().get(Calendar.MONTH)) + seperator + getDate().get(Calendar.DAY_OF_MONTH);
	}
}
