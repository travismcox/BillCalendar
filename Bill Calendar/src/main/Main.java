/**
 * 
 */
package main;

import java.io.IOException;

import gui.GUIMain;

/**
 * @author traviscox
 *
 */
public class Main {

	static CollectionOfListCollections collection;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialize
		collection = new CollectionOfListCollections();
	
		//Read from file, if it exists
		try {
			FileAccess.readFile(collection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		EditBills.autoDelete(collection);
		
		
		//Main menu
		GUIMain instance = new GUIMain(collection);
		instance.changeToMain();
	}

}
