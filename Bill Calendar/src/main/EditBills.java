/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import main.transactions.LimitedMonthlyTransaction;
import main.transactions.MonthlyTransaction;
import main.transactions.OneTimeTransaction;
import main.transactions.Transaction;
import main.transactions.WeeklyTransaction;

/**
 * @author traviscox
 *
 */
public abstract class EditBills {

	/**
	 * 
	 */
	public EditBills() {
		// TODO Auto-generated constructor stub
	}

	public static void autoDelete(ListCollection listCollection) {
		for(int i = 0; i < listCollection.getListOneTimeBill().size(); i++) {
			if(listCollection.getListOneTimeBill().get(i).getDate().before(new GregorianCalendar())) {
				listCollection.getListOneTimeBill().remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < listCollection.getListLimitedBill().size(); i++) {
			if(listCollection.getListLimitedBill().get(i).getEndDate().before(new GregorianCalendar())) {
				listCollection.getListLimitedBill().remove(i);
				i--;
			}
		}
	}
}
