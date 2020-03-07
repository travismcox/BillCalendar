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
public class LimitedMonthlyBill extends Bill {

	private GregorianCalendar endDate;
	private int date;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	public LimitedMonthlyBill(String name, Double amount, int date, GregorianCalendar endDate) {
		super(name, amount);
		setDate(date);
		setEndDate(endDate);
	}
	/**
	 * @return the endDate
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
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
		return "limited " + super.toString() + " " + getDate() + " " + getFullDate(' ') + '\n';
	}

	public String listToString() {
		return super.toString() + " " + getDate() + " " + getFullDate('/');
	}
	
	private String getFullDate(char seperator) {
		return "" + getEndDate().get(Calendar.YEAR) + seperator + (getEndDate().get(Calendar.MONTH)+1) + seperator + getEndDate().get(Calendar.DAY_OF_MONTH);
	}
	
}
