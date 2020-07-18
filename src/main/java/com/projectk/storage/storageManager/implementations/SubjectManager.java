package com.projectk.storage.storageManager.implementations;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SubjectManager implements StorageManager<Subject, SearchSubject> {

    private ConnectionManager connectionManager;

    public SubjectManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<Subject> filter(SearchSubject searchEntity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();

        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return null;
    }

    @Override
    public void add(Subject entity) {

    }

    @Override
    public void delete(Subject entity) {

    }

    @Override
    public void update(Subject entity) {

    }
}
