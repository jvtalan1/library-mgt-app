package edu.itdc.training.libmgt.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import edu.itdc.training.libmgt.util.LocalDateAdapter;
//import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Books {
	//private final StringProperty bookId;
	private final StringProperty bookTitle;
	private final StringProperty bookAuthor;
	private final StringProperty publicationYear;
	private final StringProperty bookCategory;
	private StringProperty bookRating;
	private ObjectProperty<LocalDate> addBookDate;
	private ObjectProperty<LocalDate> issueDate;
	private ObjectProperty<LocalDate> returnDate;
	
	    
	public Books() {
		this (null, null, null, null);
	}

	public Books (String bookTitle, String bookAuthor, String publicationYear, String bookCategory) {
		//this.bookId = new SimpleStringProperty(bookId);
		this.bookTitle = new SimpleStringProperty(bookTitle);
		this.bookAuthor = new SimpleStringProperty(bookAuthor);
		this.publicationYear = new SimpleStringProperty(publicationYear);
		this.bookCategory = new SimpleStringProperty(bookCategory);
	}
	/*    
	public Books (String bookId, String bookTitle, String bookAuthor, String publicationYear, String bookCategory, ObjectProperty<LocalDate> issueDate) {
		this.bookId = new SimpleStringProperty(bookId);
		this.bookTitle = new SimpleStringProperty(bookTitle);
		this.bookAuthor = new SimpleStringProperty(bookAuthor);
		this.publicationYear = new SimpleStringProperty(publicationYear);
		this.bookCategory = new SimpleStringProperty(bookCategory);
		this.issueDate = new SimpleObjectProperty<LocalDate>();
	}
	    
	public Books (String bookId, String bookTitle, String bookAuthor, String publicationYear, String bookCategory, ObjectProperty<LocalDate> issueDate, ObjectProperty<LocalDate> returnDate) {
		this.bookId = new SimpleStringProperty(bookId);
		this.bookTitle = new SimpleStringProperty(bookTitle);
		this.bookAuthor = new SimpleStringProperty(bookAuthor);
		this.publicationYear = new SimpleStringProperty(publicationYear);
		this.bookCategory = new SimpleStringProperty(bookCategory);
		this.issueDate = new SimpleObjectProperty<LocalDate>();
		this.returnDate = new SimpleObjectProperty<LocalDate>();
	}
	*/  

	public String getBookTitle() {
		return bookTitle.get();
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle.set(bookTitle);
	}

	public StringProperty bookTitleProperty() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor.get();
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor.set(bookAuthor);
	}

	public StringProperty bookAuthorProperty() {
		return bookAuthor;
	}

	public String getPublicationYear() {
		return publicationYear.get();
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear.set(publicationYear);
	}

	public StringProperty publicationYearProperty() {
		return publicationYear;
	}

	public String getBookCategory() {
		return bookCategory.get();
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory.set(bookCategory);
	}

	public StringProperty bookCategoryProperty() {
		return bookCategory;
	}
	   
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getIssueDate() {
		return issueDate.get();
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate.set(issueDate);
	}

	public ObjectProperty<LocalDate> issueDateProperty() {
		return issueDate;
	}
	   
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getReturnDate() {
		return returnDate.get();
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate.set(returnDate);
	}

	public ObjectProperty<LocalDate> returnDateProperty() {
		return returnDate;
	}
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getAddBookDate() {
		return addBookDate.get();
	}

	public void setAddBookDate(LocalDate addBookDate) {
		this.addBookDate.set(addBookDate);
	}

	public ObjectProperty<LocalDate> addBookDateProperty() {
		//
		return addBookDate;
	}	
	
	
}
