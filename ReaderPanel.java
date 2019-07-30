import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;
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
import javax.swing.JScrollBar;
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
	private static int pageNum;
	private static int numPages;
	private JScrollBar scrollBar;
	private static int scrollbarCall = 0;
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
		PagingUpActionListener PagingUpActionListener = new PagingUpActionListener();
		PagingDownActionListener PagingDownActionListener = new PagingDownActionListener();
		
		pageUpButton = new JButton("PUp");
		pageDownButton = new JButton("PDown");
		pageUpButton.addActionListener(PagingUpActionListener);
		pageDownButton.addActionListener(PagingDownActionListener);
		navigationPanel = new JPanel();
		navigationPanel.add(pageUpButton);
		navigationPanel.add(pageDownButton);
		bookTextScrollPane.setPreferredSize(new Dimension(200,50));
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("Navigation Panel"));
		//------------------------------------
		// add all panels to readerPanel
		JScrollBar scrollBar= bookTextScrollPane.getVerticalScrollBar();
		ScrollBarListener ScrollBarListener = new ScrollBarListener();
		scrollBar.addAdjustmentListener(ScrollBarListener);
		numPages = scrollBar.getMaximum();
		this.setLayout(new BorderLayout());
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(navigationPanel,BorderLayout.SOUTH);
		this.add(bookTextScrollPane, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createTitledBorder("ReaderPanel"));
		pageNum = 0;
		scrollBar.getValue();
	}
	
	
	public void loadBook(Book book) {
		//set label.
		titleLabel.setText(book.getTitle()+"  ");
		authorLabel.setText(book.getAuthor()+"  ");
		pageLabel.setText(bookTextScrollPane.getVerticalScrollBar().getValue()+ "/"+ bookTextScrollPane.getVerticalScrollBar().getMaximum());
		
		String bookText = book.getText();
		bookTextArea.setText(bookText);
		bookTextArea.getText();
		this.revalidate();
	}
	
private class PagingDownActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JScrollBar scrollBar= bookTextScrollPane.getVerticalScrollBar();
		int pageHeight = scrollBar.getBlockIncrement(bookTextArea.getHeight());
		//scrollBar.getMaximum();
		//scrollBar.getMinimum();
		if (pageNum < 0){
			//scrollBar.setValue(0);
			pageNum = 0;
			scrollBar.getValue();
		}
	
		
		if ((JButton)e.getSource() == pageDownButton) {
			scrollBar.setValue(pageNum +=pageHeight);
			scrollBar.getValue();
			}
		
	}
}
private class PagingUpActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JScrollBar scrollBar= bookTextScrollPane.getVerticalScrollBar();
		numPages = scrollBar.getMaximum();
		int pageHeight = scrollBar.getBlockIncrement(bookTextArea.getHeight());
		
		if (pageNum < 0){
			pageNum = 0;
			scrollBar.getValue();
		}
		
		if (numPages < pageNum){
			pageNum = numPages;
			scrollBar.getValue();
			
		}
		
		if ((JButton)e.getSource() == pageUpButton) {
			scrollBar.setValue(pageNum -=pageHeight);
			scrollBar.getValue();
	
		}
	
		  
		
	}
}
	private class ScrollBarListener implements AdjustmentListener {
		
		@Override
		public void adjustmentValueChanged(AdjustmentEvent arg0) {
			
			try {
				pageNum = arg0.getValue();
				
				int pageHeight = bookTextScrollPane.getVerticalScrollBar().getHeight();
				int pageIndex = (pageNum/pageHeight) + 1;
				pageLabel.setText("  " + pageIndex + "/"+ (bookTextScrollPane.getVerticalScrollBar().getMaximum())/pageHeight);
			}
			catch(Exception e){
				
			}
			
			
		}
		
	}
}
