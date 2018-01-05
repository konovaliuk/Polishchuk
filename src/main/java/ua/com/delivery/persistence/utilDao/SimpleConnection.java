package ua.com.delivery.persistence.utilDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SimpleConnection {
    private SimpleConnection() {

    }
    private static SimpleConnection instance = null;

    public static SimpleConnection getInstance(){
        if (instance==null){
            instance = new SimpleConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        try {
            Class.forName(resourceBundle.getString("driver"));
            connection = DriverManager.getConnection(resourceBundle.getString("db_url"),
                    resourceBundle.getString("user"),
                    resourceBundle.getString("password"));
            System.out.println("Connection Ok");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
