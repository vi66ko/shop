package dev.vstamenov.shop.controller.elements;

import dev.vstamenov.shop.App;
import dev.vstamenov.shop.Database;
import dev.vstamenov.shop.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordConfirmField;

   @FXML
    private Label errorFeedbackLabel;

    public void goToLogin(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        App.primaryStage.setScene(scene);
   }

    public void register(ActionEvent actionEvent) throws IOException {
        String userName = usernameField.getText();
        String password = passwordField.getText();
        String passwordConfirm = passwordConfirmField.getText();

        if (userName.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            errorFeedbackLabel.setText("All fields are required");
        } else if (password.length() < 8) {
            errorFeedbackLabel.setText("Password must be at least 8 characters");
        } else if (!password.equals(passwordConfirm)) {
            errorFeedbackLabel.setText("Passwords do not match");
        } else if (Database.isUserExists(userName)) {
            errorFeedbackLabel.setText("User already exists");
        } else {
            boolean success = Database.registerUser(new User(userName, password));
            if (success) {
                System.out.println(userName + " has been successfully registered");
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/login.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                App.primaryStage.setScene(scene);
            } else {
                errorFeedbackLabel.setText("Registration failed, try again");
            }
        }
    }

}
