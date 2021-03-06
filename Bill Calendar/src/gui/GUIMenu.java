/**
 * 
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author traviscox
 *
 */
public class GUIMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6373594904327308730L;
	GUIMain frame;
	JButton[] buttonList;
	MenuActionListener[] actionListenerList;
	public GUIMenu(GUIMain frame) {
		this.frame = frame;
	}
	
	protected void initializeBills(JButton[] buttonArray, String[] labelArray, MenuActionListener[] actionListenerArray) {
		setLayout(new GridLayout(labelArray.length, 1));
		for(int i = 0; i < labelArray.length; i++) {
			initializeButton(buttonArray[i], labelArray[i], actionListenerArray[i]);
		}
	}
	
	private void initializeButton(JButton button, String label, MenuActionListener listener) {
		button = new JButton(label);
		button.addActionListener(listener);
		add(button);
	}

	protected abstract class MenuActionListener implements ActionListener{};
}
