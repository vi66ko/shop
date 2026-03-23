package dev.vstamenov.shop.utility;

import dev.vstamenov.shop.Database;
import dev.vstamenov.shop.controller.layout.ContentController;
import dev.vstamenov.shop.model.Item;
import dev.vstamenov.shop.model.User;

import java.util.ArrayList;

public class Session {
    private static User currentUser;
    private static ArrayList<Item> basket = new ArrayList<>();
    private static ContentController contentController;

    // User
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static void logout(){
        currentUser = null;
    }

    // Content Controller
    public static void setContentController(ContentController controller) {
        contentController = controller;
    }
    public static ContentController getContentController() {
        return contentController;
    }

    // Basket
    public static ArrayList<Item> getBasket() {
        return basket;
    }

    public static void addToBasket(Item item) {
        basket.add(item);

    }

    public static void removeFromBasket(Item item) {
        basket.remove(item);
    }



}
