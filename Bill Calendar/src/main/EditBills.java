/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
			case 1: editMonthly(listMonthly, scan);
				break;
			case 2: editWeekly(listWeekly, scan);
				break;
			case 3: editOneTime(listOneTime, scan);
				break;
			case 4: editLimited(listLimited, scan);
				break;
			case 5: quitLoop = true;
				break;
			default: System.out.println("Input Incorrect");
				break;
			}
		}
	}

	private static void editLimited(ArrayList<LimitedMonthlyBill> listLimited, Scanner scan) {
		Boolean correct = false;
		while(!correct) {
			System.out.println("Please select bill to edit");
			for(int i = 0; i < listLimited.size(); i++) {
				System.out.println((i+1) + ") " + listLimited.get(i).getName());
			}
			int selection = scan.nextInt();
			if(selection > 0 && selection <= listLimited.size()) {
				LimitedMonthlyBill selectedBill = listLimited.get(selection-1);
				editName(selectedBill, scan);
				editAmount(selectedBill, scan);
				selectedBill.setDate(editDate(selectedBill.getDate(), scan));
				selectedBill.setEndDate(editGregorianDate(selectedBill.getEndDate(), "End", scan));
				correct = true;
			}
			else {
				System.out.println("Incorrect Input!");
			}
		}
	}

	private static void editOneTime(ArrayList<OneTimeBill> listOneTime, Scanner scan) {
		Boolean correct = false;
		while(!correct) {
			System.out.println("Please select bill to edit");
			for(int i = 0; i < listOneTime.size(); i++) {
				System.out.println((i+1) + ") " + listOneTime.get(i).getName());
			}
			int selection = scan.nextInt();
			if(selection > 0 && selection <= listOneTime.size()) {
				OneTimeBill selectedBill = listOneTime.get(selection-1);
				editName(selectedBill, scan);
				editAmount(selectedBill, scan);
				selectedBill.setDate(editGregorianDate(selectedBill.getDate(), "One Time", scan));
				correct = true;
			}
			else {
				System.out.println("Incorrect Input!");
			}
		}
		
	}

	private static GregorianCalendar editGregorianDate(GregorianCalendar date, String title, Scanner scan) {
		System.out.print("Would you like to edit bill " + title + "date? Y/N");
		if(scan.next().charAt(0) == 'Y') {
			scan.nextLine();
			date = BillInput.wholeDateInput("New " + title, scan);
		}
		return date;
		
	}

	private static void editWeekly(ArrayList<WeeklyBill> listWeekly, Scanner scan) {
		Boolean correct = false;
		while(!correct) {
			System.out.println("Please select bill to edit");
			for(int i = 0; i < listWeekly.size(); i++) {
				System.out.println((i+1) + ") " + listWeekly.get(i).getName());
			}
			int selection = scan.nextInt();
			if(selection > 0 && selection <= listWeekly.size()) {
				WeeklyBill selectedBill = listWeekly.get(selection-1);
				editName(selectedBill, scan);
				editAmount(selectedBill, scan);
				correct = true;
			}
			else {
				System.out.println("Incorrect Input!");
			}
		}
		
	}

	private static void editMonthly(ArrayList<MonthlyBill> listMonthly, Scanner scan) {
		Boolean correct = false;
		while(!correct) {
			System.out.println("Please select bill to edit");
			for(int i = 0; i < listMonthly.size(); i++) {
				System.out.println((i+1) + ") " + listMonthly.get(i).getName());
			}
			int selection = scan.nextInt();
			if(selection > 0 && selection <= listMonthly.size()) {
				MonthlyBill selectedBill = listMonthly.get(selection-1);
				editName(selectedBill, scan);
				editAmount(selectedBill, scan);
				selectedBill.setDate(editDate(selectedBill.getDate(), scan));
				correct = true;
			}
			else {
				System.out.println("Incorrect Input!");
			}
		}
	}

	private static int editDate(int date, Scanner scan) {
		System.out.print("Would you like to edit bill date? Y/N");
		if(scan.next().charAt(0) == 'Y') {
			scan.nextLine();
			System.out.print("Enter new name:");
			date = scan.nextInt(); 
		}
		return date;
	}

	private static void editAmount(Bill selectedBill, Scanner scan) {
		System.out.print("Would you like to edit bill amount? Y/N");
		if(scan.next().charAt(0) == 'Y') {
			scan.nextLine();
			System.out.print("Enter new name:");
			selectedBill.setAmount(scan.nextDouble());
		}
	}

	private static void editName(Bill selectedBill, Scanner scan) {
		System.out.print("Would you like to edit bill name? Y/N");
		if(scan.next().charAt(0) == 'Y') {
			scan.nextLine();
			System.out.print("Enter new name:");
			selectedBill.setName(scan.next());
		}
	}

}
