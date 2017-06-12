package edu.itdc.training.libmgt.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.itdc.training.libmgt.LibrarianApp;
import edu.itdc.training.libmgt.model.Books;

public class BookOverviewController {
	@FXML
	private TableView<Books> booksTable;
	@FXML
	private TableColumn<Books, String> bookTitleColumn;
	@FXML
	private TableColumn<Books, String> bookAuthorColumn;
	@FXML
	private TableColumn<Books, String> bookCategoryColumn;


	@FXML
	private Label bookTitleLabel;
	@FXML
	private Label bookAuthorLabel;
	@FXML
	private Label bookPublicationYearLabel;
	@FXML
	private Label bookCategoryLabel;
	@FXML
	private Label bookRatingLabel;
	@FXML
	private Label addBookDateLabel;


	///////////////////////////////////////////////// Reference to the main application.
	private LibrarianApp librarianApp;

	public BookOverviewController() {
	}

	@FXML
	private void initialize() {
		bookTitleColumn.setCellValueFactory(cellData -> cellData.getValue().bookTitleProperty());
		bookAuthorColumn.setCellValueFactory(cellData -> cellData.getValue().bookAuthorProperty());
		bookCategoryColumn.setCellValueFactory(cellData -> cellData.getValue().bookCategoryProperty());
		showBookDetails(null);
		booksTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showBookDetails(newValue));
	}

	public void setLibrarianApp(LibrarianApp librarianApp) {
		this.librarianApp = librarianApp;
		booksTable.setItems(librarianApp.getBooksData());
	}
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    private void showBookDetails(Books book) {
        if (book != null) {
            // Fill the labels with info from the person object.
            bookTitleLabel.setText(book.getBookTitle());
            bookAuthorLabel.setText(book.getBookAuthor());
            bookPublicationYearLabel.setText(book.getPublicationYear());
            bookCategoryLabel.setText(book.getBookCategory());
            
            //issueDateLabel.setText(DateUtil.format(book.getIssueDate()));
            // TODO: We need a way to convert the birthday into a String! 
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
        	bookTitleLabel.setText("");
        	bookAuthorLabel.setText("");
        	bookPublicationYearLabel.setText("");
        	bookCategoryLabel.setText("");
           // birthdayLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteBook() {
        int selectedIndex = booksTable.getSelectionModel().getSelectedIndex();
        //booksTable.getItems().remove(selectedIndex);
        if (selectedIndex >= 0) {
            booksTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(librarianApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewBook() {
        Books tempBooks = new Books();
        boolean okClicked = librarianApp.showBookEditDialog(tempBooks);
        if (okClicked) {
            librarianApp.getBooksData().add(tempBooks);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditBook() {
    	Books selectedBooks = booksTable.getSelectionModel().getSelectedItem();
        if (selectedBooks != null) {
            boolean okClicked = librarianApp.showBookEditDialog(selectedBooks);
            if (okClicked) {
                showBookDetails(selectedBooks);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(librarianApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();
        }
    }
}

