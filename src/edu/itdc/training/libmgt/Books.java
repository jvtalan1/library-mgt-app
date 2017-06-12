package edu.itdc.training.libmgt;

public class Books {
	private String bookId;
	private String bookTitle;
	private String bookAuthor;
	private String publicationYear;
	private String bookCategory;
	private double price;
	private String status;
	
	public Books (String bookId, String bookTitle, String bookAuthor, String publicationYear) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publicationYear = publicationYear;
	}
	
	public Books (String bookId, String bookTitle, String bookAuthor, String publicationYear, String bookCategory, double price, String status) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publicationYear = publicationYear;
		this.bookCategory = bookCategory;
		this.price = price;
		this.status = status;
	}
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
