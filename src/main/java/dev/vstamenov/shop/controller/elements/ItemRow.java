package dev.vstamenov.shop.controller.elements;

import dev.vstamenov.shop.Database;
import dev.vstamenov.shop.model.Item;
import dev.vstamenov.shop.utility.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ItemRow {
    @FXML
    private VBox itemList;

    @FXML private Label nameLabel;
    @FXML private Label descLabel;
    @FXML private Label priceLabel;
    @FXML private Label quantityLabel;

    public void setItem(Item item) {
        nameLabel.setText(item.getName());
        descLabel.setText(item.getDescription());
        priceLabel.setText("$" + item.getPrice());
        quantityLabel.setText(String.valueOf(item.getQuantity()));
    }

    @FXML
    public void edit(ActionEvent actionEvent) {
        // popup placeholder
    }

    private void loadItems() {
        ArrayList<Item> items = Database.getAllItemsByUserId(Session.getCurrentUser().getId());

    }


}
