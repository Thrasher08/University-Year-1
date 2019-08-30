import javax.swing.*;

/**
 * 
 * @author 160420209	Harry Baldwin
 *
 */

public class GUI extends JEditorPane { // Class to create a new display

	public static void main(String[] args) {

		display display = new display();
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setSize(1920, 1080);
		display.setVisible(true);

	}

}