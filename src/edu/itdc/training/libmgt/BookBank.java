package edu.itdc.training.libmgt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookBank {
	private List <Books> bookBank = new ArrayList <> ();
	private static WriteBooks writeBook = new WriteBooks ();
	

	public boolean addToBookBank (Books books) {
		bookBank.add(books);
		return true;
	}
	
	public Books findByTitle (String bookTitle) throws IOException {
		bookBank = writeBook.readFromFile();
		for (Books book : bookBank) {
			if (book.getBookTitle().replaceAll(" ", "").equalsIgnoreCase(bookTitle)) {
				return book;
			}
		}
		return null;
	}
	
	public Books findByAuthor (String bookAuthor) throws IOException {
		bookBank = writeBook.readFromFile();
		for (Books book : bookBank) {
			if (book.getBookAuthor().replaceAll(" ", "").equalsIgnoreCase(bookAuthor)) {
				return book;
			}
		}
		return null;
	}
	
	public Books findByYear (String publicationYear) throws IOException {
		bookBank = writeBook.readFromFile();
		for (Books book : bookBank) {
			if (book.getPublicationYear().replaceAll(" ", "").equalsIgnoreCase(publicationYear)) {
				return book;
			}
		}
		return null;
	}
	
	public Books findByGenre (String genre) throws IOException {
		bookBank = writeBook.readFromFile();
		for (Books book : bookBank) {
			if (book.getBookCategory().replaceAll(" ", "").equalsIgnoreCase(genre)) {
				return book;
			}
		}
		return null;
	}
	
	public void deleteBook (Books book) throws IOException {
		bookBank = writeBook.readFromFile();
		for (Books bookentry : bookBank) {
			if (bookentry == book) {
				bookentry = null;
				writeBook.deleteFromFile(book);
			}
		}
	}
	
	public List <Books> getAllBooks () {
		return bookBank;
	}
}
