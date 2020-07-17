package com.projectk.storage.dataBaseConnection;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlDatabaseConnection implements DatabaseConnection {
    private final MysqlConnectionPoolDataSource source = new MysqlConnectionPoolDataSource();
    private static final String DB_NAME = "projectK";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    @Override
    public Connection getConnection() throws SQLException {
        source.setDatabaseName(DB_NAME);
        return source.getConnection(DB_USER, DB_PASSWORD);
    }
}
