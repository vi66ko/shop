package dev.vstamenov.shop.controller.layout;


import dev.vstamenov.shop.App;
import dev.vstamenov.shop.Database;
import dev.vstamenov.shop.controller.elements.ItemCard;
import dev.vstamenov.shop.controller.elements.ItemRow;
import dev.vstamenov.shop.model.Item;
import dev.vstamenov.shop.utility.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class LeftSideNavigation {

    public Button addSellBtn;

    public void logout(ActionEvent actionEvent) throws IOException {
        Session.logout();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        App.primaryStage.setScene(scene);
    }

    public void addSell(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/elements/editable_item_card.fxml"));
            Session.getContentController().setContentByFXML("view/elements/editable_item_card.fxml");
//        Scene scene = new Scene(fxmlLoader.load());
//        App.primaryStage.setScene(scene);
    }

    public void listMySells(ActionEvent actionEvent) {
        ArrayList<Item> items =  Database.getAllItemsByUserId(Session.getCurrentUser().getId());
        VBox listContainer = new VBox(10);

        for (Item item : items) {
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("view/elements/item_row.fxml"));
                HBox row = loader.load();
                ItemRow controller = loader.getController();

                controller.setItem(item);
                listContainer.getChildren().add(row);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        Session.getContentController().setContentByNode(listContainer);
    }

    public void allSells(ActionEvent actionEvent) {
        ArrayList<Item> items =  Database.getAllItems();
        FlowPane listContainer = new FlowPane();
        listContainer.setHgap(20);
        listContainer.setVgap(20);

        for (Item item : items) {
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("view/elements/item_card.fxml"));
                GridPane card = loader.load();
                ItemCard controller = loader.getController();

                controller.setItem(item);
                listContainer.getChildren().add(card);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        Session.getContentController().setContentByNode(listContainer);
    }
}