import javax.swing.JButton;
/**
 * 
 * @author Robbie
 *creates a new JButton for a book object and Truncates the title if its over 20 characters.
 */
public class BookButton extends JButton {
private int Max_TEXT_LENGTH = 20;
private String ELLIPISES = "....";
private Book book;

public BookButton(Book book) {
	this.book = book;
	String title = book.getTitle();
	int charCount = title.length();
	
	if  (charCount > 20) {
	String ellipTitle = book.getTitle().substring(0,21) + ELLIPISES;
	setTitleText(ellipTitle);
	}
	else {
	String subbedBook = book.getTitle();
	setTitleText(subbedBook);
	}
}
/**
 * 
 * @return book a book object that contains string data about the title author file path and genre.
 */
public Book getBook(){
	
	
	return book;
	
}	


private void setTitleText(String text){
	this.setText(text);
}
}
