import javax.swing.JFrame;

//will function as the driver for this project. 
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
