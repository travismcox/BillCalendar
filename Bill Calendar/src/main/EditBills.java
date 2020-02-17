/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public static void startEdit(ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime, ArrayList<LimitedMonthlyBill> listLimited, Scanner scan) {
		System.out.println("Select which type of bill to edit");
		System.out.println("1) Monthly\n2) Weekly\n3) One Time\n4) Limited Monthly\n5) Go Back");
		Boolean quitLoop = false;
		while(!quitLoop) {
			switch(scan.nextInt()) {
			case 1: //monthly
				break;
			case 2: //weekly
				break;
			case 3: //one time
				break;
			case 4: //limited
				break;
			case 5: quitLoop = true;
				break;
			default: System.out.println("Input Incorrect");
				break;
			}
		}
	}

}
