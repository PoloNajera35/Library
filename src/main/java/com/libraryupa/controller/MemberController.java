package com.libraryupa.controller;

import com.libraryupa.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    private ObservableList<Member> membersList = FXCollections.observableArrayList();


    private int memberIdCounter = 1;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));


        membersTable.setItems(membersList);
    }

    @FXML
    private void handleAddMember() {


        String name = nameField.getText();
        String email = emailField.getText();


        if (name.isEmpty() || email.isEmpty()) {
            System.out.println("Los campos no pueden estar vacíos");
            return;
        }


        Member newMember = new Member(
                memberIdCounter++,
                name,
                email,
                "Regular"
        );


        membersList.add(newMember);


        nameField.clear();
        emailField.clear();
    }

    @FXML
    private void handleDeleteMember() {

        Member selectedMember = membersTable
                .getSelectionModel()
                .getSelectedItem();


        if (selectedMember == null) {
            System.out.println("Selecciona un miembro para eliminar");
            return;
        }

        membersList.remove(selectedMember);
    }
}
