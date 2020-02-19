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

/**
 * @author traviscox
 *
 */
public class GUIMain extends JFrame implements ActionListener{

	/**
	 * 
	 */
	public GUIMain() {
		this.setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		JButton buttonAddBill = new JButton("Add Bill");
		JButton buttonCalculateBills = new JButton("Calculate Bills");
		JButton buttonEditBills = new JButton("Edit Bills");
		JButton buttonExit = new JButton("Exit");
		buttonAddBill.addActionListener(this);
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(4,1));
		panel.add(buttonAddBill);
		panel.add(buttonCalculateBills);
		panel.add(buttonEditBills);
		panel.add(buttonExit);
		getContentPane().add(panel);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Add Bill")) {
            System.out.println("Yes Button pressed!");
        }
        else if (action.equals("No")) {
            System.out.println("No Button pressed!");
        }
    }

}
