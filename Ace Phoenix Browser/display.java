import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * @author 160420209	Harry Baldwin
 *
 */

public class display extends JFrame { // Class to handle displaying each element

	private WebPane acePB = new WebPane();
	private JScrollPane sPane = new JScrollPane();
	private ToolBar tBar = new ToolBar(acePB);

	// Builds the program window
	public display() {

		setTitle("Ace Phoenix: Browse the Wright way!");
		acePB.setEditable(false);
		add(tBar, BorderLayout.NORTH); // Adds toolbar and displays at the top
		add(sPane);
		sPane.getViewport().add(acePB);
		acePB.loadHome(); // Loads homepage on start
		hyperlinkHandler(acePB, tBar); // Calls method to open hyperlinks
	}

	// Gets the JScrollPane
	public JScrollPane getSPane() {
		return sPane;
	}

	// Adds elements to the the main window (mWindow)
	public void addComponentsToFrame(Container mWindow) {

		mWindow.add(tBar);
		mWindow.add(sPane);
		sPane.getViewport().add(acePB);
		hyperlinkHandler(acePB, tBar);

		// navField.setText("I submit the webpage!");
	}

	// Response to hyperlink click
	public void hyperlinkHandler(WebPane page, ToolBar tBar) {
		acePB.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					page.loadData(e.getURL().toString());
					tBar.setURLText(page.getCurrent());
				}
			}
		});

		// Listens for when the Webpage URL changes and updates automatically
		acePB.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				if (acePB.getPage() != null) {
					tBar.setURLText(acePB.getPage().toString());
				}
			}
		});
	}
}