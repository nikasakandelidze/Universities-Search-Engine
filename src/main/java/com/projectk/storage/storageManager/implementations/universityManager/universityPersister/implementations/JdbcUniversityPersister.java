package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.utilities.JdbcUtilities;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Pipeline;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.delete.PrepareDeleteStatement;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.insert.PrepareInsertStatement;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.select.PrepareSearchStatement;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.update.PrepareUpdateStatement;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.delete.GetDeleteQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.insert.GetInsertQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.select.GetSearchQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.update.GetUpdateQuery;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.interfaces.UniversityPersister;
import org.springframework.stereotype.Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcUniversityPersister implements UniversityPersister {

    @Override
    public List<University> filter(Connection connection, SearchUniversity searchEntity) throws StorageException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetSearchQuery()).pipe(new PrepareSearchStatement(connection, searchEntity)).process(searchEntity);
            resultSet = statement.executeQuery();
        } catch (SQLException | Step.StepException throwable) {
            throw new StorageException(throwable);
        }
        return JdbcUtilities.getListOfUniversities(resultSet);
    }


    @Override
    public University add(Connection connection, University entity) throws StorageException {
        boolean wasAdded;
        try {
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetInsertQuery()).pipe(new PrepareInsertStatement(connection, entity)).process(entity);
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
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetUpdateQuery()).pipe(new PrepareUpdateStatement(connection, entity)).process(entity);
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
            PreparedStatement statement = (PreparedStatement) new Pipeline<>(new GetDeleteQuery()).pipe(new PrepareDeleteStatement(connection, entity)).process(entity);
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException | Step.StepException throwables) {
            throw new StorageException(throwables);
        }
        return entity;
    }
}
