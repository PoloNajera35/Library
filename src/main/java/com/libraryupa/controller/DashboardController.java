package com.libraryupa.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import java.io.IOException;

public class DashboardController {

    @FXML
    private BorderPane mainLayout;

    @FXML
    public void handleShowBooks(ActionEvent event) {
        loadPage("books-view.fxml");
    }

    @FXML
    public void handleShowMembers(ActionEvent event) {
        loadPage("members-view.fxml");
    }

    @FXML
    public void handleShowSearch(ActionEvent event) {
        loadPage("search-view.fxml");
    }

    @FXML
    public void handleLogout(ActionEvent event) {
        System.out.println("Logging out...");

    }

    private void loadPage(String fxmlFile) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource("/com/libraryupa/" + fxmlFile));
            mainLayout.setCenter(view);
        } catch (IOException e) {
            System.out.println("Could not load FXML file: " + fxmlFile);
            e.printStackTrace();
        }
    }
}