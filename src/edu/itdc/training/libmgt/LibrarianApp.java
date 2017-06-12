package edu.itdc.training.libmgt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import edu.itdc.training.libmgt.model.BookListWrapper;
import edu.itdc.training.libmgt.model.Books;
import edu.itdc.training.libmgt.view.BookEditController;
import edu.itdc.training.libmgt.view.BookOverviewController;
import edu.itdc.training.libmgt.view.RootLayoutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LibrarianApp extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Books> booksData = FXCollections.observableArrayList();

    public LibrarianApp() {
        // Add some sample data
    	//booksData.add(new Books("1", "Harry Potter & the Philosopher's Stone", "JK Rowling", "1997", "Fantasy"));
    	//booksData.add(new Books("2", "Anna Karenina", "Leo Tolstoy", "19..", "Classic"));
    	//booksData.add(new Books("3", "Harry Potter", "JK Rowling", "Fantasy", "Fantasy"));
    	//booksData.add(new Books("4", "Harry Potter", "JK Rowling", "Fantasy", "Fantasy"));
    	//booksData.add(new Books("5", "Harry Potter", "JK Rowling", "Fantasy", "Fantasy"));
    	//booksData.add(new Books("6", "Harry Potter", "JK Rowling", "Fantasy", "Fantasy"));
    	// booksData.add(new Books("7", "Harry Potter", "JK Rowling", "Fantasy", "Fantasy"));
        //booksData.add(new Books("8", "Harry Potter", "JK Rowling", "Fantasy", "Fantasy"));
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Books> getBooksData() {
        return booksData;
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Personal Library Management");
        initRootLayout();
        showBookOverview();
    }

	////////////////////////////////////////Initializes the root layout.
    public void initRootLayout() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(LibrarianApp.class.getResource("view/RootLayout.fxml"));
    		rootLayout = (BorderPane) loader.load();
    		Scene scene = new Scene(rootLayout);
    		primaryStage.setScene(scene);
    		RootLayoutController controller = loader.getController();
    		controller.setLibrarianApp(this);
    		primaryStage.show();
    		primaryStage.setResizable(false);
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}

    	File file = getBookFilePath();
    	if (file != null) {
    		loadBookDataFromFile(file);
    	}
	}

    ////////////////////////////////////////Shows the person overview inside the root layout.
    public void showBookOverview() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(LibrarianApp.class.getResource("view/BookOverview.fxml"));
    		AnchorPane bookOverview = (AnchorPane) loader.load();
    		rootLayout.setCenter(bookOverview);
    		BookOverviewController controller = loader.getController();
    		controller.setLibrarianApp(this);
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    } 	
    	
    public Stage getPrimaryStage() {
    	return primaryStage;
    }

    public static void main(String[] args) {
    	launch(args);
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showBookEditDialog(Books book) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LibrarianApp.class.getResource("view/BookEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Book");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            BookEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBook(book);

            // Show the dialog and wait until the user closes it
            dialogStage.setResizable(false);
            dialogStage.showAndWait();
            //dialogStage.setResizable(false);

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getBookFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(LibrarianApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setBooksFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(LibrarianApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("LibrarianApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("LibrarianApp");
        }
    }
    
    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     * 
     * @param file
     */
    public void loadBookDataFromFile(File file) {
    	try {
    		JAXBContext context = JAXBContext.newInstance(BookListWrapper.class);
    		Unmarshaller um = context.createUnmarshaller();
    		BookListWrapper wrapper = (BookListWrapper) um.unmarshal(file);
    		booksData.clear();
    		booksData.addAll(wrapper.getBooks());
            setBooksFilePath(file);
    	}
    	catch (Exception e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText("Could not load data");
    		alert.setContentText("Could not load data from file:\n" + file.getPath());
    		alert.showAndWait();
    	}
    }

    public void saveBookDataToFile(File file) {
    	try {
    		JAXBContext context = JAXBContext.newInstance(BookListWrapper.class);
    		Marshaller m = context.createMarshaller();
    		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    		BookListWrapper wrapper = new BookListWrapper();
    		wrapper.setBooks(booksData);
    		m.marshal(wrapper, file);
    		setBooksFilePath(file);
    	}
    	catch (Exception ex) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText("Could not save data");
    		alert.setContentText("Could not save data to file:\n" + file.getPath());
    		alert.showAndWait();
    	}
    }
    
}
