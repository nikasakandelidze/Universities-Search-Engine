package com.projectk.storage.storageManager.implementations.subject.executableStatementGenerator;

import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.subject.executableStatementGenerator.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.subject.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;

import java.sql.SQLException;

public class JdbcExecutableStatementGenerator<T,Q> implements ExecutableStatementGenerator<T,Q> {
    private PreparedStatementGenerator<T> preparedStatementGenerator;
    private WildCardSqlQueryGenerator<T> wildCardSqlQueryGenerator;

    public JdbcExecutableStatementGenerator(PreparedStatementGenerator<T> preparedStatementGenerator,
                                            WildCardSqlQueryGenerator<T> wildCardSqlQueryGenerator){
        this.preparedStatementGenerator = preparedStatementGenerator;
        this.wildCardSqlQueryGenerator = wildCardSqlQueryGenerator;
    }

    @Override
    public Object getSelectExecutableStatement(T searchEntity) throws StorageException {
        try {
            return preparedStatementGenerator.generatePreparedStatementFromSqlQuery(wildCardSqlQueryGenerator.generateWildCardQueryFromSearchEntity(searchEntity),searchEntity);
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    @Override
    public Object getAddExecutableStatement(Q newEntity) {
        return null;
    }

    @Override
    public Object getUpdateExecutableStatement(Q newEntity) {
        return null;
    }

    @Override
    public Object getDeleteExecutableStatement(int id) {
        return null;
    }
}
