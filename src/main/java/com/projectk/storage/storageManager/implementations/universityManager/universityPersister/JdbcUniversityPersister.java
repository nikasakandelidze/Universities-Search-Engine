package com.projectk.storage.storageManager.implementations.universityManager.universityPersister;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.Pipeline;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.Step;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.preparedStatementGenerator.delete.PrepareDeleteStatement;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.preparedStatementGenerator.insert.PrepareInsertStatement;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.preparedStatementGenerator.select.PrepareSearchStatementStep;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.preparedStatementGenerator.update.PrepareUpdateStatementStep;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.sqlQueryGenerator.delete.GetDeleteQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.sqlQueryGenerator.insert.GetInsertQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.sqlQueryGenerator.select.GetSearchQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.sqlQueryGenerator.update.GetUpdateQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcUniversityPersister implements UniversityPersister {

    @Override
    public List<University> filter(Connection connection, SearchUniversity searchEntity) throws StorageException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetSearchQuery())
                    .pipe(new PrepareSearchStatementStep(connection, searchEntity))
                    .process(searchEntity);
            resultSet = statement.executeQuery();
        } catch (SQLException | Step.StepException throwable) {
            throw new StorageException(throwable);
        }


        //todo: process resultSet
        return null;
    }

    @Override
    public University add(Connection connection, University entity) throws StorageException {
        boolean wasAdded;
        try {
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetInsertQuery())
                    .pipe(new PrepareInsertStatement(connection, entity))
                    .process(entity);
            wasAdded = statement.execute();
        } catch (SQLException | Step.StepException throwables) {
            throw new StorageException(throwables);
        }
        return entity;
    }

    @Override
    public University update(Connection connection, University entity) throws StorageException {
        int resultSet;
        try {
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetUpdateQuery())
                    .pipe(new PrepareUpdateStatementStep(connection, entity))
                    .process(entity);
            resultSet = statement.executeUpdate();
        } catch (SQLException | Step.StepException throwables) {
            throw new StorageException(throwables);
        }
        return entity;
    }

    @Override
    public University delete(Connection connection, University entity) throws StorageException {
        int rowsDeleted = 0;
        try {
            PreparedStatement statement =(PreparedStatement) new Pipeline<>(new GetDeleteQuery())
                    .pipe(new PrepareDeleteStatement(connection, entity))
                    .process(entity);
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException | Step.StepException throwables) {
            throw new StorageException(throwables);
        }
        return entity;
    }
}
