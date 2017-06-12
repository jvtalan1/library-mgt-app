package edu.itdc.training.libmgt.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import edu.itdc.training.libmgt.util.DateUtil;
import java.sql.Timestamp;
import java.util.Calendar;

import edu.itdc.training.libmgt.model.Books;

public class BookEditController {
	@FXML
	private TextField bookTitleField;
	@FXML
	private TextField bookAuthorField;
	@FXML
	private TextField publicationYearField;
	@FXML
	private TextField bookCategoryField;

	private Stage dialogStage;
	private Books book;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	///////////////////sets book to be edited in dialog box
	public void setBook(Books book) {
		this.book = book;

		bookTitleField.setText(book.getBookTitle());
		bookAuthorField.setText(book.getBookAuthor());
		publicationYearField.setText(book.getPublicationYear());
		bookCategoryField.setText(book.getBookCategory());
		//birthdayField.setText(DateUtil.format(person.getBirthday()));
		//birthdayField.setPromptText("dd.mm.yyyy");
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			//Calendar calendar = Calendar.getInstance();
			//Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
			book.setBookTitle(bookTitleField.getText());
			book.setBookAuthor(bookAuthorField.getText());
			book.setPublicationYear(publicationYearField.getText());
			book.setBookCategory(bookCategoryField.getText());
			//book.setAddBookDate(currentTimestamp);
			//localD
			//book.setAddBookDate(LocalDate);
			//book.setBirthday(DateUtil.parse(birthdayField.getText()));

			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/////////////////////////////checks validity of inputted data
	private boolean isInputValid() {
		String errorMessage = "";

		if (bookTitleField.getText() == null || bookTitleField.getText().length() == 0) {
			errorMessage += "Book Title required!\n"; 
		}
		if (bookAuthorField.getText() == null || bookAuthorField.getText().length() == 0) {
			errorMessage += "Book Author required!\n"; 
		}
		if (publicationYearField.getText() == null || publicationYearField.getText().length() == 0) {
			errorMessage += "Please enter publication year of book.\n";
		}
		if (bookCategoryField.getText() == null || bookCategoryField.getText().length() == 0) {
			errorMessage += "Please enter book category.\n"; 
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
	        }
	    }
	
}
