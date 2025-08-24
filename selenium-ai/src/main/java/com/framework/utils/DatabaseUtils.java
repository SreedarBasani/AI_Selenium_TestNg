package com.framework.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtils {

    private static Connection connection;

    public static void connectToDatabase() {
        try {
            String url = ConfigReader.getProperty("db.url");
            String username = ConfigReader.getProperty("db.username");
            String password = ConfigReader.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database");
        }
    }

    public static List<Map<String, Object>> executeQuery(String query) {
        List<Map<String, Object>> results = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
