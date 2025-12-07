package com.libraryupa.controller;

import com.libraryupa.model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;

    @FXML private TableView<Member> membersTable;
    @FXML private TableColumn<Member, Integer> colId;
    @FXML private TableColumn<Member, String> colName;
    @FXML private TableColumn<Member, String> colEmail;
    @FXML private TableColumn<Member, String> colType;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    }

    @FXML
    private void handleAddMember() {
        System.out.println("Message to see if the add button works ");
    }
}
