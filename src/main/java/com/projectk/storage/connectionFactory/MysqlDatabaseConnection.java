package com.projectk.storage.connectionFactory;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlDatabaseConnection implements DatabaseConnection {
    private DataSource source = new MysqlConnectionPoolDataSource();

    @Override
    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}
