package dev.vstamenov.shop;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.vstamenov.shop.model.Item;

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

     static boolean addItem(Item item){
        String query = "INSERT INTO items(name, quantity, price, picture_uri, rating) VALUES(?, ?, ?, ?, ?)";

        try (var conn = DriverManager.getConnection(dataBaseURI)){
            System.out.println("Connection to Database has been established");

            var newRecord = conn.prepareStatement(query);

            newRecord.setString(1, item.getName());
            newRecord.setInt(2, item.getQuantity());
            newRecord.setDouble(3, item.getPrice());
            newRecord.setString(4, item.getPictureUri());
            newRecord.setDouble(5, item.getRating());

            newRecord.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return false;
    }


    static Item  getItemById(int id){
        String query = "SELECT * FROM items WHERE id = ?";
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


    static ArrayList<Item> getAllItems(){
        String query = "SELECT * FROM items";

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

    private static Item createItemFromResultSet(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("quantity"),
                resultSet.getDouble("price"),
                resultSet.getString("picture_uri"),
                resultSet.getDouble("rating")
        );
    }


}
