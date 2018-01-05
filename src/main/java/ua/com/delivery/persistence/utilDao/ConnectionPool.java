package ua.com.delivery.persistence.utilDao;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//я запускаю але як зробити щоб дії заносились в бд
public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private ConnectionPool() {
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    //connection for pool
    public Connection getConnection() {
        //Get DataSource
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/delivery");
            connection = dataSource.getConnection();
            //для транзакций,чтобы после каждого запроса делать коммит
            connection.setAutoCommit(false);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
