package dev.vstamenov.shop.controller.elements;

import dev.vstamenov.shop.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ItemCard {
    @FXML
    public ImageView image;
    @FXML
    public Label title;
    @FXML
    public Label ratingLabel;
    @FXML
    public Label price;
    @FXML
    public TextField quantityField;
    @FXML
    public Label ratingValue;
    @FXML
    public Text description;
    @FXML
    public Label available;

    public void setItem(Item item) {
        // Set upt the image if there is not image a
//        this.image
        this.title.setText(item.getName());
        this.description.setText(item.getDescription());
        this.price.setText(String.valueOf(item.getPrice()));
        this.available.setText(String.valueOf(item.getQuantity()));

    }

    public void addToBasket(ActionEvent actionEvent) {
    }
}
