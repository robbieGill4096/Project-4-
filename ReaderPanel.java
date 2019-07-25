import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// container for the GUI 
//components that provide the Reader functionality.

public class ReaderPanel extends JPanel {
	private JPanel infoPanel;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JLabel pageLabel;
	private JScrollPane bookTextScrollPane;
	private JTextArea bookTextArea;
	private JPanel navigationPanel;
	private JButton pageUpButton;
	private JButton pageDownButton;
	private int pageNum;
	private int numPages;
	
	public ReaderPanel() {
		
		
		//				InfoPanel
		//-----------------------------------
		
		titleLabel = new JLabel();
		authorLabel = new JLabel();
		pageLabel = new JLabel();
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setBorder(BorderFactory.createTitledBorder("InfoPanel"));
		infoPanel.add(Box.createHorizontalGlue());
		infoPanel.add(titleLabel);
		infoPanel.add(authorLabel);
		infoPanel.add(pageLabel);
		infoPanel.add(Box.createHorizontalGlue());
		//------------------------------------
		
		
		

		//				BookTextScrollPane
		//-----------------------------------
		
		bookTextArea = new JTextArea();
		bookTextArea.setLineWrap(true);
		bookTextArea.setWrapStyleWord(true);
		bookTextArea.setEditable(false);
		bookTextArea.setBorder(BorderFactory.createTitledBorder("BookTextArea"));
		
		bookTextScrollPane = new JScrollPane(bookTextScrollPane);
		bookTextScrollPane.setPreferredSize(new Dimension(200,200));
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("ItemTextScroll"));
		
		//------------------------------------
		

		//				Navigation Panel
		//-----------------------------------
		
		pageUpButton = new JButton();
		pageDownButton = new JButton();
		navigationPanel = new JPanel();
		//------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//information bar sub panel.with JLabels for Title,
		//Author and Page. The page label should display both 
		//the current page as well as the total number of 
		//pages. These values should be updated whenever a new book 
		//is selected AND whenever the window is resized.

		
		/**Sub-panel as a “navigation bar” with JButtons for 
		 * Page-Up  / Page-Down functionality. The page up button 
		 * should be disabled if the document is scrolled all the
		 *  way to the top. The page down button should be disabled 
		 *  if the document is scrolled all the way to the bottom.
		 */
		
		//A JTextArea placed within a JScrollPane to display the book text.
		
		//this is where you left off--------------------
		//specify the lines and clolumns of bookTextArea.
		
	}
	public void loadBook(Book book) {
		
	}
private class PagingActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	public class ScrollBarListener implements AdjustmentListener {

		@Override
		public void adjustmentValueChanged(AdjustmentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
}
