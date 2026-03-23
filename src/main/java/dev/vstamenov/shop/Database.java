package dev.vstamenov.shop;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.vstamenov.shop.model.Item;
import dev.vstamenov.shop.model.User;
import dev.vstamenov.shop.utility.Session;

public class Database {

    private static final String dataBaseURI = "jdbc:sqlite:database/shop.db";


    public static void connect(){
        // Because the use of try-with-resource statement, the database connection will close automatically.
        try (var conn = DriverManager.getConnection(dataBaseURI)){
            System.out.println("Connection to Database has been established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

     public static boolean addItem(Item item){
        String query = "INSERT INTO item(name, quantity, price, picture_uri, seller_id, description) VALUES(?, ?, ?, ?, ?, ?)";

        try (var conn = DriverManager.getConnection(dataBaseURI)){
            System.out.println("Connection to Database has been established");

            var newRecord = conn.prepareStatement(query);

            newRecord.setString(1, item.getName());
            newRecord.setInt(2, item.getQuantity());
            newRecord.setDouble(3, item.getPrice());
            newRecord.setString(4, item.getPictureUri());
            newRecord.setInt(5, Session.getCurrentUser().getId());
            newRecord.setString(6, item.getDescription());

            newRecord.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }


    static Item  getItemById(int id){
        String query = "SELECT * FROM item WHERE id = ?";
        Item item = null;

        try ( var conn = DriverManager.getConnection(dataBaseURI)){
            System.out.println("Connection to Database has been established");

            PreparedStatement preparedStatement =  conn.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            item = createItemFromResultSet(resultSet);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return item;
    }



    public static ArrayList<Item> getAllItems(){
        String query = "SELECT * FROM item";

        ArrayList<Item> items = new ArrayList<>();

        try (var conn = DriverManager.getConnection(dataBaseURI);

            var stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                items.add(createItemFromResultSet(resultSet));
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return items;

    }

    public static ArrayList<Item> getAllItemsByUserId(int id){
        String query = "SELECT * FROM item WHERE  seller_id = ?";

        ArrayList<Item> items = new ArrayList<>();

        try (var conn = DriverManager.getConnection(dataBaseURI);
             var stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                items.add(createItemFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return items;

    }

    private static Item createItemFromResultSet(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getInt("quantity"),
                resultSet.getDouble("price"),
                resultSet.getString("picture_uri"),
                resultSet.getDouble("rating")
        );
    }
    private static User getUserFromResultSet(ResultSet resultSet) throws SQLException {
               return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("password"),
                resultSet.getString("address"),
                resultSet.getString("phone_number")
               );

    }

//  Account managing

    public static User login(String name, String password ){
        String query = "SELECT * FROM user WHERE name = ? AND password = ?";

        try (var connectin = DriverManager.getConnection(dataBaseURI);
             var stmt = connectin.prepareStatement(query)){
            stmt.setString(1, name);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) return getUserFromResultSet(resultSet);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static boolean isUserExists(String name){
        String query = "SELECT * FROM user WHERE name = ?";

        try(var connection = DriverManager.getConnection(dataBaseURI);
            var stmt = connection.prepareStatement(query)){

            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();

            return resultSet.next();

        } catch (SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean registerUser(User user){
        String query = "INSERT INTO user(name, password) VALUES(?, ?)";

        try(var conn = DriverManager.getConnection(dataBaseURI);
            var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
