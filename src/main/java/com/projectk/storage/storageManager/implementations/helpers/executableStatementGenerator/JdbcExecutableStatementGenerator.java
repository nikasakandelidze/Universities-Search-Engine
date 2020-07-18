package com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator;

import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;

import java.sql.SQLException;

public class JdbcExecutableStatementGenerator<T> implements ExecutableStatementGenerator<T> {
    private PreparedStatementGenerator<T> preparedStatementGenerator;
    private WildCardSqlQueryGenerator<T> wildCardSqlQueryGenerator;

    public JdbcExecutableStatementGenerator(PreparedStatementGenerator<T> preparedStatementGenerator,
                                            WildCardSqlQueryGenerator<T> wildCardSqlQueryGenerator){
        this.preparedStatementGenerator = preparedStatementGenerator;
        this.wildCardSqlQueryGenerator = wildCardSqlQueryGenerator;
    }

    @Override
    public Object getExecutableStatement(T searchEntity) throws StorageException {
        try {
            return preparedStatementGenerator.generatePreparedStatementFromSqlQuery(wildCardSqlQueryGenerator.generateWildCardQueryFromSearchEntity(searchEntity),searchEntity);
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }
}
