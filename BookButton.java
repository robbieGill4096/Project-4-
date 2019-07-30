import javax.swing.JButton;

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
public Book getBook(){
	
	
	return book;
	
}	


private void setTitleText(String text){
	this.setText(text);
}
}
