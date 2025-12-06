package com.login.libraryupa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            errorLabel.setText("¡Bienvenido, Ingeniero!");

            System.out.println("Login exitoso");

        } else if (user.isEmpty() || pass.isEmpty()) {
            errorLabel.setStyle("-fx-text-fill: orange;");
            errorLabel.setText("Por favor llena ambos campos.");
        } else {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Usuario o contraseña incorrectos.");
        }
    }
}
