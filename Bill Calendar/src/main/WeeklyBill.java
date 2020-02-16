/**
 * 
 */
package main;

/**
 * @author traviscox
 *
 */
public class WeeklyBill extends Bill {

	public WeeklyBill(String name, Double amount) {
		super(name, amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "weekly " + super.toString() + '\n';
	}

}
