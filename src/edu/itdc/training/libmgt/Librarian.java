package edu.itdc.training.libmgt;

public class Librarian {
	private String librarianId;
	private String librarianName;
	
	public Librarian (String librarianId, String librarianName) {
		this.librarianId = librarianId;
		this.librarianName = librarianName;
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

	public String getLibrarianName() {
		return librarianName;
	}

	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}
	
	
}
