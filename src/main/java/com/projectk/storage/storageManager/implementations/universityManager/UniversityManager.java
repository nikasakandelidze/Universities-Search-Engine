package com.projectk.storage.storageManager.implementations.universityManager;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.interfaces.UniversityPersister;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniversityManager implements StorageManager<University, SearchUniversity> {
    private final ConnectionManager connectionManager;
    private final UniversityPersister universityPersister;

    public UniversityManager(ConnectionManager connectionManager, UniversityPersister universityPersister) {
        this.connectionManager = connectionManager;
        this.universityPersister = universityPersister;
    }

    @Override
    public List<University> filter(SearchUniversity searchUniversity) throws StorageException {
        List<University> result = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection()){
            result = universityPersister.filter(connection, searchUniversity);
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return result;
    }

    @Override
    public void add(University entity) throws StorageException {
        try(Connection connection = connectionManager.getConnection()){
            universityPersister.add(connection, entity);
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    @Override
    public void delete(University entity) throws StorageException {
        try(Connection connection = connectionManager.getConnection()){
            universityPersister.delete(connection, entity);
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    @Override
    public void update(University entity) throws StorageException {
        try(Connection connection = connectionManager.getConnection()){
            universityPersister.update(connection, entity);
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }
}
