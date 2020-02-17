/**
 * 
 */
package GUI;

import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author traviscox
 *
 */
public class GUIMain extends Frame {

	/**
	 * 
	 */
	public GUIMain() {
		JFrame frame = new JFrame("My First GUI");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setSize(500,500);
	       JButton button = new JButton("Press");
	       JButton buttonAddBill = new JButton("Add Bill");
	      // frame.getContentPane().add(button); // Adds Button to content pane of frame
	       //frame.getContentPane().add(buttonAddBill);
	       
	       setSize(400, 400);
	       
	       Panel panel = new Panel();
	       panel.add(buttonAddBill);
	       //frame.getContentPane().add(panel);
	       add(panel);
	       setVisible(true);
	       
	       //frame.setVisible(true);
	}

}
