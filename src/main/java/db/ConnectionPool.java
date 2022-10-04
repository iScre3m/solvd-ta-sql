package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private final String DRIVER;
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private final int POOL_SIZE;
    private final AtomicInteger actualSize = new AtomicInteger(0);
    private final BlockingQueue<Connection> connectionPool;

    private ConnectionPool() {
        Properties properties = new Properties();
        try {
            System.out.println(System.getProperty("user.dir"));
            FileInputStream file = new FileInputStream("src/main/resources/sqlconfig.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("sqlconfig properties file not found");
        }

        DRIVER = properties.getProperty("driver");
        URL = properties.getProperty("url");
        USER = properties.getProperty("user");
        PASSWORD = properties.getProperty("password");
        POOL_SIZE = Integer.parseInt(properties.getProperty("poolSize"));

        connectionPool = new ArrayBlockingQueue<>(POOL_SIZE);
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
            LOGGER.error("sqlconfig implementation not found");
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        if (actualSize.get() < POOL_SIZE) {
            try {
                connectionPool.add(DriverManager.getConnection(URL, USER, PASSWORD));
                actualSize.incrementAndGet();
            } catch (SQLException e) {
                LOGGER.error(e);
                LOGGER.error("Something went wrong when getting a connection");
            }
        }
        try {
            Connection connection = connectionPool.take();
            return connection;
        } catch (InterruptedException e) {
            LOGGER.error("Thread interrupted");
            return null;
        }
    }

    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
    }

    public void closeAll() throws SQLException, InterruptedException {
        while (actualSize.get() > 0) {
            Connection connection = connectionPool.take();
            connection.close();
            actualSize.decrementAndGet();
        }
    }
}
