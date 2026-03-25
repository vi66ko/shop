package dev.vstamenov.shop.controller.layout;

import dev.vstamenov.shop.App;
import dev.vstamenov.shop.utility.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class ContentController {

    public ScrollPane content;

    public void initialize() {
        Session.setContentController(this);
    }

    public void setContentByFXML(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlPath));
            content.setContent(loader.load());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /***
     * Using polymorphisms helps me to use any container or elements
     * because all of them have a parent Node
     */
    public void setContentByNode(Node node) {
        getContent().setContent(node);
    }

    public ScrollPane getContent() {
        return content;
    }
}
