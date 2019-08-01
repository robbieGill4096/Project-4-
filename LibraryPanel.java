import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ConstructorProperties;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 * @author Robbie
 *serves as a container class for GUI elements
 *formats panels to store bookButtons
 *creates bookButtons 
 *formats panel to store import buttons
 *creates import buttons
 */
public class LibraryPanel extends JPanel {
	private Library library;
	private ActionListener bookButtonListener;
	private JPanel bookListPanel;
	private JScrollPane bookListScrollPane;
	private JPanel importPanel;
	private JTextField importTextField;
	private JButton importButton;
	public static int numItemsToCreate;
/**
 * 
 * @param actionListener loads an action listener to preform an action in this case the bookButton listener to load a books content.
 */
	public LibraryPanel(ActionListener actionListener) {
		this.bookButtonListener = actionListener;

		
		bookListPanel = new JPanel();
		int numberItems = LibraryPanel.numItemsToCreate;
		bookListPanel.setLayout(new GridLayout(numberItems, 1));
		// bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
		bookListPanel.setBorder(BorderFactory.createTitledBorder("ButtonListPanel"));

		bookListScrollPane = new JScrollPane(bookListPanel);
		bookListScrollPane.setPreferredSize(new Dimension(128, 256));
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		bookListScrollPane.setBorder(BorderFactory.createTitledBorder("BookList Scroll"));
		
		importActionListener importActionListener = new importActionListener();
		importTextField = new JTextField(10);
		importTextField.addActionListener(importActionListener);

		importButton = new JButton("LOAD");
		importButton.addActionListener(importActionListener);

		importPanel = new JPanel();
		importPanel.setLayout(new BoxLayout(importPanel, BoxLayout.X_AXIS));
		importPanel.add(Box.createHorizontalGlue());
		importPanel.add(importTextField);
		importPanel.add(importButton);
		importPanel.add(Box.createHorizontalGlue());
		importPanel.setBorder(BorderFactory.createTitledBorder("LoadLibraryPanel"));

		this.setLayout(new BorderLayout());
		this.add(bookListScrollPane, BorderLayout.CENTER);
		this.add(importPanel, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createTitledBorder("LibraryPanel"));
	}
/**
 * 
 *Instantiates a certain number of book buttons based on the number of books in a csv file.
 *
 */
	public class importActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// takes csv filename entered by the user from import textfield and saves it to
			// a variable
			Library library = new Library();
			String libraryNameToImport = importTextField.getText();
			// takes the variable name of the csv file and loads it from the library.
			library.loadLibraryFromCSV(libraryNameToImport);
			ArrayList<Book> libraryArray = library.getBooks();
			// create conditional checks to make sure csv is valid, if valid:
			int numItems = libraryArray.size();
			numItemsToCreate = numItems;
		
			bookListPanel.removeAll();
			for (int i = 0; i < numItems; i++) {
				Book selectedBook = library.getBook(i);

				BookButton button = new BookButton(selectedBook);
				button.addActionListener(bookButtonListener);
				button.setToolTipText(selectedBook.toString());

				bookListPanel.add(button);
			}
			bookListPanel.revalidate();

		}
	}

}
