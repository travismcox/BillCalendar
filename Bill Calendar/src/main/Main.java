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

	static ListCollection listCollection;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialize
		listCollection = new ListCollection();
		//Read from file, if it exists
		try {
			FileAccess.readFile(listCollection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		EditBills.autoDelete(listCollection);
		
		
		//Main menu
		GUIMain instance = new GUIMain();
		instance.openMainMenu();
		instance.run();
		//new GUIAddBill();
		Scanner scan = new Scanner(System.in);
		Boolean quit = false;
		/*while(!quit) {
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
		}*/
		
		//Quit protocol
		try {
			System.out.println("Here");
			FileAccess.saveToFile(listCollection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
