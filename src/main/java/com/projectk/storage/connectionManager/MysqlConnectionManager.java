package com.projectk.storage.connectionManager;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
@Service
public class MysqlConnectionManager implements ConnectionManager {
    private final MysqlConnectionPoolDataSource source = new MysqlConnectionPoolDataSource();
    private Connection connection;
    private static final String DB_NAME = "projectK";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";

    {
        source.setDatabaseName(DB_NAME);
    }

    @Override
    public Connection getConnection() throws SQLException {
        connection = source.getConnection(DB_USER, DB_PASSWORD);
        return connection;
    }

    @Override
    public void closeConnection() throws  SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
