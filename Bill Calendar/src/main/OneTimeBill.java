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
		return "oneTime " + super.toString() + " " + date.get(Calendar.YEAR) + " " + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH) + '\n';
	}

}
