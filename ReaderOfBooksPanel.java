import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Robbie
 *serve as the top level panel for the GUI
 */
public class ReaderOfBooksPanel extends JPanel {

private LibraryPanel libraryPanel;	
private ReaderPanel ReaderPanel;
/**
 * adds the panel containing the library book buttons and import interface.
 * adds the panel containing the book text and book navigation buttons.
 * 
 */
public ReaderOfBooksPanel() {
	libraryPanel = new LibraryPanel(new bookButtonListener());
	ReaderPanel = new ReaderPanel();
	
	this.setLayout(new BorderLayout());
	this.add(libraryPanel, BorderLayout.WEST);
	this.add(ReaderPanel, BorderLayout.CENTER);
	
	this.setBorder(BorderFactory.createTitledBorder("ReaderOfBooksPanel"));
	
	
}
/**
 * 
 * calls a book button to load a book
 *
 */
public class bookButtonListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			BookButton bookButton = (BookButton)(arg0.getSource());
			ReaderPanel.loadBook(bookButton.getBook());
		
	}
		
	}
}
