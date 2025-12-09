package com.libraryupa.controller;

import com.libraryupa.dao.BookDAO;
import com.libraryupa.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BooksListController {

    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField isbnField;

    @FXML private TableView<Book> booksTable;
    @FXML private TableColumn<Book, Integer> colId;
    @FXML private TableColumn<Book, String> colTitle;
    @FXML private TableColumn<Book, String> colAuthor;
    @FXML private TableColumn<Book, String> colIsbn;
    @FXML private TableColumn<Book, Boolean> colStatus;

    private BookDAO bookDAO = new BookDAO();
    private ObservableList<Book> bookList;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("available"));

        loadBooks();
    }

    private void loadBooks() {
        bookList = FXCollections.observableArrayList(bookDAO.getAllBooks());
        booksTable.setItems(bookList);
    }

    @FXML
    private void handleAddBook() {
        System.out.println("Message to see if the add button works");
    }

    @FXML
    private void handleDeleteBook() {
        System.out.println("Message to see if the delete button works");
    }

    @FXML
    private void handleEditBook() {
        System.out.println("Message to see if the edit button works");
    }
}
