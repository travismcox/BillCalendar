/**
 * 
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import GUI.GUIMain;

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
		ListCollection listCollection = new ListCollection();
		//Read from file, if it exists
		try {
			FileAccess.readFile(listCollection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		EditBills.autoDelete(listCollection);
		
		
		//Main menu
		new GUIMain();
		Scanner scan = new Scanner(System.in);
		Boolean quit = false;
		while(!quit) {
			System.out.print("Main Menu:\n 1)Add Bill\n 2)Calculate weeks\n 3)Edit Bills\n 4)Quit\n");
			switch(scan.nextInt()) {
			case 1: BillInput.startBillInput(listCollection, scan);
					break;
			case 2: CalculateWeeks.startCalculateWeeks(listCollection, scan);
					break;
			case 3: EditBills.startEdit(listCollection, scan);
					break;
			case 4: quit = true;
					break;
			default: System.out.println("Input error");
					break;
			}
		}
		
		//Quit protocol
		try {
			FileAccess.saveToFile(listCollection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
