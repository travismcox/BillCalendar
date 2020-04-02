/**
 * 
 */
package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author traviscox
 *
 */
public class GUIResults extends JFrame {
	
	public GUIResults(ArrayList<String> results) {
		JTextArea text = new JTextArea();
		for(int i = 0; i < results.size(); i++) {
			text.append(results.get(i) + '\n');
		}
		
		JScrollPane resultsPanel = new JScrollPane(text);
		
		setSize(300, 300);
		
		add(resultsPanel);
		
		setVisible(true);
	}
}
