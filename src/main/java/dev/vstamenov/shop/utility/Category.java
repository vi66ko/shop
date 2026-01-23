package dev.vstamenov.shop.utility;

public class Category {
    private int id;
    private final String name;


    // Constructor without id (used when creating a new item)
    public Category(String name) {
        this.name = name;
    }

    // Constructor with id (used when loading from database)
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

