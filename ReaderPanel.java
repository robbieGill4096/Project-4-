import java.awt.BorderLayout;
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
		
		bookTextScrollPane = new JScrollPane(bookTextArea);
		
		bookTextScrollPane.setPreferredSize(new Dimension(200,200));
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("bookTextScrollPane"));
		
		//------------------------------------
		

		//				Navigation Panel
		//-----------------------------------
		
		pageUpButton = new JButton("PUp");
		pageDownButton = new JButton("PDown");
		navigationPanel = new JPanel();
		navigationPanel.add(pageUpButton);
		navigationPanel.add(pageDownButton);
		bookTextScrollPane.setPreferredSize(new Dimension(200,50));
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("Navigation Panel"));
		//------------------------------------
		
		// add all panels to readerPanel
		this.setLayout(new BorderLayout());
		this.add(bookTextScrollPane, BorderLayout.CENTER);
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(navigationPanel,BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createTitledBorder("ReaderPanel"));
		

	
		
	}
	public void loadBook(Book book) {
		//set label.
		titleLabel.setText(book.getTitle());
		authorLabel.setText(book.getAuthor());
		//pageLabel.setText(book.get);;
		
		String bookText = book.getText();
		bookTextArea.setText(bookText);
		this.revalidate();
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
