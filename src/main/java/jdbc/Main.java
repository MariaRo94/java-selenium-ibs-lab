package jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Insert data into the database
            insertData(connection, BigDecimal.valueOf(Math.random() * 1000), true, "Batat", "Vegitable");
            insertData(connection, BigDecimal.valueOf(Math.random() * 1000), false, "Onion", "Vegitable");
            insertData(connection, BigDecimal.valueOf(Math.random() * 1000), true, "Papaya", "Fruit");
            insertData(connection, BigDecimal.valueOf(Math.random() * 1000), false, "Apple", "Fruit");

            // Query data from the database
            queryData(connection);

            // Clear all data
            clearData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Connection connection, BigDecimal id, Boolean exotic, String item, String type) throws SQLException {
        String sql = "INSERT INTO item (id, exotic, name, type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBigDecimal(1, id);
            statement.setBoolean(2, exotic);
            statement.setString(3, item);
            statement.setString(4, type);
            statement.executeUpdate();
        }
    }

    private static void queryData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM item";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String exotic = resultSet.getString("exotic");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                System.out.println("id: " + id + ", exotic: " + exotic + ", name: " + name + ", type: " + type);
            }
        }
    }

    private static void clearData(Connection connection) throws SQLException {
        String sql = "DELETE FROM item";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int row = statement.executeUpdate();
            System.out.println("Affected rows: " + row);
        }
    }
}