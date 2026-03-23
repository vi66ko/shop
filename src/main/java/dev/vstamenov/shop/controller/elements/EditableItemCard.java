package dev.vstamenov.shop.controller.elements;

import dev.vstamenov.shop.Database;
import dev.vstamenov.shop.model.Item;
import dev.vstamenov.shop.utility.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class EditableItemCard {
    @FXML
    private ImageView imageView;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea description;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;

    @FXML
    private Label errorFeedbackLabel;
    @FXML
    private Button save;
    @FXML
    private Button cancel;


    public void saveItem(ActionEvent actionEvent) {

        // Creating an item
        String name = this.nameField.getText();
        String description = this.description.getText();
        String priceStr =  this.priceField.getText();
        String quantityStr = this.quantityField.getText();
        String pictureUri = imageView.getImage().getUrl();

        final double rating = 0;


        int quantity;
        double price;


        // Validation
        if (name.isEmpty() || description.isEmpty() || quantityStr.isEmpty() || priceStr.isEmpty()) {
            errorFeedbackLabel.setText("All fields are required");
            return;
        }

        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            errorFeedbackLabel.setText("Quantity must be a valid number");
            return;
        }

        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            errorFeedbackLabel.setText("Price must be a valid number");
            return;
        }

        if (quantity <= 0) {
            errorFeedbackLabel.setText("Quantity cannot be negative or zero");
            return;
        }

        if (price < 0) {
            errorFeedbackLabel.setText("Price cannot be negative");
            return;
        }

        Item item = new Item(name, description, quantity, price, pictureUri, rating);
        boolean success = Database.addItem(item);
//
        if (success) {
//            // go back or show success
            System.out.println("Item added successfully");
        } else {
            errorFeedbackLabel.setText("Failed to save item, try again");
        }

//        // Save the item?
    }

    public void cancel(ActionEvent actionEvent) {
//        actually adding item will be like a pop up

    }


}
