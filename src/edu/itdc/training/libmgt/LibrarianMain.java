package edu.itdc.training.libmgt;

import java.io.IOException;
import java.util.Scanner;

public class LibrarianMain {
	private static Scanner input;
	private static Books book;
	private static BookBank bookBank = new BookBank ();
	private static WriteBooks writeBook = new WriteBooks ();
	
	
	public static void main(String[] args) throws IOException {
		
		input = new Scanner (System.in);
		boolean mainMenu = true;
		while (mainMenu) {
			switch (mainMenu()) {
			case "1":	addNewBooks();		break;
			case "2":	deleteBooks();		break;
			case "3":	updateDetails();	break;
			case "4":	searchBook();		break;
			case "X":	mainMenu = false;	break;
			default: 	System.out.println("Invalid option.");
			}
		}
	}
	
	public static String mainMenu () {
		String choice;
		System.out.println("MAIN MENU");
		System.out.println("1. Add New Book");
		System.out.println("2. Delete Book From Book Bank");
		System.out.println("3. Update Book Details");
		System.out.println("4. Search Book");
		System.out.println("X. Exit Program");
		System.out.println("");
		choice = input.nextLine();
		return choice;
	}
	
	public static void addNewBooks () throws IOException {
		book = getBookDetails(null);
		if (book != null) {
			bookBank.addToBookBank(book);
			writeBook.writeToFile(book);
		}
	}
	
	public static Books getBookDetails (Books book) {
		System.out.println("Please input details.");
		System.out.print("ISBN: ");							String bookId = input.nextLine();
		System.out.print("Book Title: ");					String bookTitle = input.nextLine();
		System.out.print("Book Author: ");					String bookAuthor = input.nextLine();
		System.out.print("Year of Publication: ");			String publicationYear = input.nextLine();
		System.out.println("Book Category: ");
		book = new Books (bookId, bookTitle, bookAuthor, publicationYear);
		return book;
	}
	
	public static String searchMenu () {
		String choice;
		System.out.println("Please enter search category: ");
		System.out.println("1. Title");
		System.out.println("2. Author");
		System.out.println("3. Year of Publication");
		System.out.println("4. Genre");
		System.out.println("X. Exit to Main Menu");
		choice = input.nextLine();
		return choice;
	}
	
	public static void searchBook () throws IOException {
		boolean search = true;
		while (search) {
			switch (searchMenu()) {
			case "1":	searchByTitle();			break;
			case "2":	searchByAuthor();			break;
			case "3":	searchByYear();				break;
			case "4":	searchByGenre();			break;
			case "X":	search = false;				break;
			default: 	System.out.println("Invalid option.");
			}
		} 
	}
	
	public static String getBook () throws IOException {
		String entry;
		System.out.println("Please enter title/author/genre/year");
		entry = input.nextLine();
		return entry.replaceAll(" ", "");
	}
	
	public static void searchByTitle () throws IOException {
		String entry = getBook();
		book = bookBank.findByTitle(entry);
		displayBook(book);
	}
	
	public static void searchByAuthor () throws IOException {
		String entry = getBook();
		book = bookBank.findByAuthor(entry);
		displayBook(book);
	}
	
	public static void searchByYear () throws IOException {
		String entry = getBook();
		book = bookBank.findByYear(entry);
		displayBook(book);
	}
	
	public static void searchByGenre () throws IOException {
		String entry = getBook();
		book = bookBank.findByGenre(entry);
		displayBook(book);
	}
	
	public static void deleteBooks () throws IOException {
		searchBook();
		String entry = getBook();
		book = bookBank.findByTitle(entry);
		bookBank.deleteBook(book);
		
	}
	
	public static void updateDetails () {
		
	}
	
	public static void displayBook (Books book) {
		
		System.out.println("ISBN: " + book.getBookId());
		System.out.println("Title: " + book.getBookTitle());
		System.out.println("Author: " + book.getBookAuthor());
		System.out.println("Year Published: " + book.getPublicationYear());
		//System.out.println("Book category: " + book.getBookCategory());
		//System.out.println("Status: " + book.getStatus());
	}
	
	
}
