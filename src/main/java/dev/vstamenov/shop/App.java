package dev.vstamenov.shop;

import dev.vstamenov.shop.controller.elements.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MVP of Shop application");
        stage.setScene(scene);
        stage.show();
    }
}
