package com.projectk.storage.storageManager.implementations.facultystorage;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders.FacultyAddStatementBuilder;
import com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders.FacultyDeleteStatementBuilder;
import com.projectk.storage.storageManager.interfaces.StorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FacultyManager implements StorageManager<Faculty, SearchFaculty> {
    private final ConnectionManager connectionManager;

    @Autowired
    public FacultyManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<Faculty> filter(SearchFaculty searchEntity) throws StorageException {
        List<Faculty> resultList = new ArrayList<>();
        try {
            PreparedStatement statement = FacultyUtils.getSelectStatement(searchEntity, connectionManager.getConnection());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                resultList.add(FacultyUtils.getFaculty(rs));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
        return resultList;
    }

    @Override
    public void add(Faculty entity) throws StorageException {
        try {
            PreparedStatement statement = new FacultyAddStatementBuilder(connectionManager.getConnection(), entity).build();
            statement.execute();
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void delete(Faculty entity) throws StorageException {
        try {
            PreparedStatement statement = new FacultyDeleteStatementBuilder(connectionManager.getConnection(), entity).build();
            statement.execute();
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void update(Faculty entity) throws StorageException {
        try {
            PreparedStatement statement = FacultyUtils.getUpdateStatement(entity, connectionManager.getConnection());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    public Faculty find(Integer facultyId) throws StorageException {
        List<Faculty> resultList = new ArrayList<>();
        try {
            PreparedStatement statement = FacultyUtils.getFindStatement(facultyId, connectionManager.getConnection());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                resultList.add(FacultyUtils.getFaculty(rs));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
