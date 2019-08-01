import javax.swing.JFrame;

/**
 * 
 * @author Robbie
 *Serves as the driver for The Library of Books program. which allows users to add a collection of books from a csv file
 *and then read the book page by page.
 */
public class ReaderOfBooks {

	public static void main(String[] args) {
		// TODO 
		//. It will be responsible for creating the JFrame
		// instantiating the ReaderOfBooksPanel.java class.
		
		
		JFrame mainFrame = new JFrame("Reader Of Books");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReaderOfBooksPanel mainPanel = new ReaderOfBooksPanel();
		
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	
	}
}
