import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Robbie
 *
 * Manage collection of Books Objects Implements API from Library
 * Interface.
 */

public class Library implements LibraryInterface {
	private ArrayList<Book> bookLibrary;
/**
 * creates a new library instance
 * 
 */
	public Library() {
		this.bookLibrary = new ArrayList<Book>();

	}
	/**
	 * takes the book library and iterates through it returning a copy.
	 * @return a copy of the bookLibrary to the user.
	 */
	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> copyBookLibrary = new ArrayList<Book>();
		for (Book book : this.bookLibrary) {
			copyBookLibrary.add(book);
		}

		return copyBookLibrary;
	}
/**
 * adds a book to the library.
 * 
 */
	@Override
	public void addBook(Book newBook) {
		this.bookLibrary.add(newBook);

	}
/**
 * 
 * removes a book object from the library
 */
	@Override
	public void removeBook(int index) {
		if (index <= this.bookLibrary.size() - 1) {
			this.bookLibrary.remove(index);
		}

	}
/**gets a book from the library and creates a copy
 * @return a copy of a book
 */
	@Override
	public Book getBook(int index) {
		int sizeOfArray = this.getBooks().size();
		if (index < sizeOfArray) {
			Book specificBookCopy = this.getBooks().get(index);
			return specificBookCopy;
		}
		// TODO Auto-generated method stub
		return null;
	}
/**
 * iterates through a library of books and adds the index to a string value.
 * @return String value representing all the book objects in a library.
 */
	public String toString() {
		int index = 0;
		String stringAndInfo = "";
		for (Book book : this.bookLibrary) {
			String bookInfo = book.toString();
			String formattedBookInfo = "Index: " + index + " " + bookInfo + " \n";
			stringAndInfo += formattedBookInfo;

			index += 1;
		}

		return stringAndInfo;

	}
	/**
	 * Populate the library with books from the specified CSV formated text file
	 * Format:
	 *     title, author, genre, filepath
	 * @param csvFilename Text file with CSV formated book data
	 */
@Override
public void loadLibraryFromCSV(String csvFilename) {
	File bookLibrary = new File(csvFilename);
	
	Scanner fileReader;
		try {
			fileReader = new Scanner(bookLibrary);
			while (fileReader.hasNextLine()) {
				String bookLineCsv = fileReader.nextLine();
				Scanner bookAttributeReader = new Scanner(bookLineCsv);
				bookAttributeReader.useDelimiter(",");
				
				ArrayList<String> bookComponents = new ArrayList<String>();
				
				while (bookAttributeReader.hasNext()) {
				String attribute = bookAttributeReader.next();
				bookComponents.add(attribute);
				if (bookComponents.size() > 3) {
					String title = bookComponents.get(0);
					String author = bookComponents.get(1);
					String genre = bookComponents.get(2);
					String filepath = bookComponents.get(3);
					Book book = new Book(title,author);
					book.setGenre(genre);
					book.setFilename(filepath);
					addBook(book);
				}
				}
			}
		} 
			catch (FileNotFoundException e) {
				String optionError = "Invalid FileName\nPlease Enter a valid CSV file";
				JOptionPane.showMessageDialog(null, optionError,"",JOptionPane.ERROR_MESSAGE);
		}
	
	
}

}
