/**
 * 
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author traviscox
 *
 */
public class Main {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ArrayList<MonthlyBill> listMonthly, ArrayList<WeeklyBill> listWeekly, ArrayList<OneTimeBill> listOneTime
		//Initialize
		ArrayList<MonthlyBill> listMonthly = new ArrayList<MonthlyBill>(); 
		ArrayList<WeeklyBill> listWeekly = new ArrayList<WeeklyBill>(); 
		ArrayList<OneTimeBill> listOneTime = new ArrayList<OneTimeBill>();
		//Read from file, if it exists
		try {
			FileAccess.readFile(listMonthly, listWeekly, listOneTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//Main menu
		Scanner scan = new Scanner(System.in);
		Boolean quit = false;
		while(!quit) {
			System.out.print("Main Menu:\n 1)Add Bill\n 2)Calculate weeks\n 3)Quit\n");
			switch(scan.nextInt()) {
			case 1: new BillInput(listMonthly, listWeekly, listOneTime, scan);
					break;
			case 2: new CalculateWeeks(listMonthly, listWeekly, listOneTime, scan);
					break;
			case 3: quit = true;
					break;
			default: System.out.println("Input error");
					break;
			}
		}
		
		//Quit protocol
		try {
			FileAccess.saveToFile(listMonthly, listWeekly, listOneTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
