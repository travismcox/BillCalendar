/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author traviscox
 *
 */
public class GUIEditBill extends JPanel implements ActionListener {
	GUIMain frame;
	public GUIEditBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		
		JButton buttonMonthly = new JButton("Monthly Bill");
		JButton buttonWeekly = new JButton("Weekly Bill");
		JButton buttonOneTime = new JButton("One Time Bill");
		JButton buttonLimited = new JButton("Limited Monthly Bill");
		JButton buttonBackToMain = new JButton("Back to Main Menu");
		
		buttonMonthly.addActionListener(this);
		buttonWeekly.addActionListener(this);
		buttonOneTime.addActionListener(this);
		buttonLimited.addActionListener(this);
		buttonBackToMain.addActionListener(this);
		
		setLayout(new GridLayout(5,1));
		add(buttonMonthly);
		add(buttonWeekly);
		add(buttonOneTime);
		add(buttonLimited);
		add(buttonBackToMain);
	}
	
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Monthly Bill")) {
            frame.changeToSelectMonthly();
        }
        else if (action.equals("Weekly Bill")) {
            frame.changeToSelectWeekly();
        }
        else if (action.equals("One Time Bill")) {
        	frame.changeToSelectOneTime();
        }
        else if(action.contentEquals("Limited Monthly Bill")) {
        	frame.changeToSelectLimited();
        }
        else if(action.contentEquals("Back to Main Menu")) {
        	frame.changeToMain();
        }
    }
}
