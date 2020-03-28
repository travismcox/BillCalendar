/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.Utility;

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
		JButton buttonAnnual = new JButton("Annual Bill");
		JButton buttonWeekly = new JButton("Weekly Bill");
		JButton buttonOneTime = new JButton("One Time Bill");
		JButton buttonLimited = new JButton("Limited Monthly Bill");
		JButton buttonBackToMain = new JButton("Back to Main Menu");
		
		buttonMonthly.addActionListener(this);
		buttonAnnual.addActionListener(this);
		buttonWeekly.addActionListener(this);
		buttonOneTime.addActionListener(this);
		buttonLimited.addActionListener(this);
		buttonBackToMain.addActionListener(this);
		
		setLayout(new GridLayout(6,1));
		add(buttonMonthly);
		add(buttonAnnual);
		add(buttonWeekly);
		add(buttonOneTime);
		add(buttonLimited);
		add(buttonBackToMain);
	}
	
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Monthly Bill")) {
            frame.changeToSelect(Utility.MonthlyBill);
        }
        else if(action.equals("Annual Bill")) {
        	frame.changeToSelect(Utility.AnnualBill);
        }
        else if (action.equals("Weekly Bill")) {
            frame.changeToSelect(Utility.WeeklyBill);
        }
        else if (action.equals("One Time Bill")) {
        	frame.changeToSelect(Utility.OneTimeBill);
        }
        else if(action.contentEquals("Limited Monthly Bill")) {
        	frame.changeToSelect(Utility.LimitedBill);
        }
        else if(action.contentEquals("Back to Main Menu")) {
        	frame.changeToMain();
        }
    }
}
