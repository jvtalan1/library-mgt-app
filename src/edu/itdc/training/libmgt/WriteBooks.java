package edu.itdc.training.libmgt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteBooks {
	private List <Books> bookBank = new ArrayList <> ();
	private String fileName;
	private FileWriter writer;
	private PrintWriter printer;
	private BufferedReader fileReader;
	private String bookId, bookTitle, bookAuthor, bookPublicationYear;

	
	public WriteBooks () {
		setFileName("books_database.txt");
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;		
	}
	
	public void writeToFile (Books book) throws IOException {
		try {
			writer = new FileWriter (fileName, true);
			printer = new PrintWriter (writer);
			bookBank.add(book);
			printer.print(book.getBookId() + ",");
			printer.print(book.getBookTitle() + ",");
			printer.print(book.getBookAuthor() + ",");
			printer.println(book.getPublicationYear());;
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.\n");
		}
		finally {
			printer.flush();
			writer.close();
		}
	}
	
	public List <Books> readFromFile () throws IOException {
		bookBank.clear();
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			String line = null; 
			while ((line = fileReader.readLine()) != null) {
				String tokens[] = line.split(",");
				int i = 0;
				tokens[i].trim();
				bookId = tokens[0];
				bookTitle = tokens[1];
				bookAuthor = tokens[2];
				bookPublicationYear = tokens[3];
				bookBank.add(new Books(bookId, bookTitle, bookAuthor, bookPublicationYear));
			}
			fileReader.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.\n");
		}
	return bookBank;
	}
	
	public void deleteFromFile (Books book) throws IOException {
		try {
			writer = new FileWriter (fileName, true);
			printer = new PrintWriter (writer);
			String line = fileReader.readLine();
			for (Books bookentry : bookBank) {
				if (bookentry == book) {
					line = null;
				}
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.\n");
		}
		finally {
			printer.flush();
			writer.close();
		}
	}
	
}
