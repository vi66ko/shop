package dev.vstamenov.shop.model;

public class Item {

    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String pictureUri;
    private double rating;
    private int userId;

    // Constructor without id (used when creating a new item)
    public Item(String name, String description, int quantity, double price, String pictureUri, double rating) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.rating = price;
        this.price = price;
        this.pictureUri = pictureUri;

    }

    // Constructor with id (used when loading from database)
    public Item(int id, String name,String description, int quantity, double price, String pictureUri, double rating) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
