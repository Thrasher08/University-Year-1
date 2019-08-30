import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author 160420209	Harry Baldwin
 *
 */

public class ToolBar extends JPanel {

	private JButton home = new JButton("Home");
	private JButton refresh = new JButton("Reload");
	private JButton fwd = new JButton("Forward");
	private JButton bwd = new JButton("Backward");
	private JTextField navField = new JTextField(); // Text field for URL

	// Sets the home button
	public void setHome(JButton home) {
		this.home = home;
	}

	// Sets the refresh button
	public void setRefresh(JButton refresh) {
		this.refresh = refresh;
	}

	// Adds all elements to the ToolBar
	public ToolBar(WebPane page) {

		add(home);
		add(refresh);
		add(navField);
		setNavField(navField);
		add(bwd);
		add(fwd);
		actionListenerCalls(page);

	}

	// Sets the navField
	public void setNavField(JTextField navField) {
		this.navField = navField;
		navField.setColumns(50); // Sets size of the text field
	}

	// Sets the URL text
	public void setURLText(String url) {
		navField.setText(url);
	}

	// Response to URL
	private void actionListenerCalls(WebPane page) {

		// navField Action Listener: If a URL is typed in and the enter button
		// is pressed
		navField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// http:// is not required to be typed in and is added
				// automatically
				page.loadData("http://" + e.getActionCommand());
			}
		});

		// Home button Action Listener: If home is clicked the browser will
		// return to the homepage
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.loadHome();
				navField.setText(page.getCurrent());
			}
		});

		// Refresh button Action Listener: If refresh is clicked the webpage
		// will refresh
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.loadRefresh(page.getCurrent());
				navField.setText(page.getCurrent());
			}
		});

		// Backward button Action Listener: If home is clicked the browser will
		// return to previous page
		bwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.loadBwd();
				navField.setText(page.getCurrent());
			}
		});

		// Forward button Action Listener: If home is clicked the browser will
		// return to most recent page
		fwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.loadFwd(e.getActionCommand());
				navField.setText(page.getCurrent());
			}
		});
	}

}