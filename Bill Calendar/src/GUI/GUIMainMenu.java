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
public class GUIMainMenu extends JPanel implements ActionListener {

	GUIMain frame;
	public GUIMainMenu(GUIMain frame) {
		this.frame = frame;
		frame.getContentPane().removeAll();
		
		JPanel panelAddBill = new JPanel();
		
		JButton buttonAddBill = new JButton("Add Bill");
		JButton buttonCalculateBills = new JButton("Calculate Bills");
		JButton buttonEditBills = new JButton("Edit Bills");
		JButton buttonExit = new JButton("Exit");
		buttonAddBill.addActionListener(this);
		buttonCalculateBills.addActionListener(this);
		buttonEditBills.addActionListener(this);
		buttonExit.addActionListener(this);
		
		panelAddBill.setLayout(new GridLayout(4,1));
		panelAddBill.add(buttonAddBill);
		panelAddBill.add(buttonCalculateBills);
		panelAddBill.add(buttonEditBills);
		panelAddBill.add(buttonExit);
		
		frame.getContentPane().add(panelAddBill);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("Add Bill")) {
            new GUIAddBill(frame);
        }
        else if (action.equals("Calculate Bills")) {
            
        }
        else if (action.equals("Edit Bills")) {
        	
        }
        else if (action.equals("Exit")) {
        	
        }
	}

}
