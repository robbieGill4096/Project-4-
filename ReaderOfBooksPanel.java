import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReaderOfBooksPanel extends JPanel {
// serve as the top level panel for the GUI
private LibraryPanel libraryPanel;	
private ReaderPanel ReaderPanel;

public ReaderOfBooksPanel() {
	libraryPanel = new LibraryPanel(new bookButtonListener());
	ReaderPanel = new ReaderPanel();
	
	this.setLayout(new BorderLayout());
	this.add(libraryPanel, BorderLayout.WEST);
	this.add(ReaderPanel, BorderLayout.CENTER);
	
	this.setBorder(BorderFactory.createTitledBorder("ReaderOfBooksPanel"));
	
	
}
//book is clicked and loads book information/text.
public class bookButtonListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
			BookButton bookButton = (BookButton)(arg0.getSource());
			ReaderPanel.loadBook(bookButton.getBook());
	}
		
	}
}
