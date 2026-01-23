package dev.vstamenov.shop;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        Database.connect();
        Application.launch(App.class, args);


    }

}
