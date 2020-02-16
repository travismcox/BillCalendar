/**
 * 
 */
package main;

/**
 * @author traviscox
 *
 */
public class MonthlyBill extends Bill {

	private int date;
	/**
	 * @param name
	 * @param amount
	 * @param date
	 */
	
	public MonthlyBill(String name, Double amount, int date) {
		super(name, amount);
		setDate(date);
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
		return "monthly " + super.toString() + " " + date + '\n';
	}

}
