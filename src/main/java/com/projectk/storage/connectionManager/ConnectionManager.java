package com.projectk.storage.connectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    Connection getConnection() throws SQLException;
    void closeConnection() throws SQLException;
}
