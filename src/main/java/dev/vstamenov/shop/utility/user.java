package dev.vstamenov.shop.utility;

public class user {
    private int id;
    private String name;
    private String password;
    private String role;


    // Constructor without id (used when creating a new item)
    public user( String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    // Constructor with id (used when loading from database)
    public user(int id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
