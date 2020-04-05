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

	public static void autoDelete(CollectionOfListCollections collection) {
		autoDeleteTransactions(collection.getBillListCollection());
		autoDeleteTransactions(collection.getIncomeListCollection());
	}

	private static void autoDeleteTransactions(ListCollection listCollection) {
		for(int i = 0; i < listCollection.getListOneTime().size(); i++) {
			if(listCollection.getListOneTime().get(i).getEndDate().before(new GregorianCalendar())) {
				listCollection.getListOneTime().remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < listCollection.getListLimited().size(); i++) {
			if(listCollection.getListLimited().get(i).getEndDate().before(new GregorianCalendar())) {
				listCollection.getListLimited().remove(i);
				i--;
			}
		}
	}
}
