package com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.PreparedStatementGenerator.interfaces;

import java.sql.SQLException;

public interface PreparedStatementGenerator<T> {
    Object generatePreparedStatementFromSqlQuery(String sqlQuery, T searchEntity) throws SQLException;
}
