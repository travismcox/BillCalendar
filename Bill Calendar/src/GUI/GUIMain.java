/**
 * 
 */
package GUI;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author traviscox
 *
 */
public class GUIMain extends JFrame{

	/**
	 * 
	 */
	public GUIMain() {
		this.setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		GUIMainMenu mainMenu = new GUIMainMenu();
		getContentPane().add(mainMenu.mainMenuPanel());
		
		//pack();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		setVisible(true);
	}
	
	class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
			if (action.equals("Add Bill")) {
	            //setVisible(false);
	            GUIAddBill addBill = new GUIAddBill();
	            //addBill.addBillPanel();
	            getContentPane().removeAll();
	            getContentPane().add(addBill.addBillPanel());
	            setVisible(true);
	        }
	        else if (action.equals("Calculate Bills")) {
	            
	        }
	        else if (action.equals("Edit Bills")) {
	        	
	        }
	        else if (action.equals("Exit")) {
	        	
	        }
		}
	}
	
	class AddBillActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
	        String action = ae.getActionCommand();
	        if (action.equals("Monthly Bill")) {
	            
	            setVisible(false);
	        }
	        else if (action.equals("Weekly Bill")) {
	            System.out.println("No Button pressed!");
	        }
	        else if (action.equals("One Time Bill")) {
	        	
	        }
	        else if(action.contentEquals("Limited Monthly Bills")) {
	        	
	        }
	    }
	}

}
