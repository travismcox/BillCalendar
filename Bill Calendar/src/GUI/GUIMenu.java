/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.Utility;

/**
 * @author traviscox
 *
 */
public class GUIMenu extends JPanel {

	GUIMain frame;
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
