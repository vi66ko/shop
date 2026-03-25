package dev.vstamenov.shop.controller.elements;


import dev.vstamenov.shop.App;
import dev.vstamenov.shop.Database;
import dev.vstamenov.shop.model.User;
import dev.vstamenov.shop.utility.Session;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    public Label errorFeedbackLabel;
    private Button loginBtn;
    @FXML
    private Label loginLabel;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;


    public void goToRegister(ActionEvent actionEvent) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/register.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
       App.primaryStage.setScene(scene);
       App.primaryStage.show();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()){
            errorFeedbackLabel.setText("All fields are required");
            return;
        }

        User user = Database.login(username, password);

        if(user == null){
            errorFeedbackLabel.setText("Invalid username or password");
            return;
        }

        Session.setCurrentUser(user);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        App.primaryStage.setScene(scene);
        App.primaryStage.show();

    }

    public void initialize(){
//        Platform.runLater(() -> autoLogin());
    }

    public void autoLogin(){
        System.out.println("Auto login");
        try {
            User user = Database.login("demo", "demo");
            Session.setCurrentUser(user);

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            App.primaryStage.setScene(scene);
            App.primaryStage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}