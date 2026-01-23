package dev.vstamenov.shop.utility;

public class Item {

    private int id;
    private String name;
    private int quantity;
    private double price;
    private String pictureUri;
    private double rating;

    // Constructor without id (used when creating a new item)
    public Item(String name, int quantity, double price, String pictureUri, double rating) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.pictureUri = pictureUri;
        this.rating = rating;
    }

    // Constructor with id (used when loading from database)
    public Item(int id, String name, int quantity, double price, String pictureUri, double rating) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.pictureUri = pictureUri;
        this.rating = rating;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
