package com.projectk.storage.connectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    Connection getConnection() throws ConnectionException, SQLException;
    void closeConnection() throws ConnectionException, SQLException;
}
