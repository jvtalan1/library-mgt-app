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

public class Borrower {
	private final StringProperty borrowerId;
	private final StringProperty borrowerName;
	private final StringProperty borrowerAddress;
	private final StringProperty contactNo;
	
	    
	public Borrower() {
		this (null, null, null, null);
	}

	public Borrower (String borrowerId, String borrowerName, String borrowerAddress, String contactNo) {
		this.borrowerId = new SimpleStringProperty(borrowerId);
		this.borrowerName = new SimpleStringProperty(borrowerName);
		this.borrowerAddress = new SimpleStringProperty(borrowerAddress);
		this.contactNo = new SimpleStringProperty(contactNo);
	}

	public String getBorrowerId() {
		return borrowerId.get();
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId.set(borrowerId);
	}

	public StringProperty borrowerIdProperty() {
		return borrowerId;
	}

	public String getBorrowerName() {
		return borrowerName.get();
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName.set(borrowerName);
	}

	public StringProperty borrowerNameProperty() {
		return borrowerName;
	}

	public String getBorrowerAddress() {
		return borrowerAddress.get();
	}

	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress.set(borrowerAddress);
	}

	public StringProperty borrowerAddressProperty() {
		return borrowerAddress;
	}

	public String getContactNo() {
		return contactNo.get();
	}

	public void setPublicationYear(String contactNo) {
		this.contactNo.set(contactNo);
	}

	public StringProperty contactNoProperty() {
		return contactNo;
	}
	
}
