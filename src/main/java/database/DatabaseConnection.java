package database;

import java.sql.*;
import java.util.Objects;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private Connection connection;
    private Statement statement;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() throws SQLException {
        return Objects.requireNonNullElseGet(databaseConnection, () -> databaseConnection = new DatabaseConnection());
    }

    public void connect(String url, String user, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Can't connect");
        }
    }

    public double getDouble(String table, String column, String findingCondition) throws SQLException {
        try {
            var resultSet = statement
                    .executeQuery("SELECT " + column + " FROM " + table + " WHERE " + findingCondition + ";");
            resultSet.next();
            return resultSet.getDouble(column);
        } catch (SQLException e) {
            System.out.println("Unable to get value from database");
            throw e;
        }
    }

    public void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
