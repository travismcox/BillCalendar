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
public class GUIAddBill extends JPanel implements ActionListener {

	GUIMain frame;
	public GUIAddBill(GUIMain frame) {
		this.frame = frame;
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		JPanel panelAddBill = new JPanel();
		
		JButton buttonMonthly = new JButton("Monthly Bill");
		JButton buttonWeekly = new JButton("Weekly Bill");
		JButton buttonOneTime = new JButton("One Time Bill");
		JButton buttonLimited = new JButton("Limited Monthly Bill");
		buttonMonthly.addActionListener(this);
		buttonWeekly.addActionListener(this);
		buttonOneTime.addActionListener(this);
		buttonLimited.addActionListener(this);
		
		panelAddBill.setLayout(new GridLayout(4,1));
		panelAddBill.add(buttonMonthly);
		panelAddBill.add(buttonWeekly);
		panelAddBill.add(buttonOneTime);
		panelAddBill.add(buttonLimited);
		
		frame.getContentPane().add(panelAddBill);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Monthly Bill")) {
            new GUIMonthlyBill(frame);
        }
        else if (action.equals("Weekly Bill")) {
            new GUIWeeklyBill(frame);
        }
        else if (action.equals("One Time Bill")) {
        	new GUIOneTimeBill(frame);
        }
        else if(action.contentEquals("Limited Monthly Bills")) {
        	
        }
    }

}
