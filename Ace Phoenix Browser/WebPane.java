import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.*;
import javax.swing.text.Document;

/**
 * 
 * @author 160420209	Harry Baldwin
 *
 */

public class WebPane extends JEditorPane { // Class to load webpages

	private String home;
	public LinkedList<String> histChain = new LinkedList<String>();
	public Stack histStackBwd = new Stack<String>();
	public Stack histStackFwd = new Stack<String>();

	// Gets Current Webpage
	public String getCurrent() {
		String currentPage = new String(getPage().toString());
		return currentPage;
	}

	// Loads webpage
	public void loadData(String text) {

		try {
			setPage(text);
			histStackBwd.addElement(text); // Adds loaded webpage to history
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hey don't give up hope. Try removing 'http://' and try again",
					"Webpage Read Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Loads homepage
	public void loadHome() {

		try {
			// File Reader & Scanner to find and ready config.txt
			FileReader hPage = new FileReader("config.txt");
			Scanner sIn = new Scanner(hPage);
			home = sIn.next();
			setPage(home);
			histStackBwd.add(home); // Adds loaded webpage to history
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "It seems we can't go home right now. Refresh the page and try again",
					"Webpage Refresh Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Refreshes current webpage
	public void loadRefresh(String refresh) {
		getDocument().putProperty(Document.StreamDescriptionProperty, null);

		try {
			setPage(refresh);
			histStackBwd.add(refresh);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hey don't give up hope. Refresh the page and try again",
					"Webpage Refresh Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Reloads previous webpages
	public void loadBwd() {

		try {
			histStackFwd.push(histStackBwd.pop());
			setPage(histStackBwd.peek().toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"You haven't got any more back pages! Gather your thoughts and try again later",
					"Webpage Read Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Reloads webpages towards current page if loaded backwards
	public void loadFwd(String fwd) {

		try {
			histStackBwd.push(histStackFwd.pop());
			setPage(histStackBwd.peek().toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"You haven't got any page to forward to! Gather your thoughts and try again later",
					"Webpage Read Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}