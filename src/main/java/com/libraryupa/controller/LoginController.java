package com.libraryupa.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    protected void onLoginClick() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (user.equals("admin") && pass.equals("1234")) {
            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("¡Bienvenido!");
            System.out.println("Login exitoso");


            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/libraryupa/dashboard-view.fxml"));
                Parent root = loader.load();


                Stage stage = (Stage) usernameField.getScene().getWindow();


                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Error loading Dashboard.");
                System.out.println("Error: Could not load dashboard-view.fxml. Check the file path.");
            }


        } else if (user.isEmpty() || pass.isEmpty()) {
            errorLabel.setStyle("-fx-text-fill: orange;");
            errorLabel.setText("Por favor llena ambos campos.");
        } else {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Usuario o contraseña incorrectos.");
        }
    }
}
