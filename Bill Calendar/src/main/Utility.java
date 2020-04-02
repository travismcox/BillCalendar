package main;

import java.util.Arrays;

public class Utility {
	public static String billFileName = "bills.txt";
	public static String resultsFileName = "calculatedBills.txt";
	public static String incomeFileName = "income.txt";
	public static Double FourDouble = 4.0;
	public static Integer FourInteger = 4;
	public static Integer MonthlyBillValue = 0;
	public static Integer AnnualBillValue = 1;
	public static Integer WeeklyBillValue = 2;
	public static Integer OneTimeBillValue = 3;
	public static Integer LimitedBillValue = 4;
	public static String[] Months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static String[] Days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public static String AddBill = "Add Bill";
	public static String GoBackAdd = "Go Back to Add";
	public static String GoBackSelect = "Go Back to Selct";
	public static String GoBackMenu = "Go Back to Menu";
	public static String Enter = "Enter";
	public static String Edit = "Edit";
	public static String Name = "Name";
	public static String Amount = "Amount";
	public static String Year = "Year (YYYY)";
	public static String Month = "Month";
	public static String Day = "Day";
	public static String RecurringDate = "Recurring Date";
	public static String EmptyField = "";
	public static Integer InitialIndex = 0;
	public static String BackToMainMenu = "Back To Main Menu";
	public static String MonthlyBill = "Monthly Bill";
	public static String AnnualBill = "Annual Bill";
	public static String WeeklyBill = "Weekly Bill";
	public static String OneTimeBill = "One Time Bill";
	public static String LimitedBill = "Limited Bill";
	public static String CalculateBills = "Calculate Bills";
	public static String EditBill = "Edit Bill";
	public static String Exit = "Exit";
	public static String[] labelListBill = {Utility.MonthlyBill, Utility.AnnualBill, Utility.WeeklyBill, Utility.OneTimeBill, Utility.LimitedBill, Utility.BackToMainMenu};
	public static String[] labelListMainMenu = {Utility.AddBill, Utility.CalculateBills, Utility.EditBill, Utility.Exit};
}
