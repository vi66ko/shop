package dev.vstamenov.shop.model;

public class User {
    private int id;
    private String name;
    private String password;



    private String address;
    private String phone;

    // Constructor without id (used when creating a new item)
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    // Constructor without id (used when creating a new item)
    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
    }

    /** /
     *  Constructor mainly used when loading from database
    */
    public User(int id, String name, String password, String address, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
