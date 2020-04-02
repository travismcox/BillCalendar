/**
 * 
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import gui.GUIMain;

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
		GUIMain instance = new GUIMain(listCollection);
		instance.changeToMain();
	}

}
