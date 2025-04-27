package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class PostgreSQL {
    private Connection connection;

    public PostgreSQL() {
        try {
            // Establish the database connection in the constructor
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        }
    }

    public void sendData(String urlValue, String linkValue, String contentValue) {
        String sql = "INSERT INTO advertising_sector (url, link, content, time_stamp) VALUES (?, ?, ?, ?)";

        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            // Prepare and execute the INSERT statement in a separate method
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, urlValue);
            statement.setString(2, linkValue);
            statement.setString(3, contentValue);
            statement.setTimestamp(4, timestamp);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row has been inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error executing INSERT statement: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection has been closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}
