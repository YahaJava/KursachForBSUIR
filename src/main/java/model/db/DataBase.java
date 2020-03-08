package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static DataBase instance;
    private Connection connection;

    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=kursach;integratedSecurity=true";

    public static DataBase getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBase();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBase();
        }
        return instance;
    }

    private DataBase() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException ex) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnecyion() throws SQLException {
        connection.close();
    }
}
