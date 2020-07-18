package com.projectk.storage.storageManager.implementations;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UniversityManager implements StorageManager<University, SearchUniversity> {
    private ConnectionManager connectionManager;

    public UniversityManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<University> filter(SearchUniversity searchUniversity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();

        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }

        return null;
    }
    private void fillPreparedStatement(PreparedStatement statement, SearchUniversity searchUniversity) throws  SQLException{
        int variableIndex=1;
        if(searchUniversity.getUniversityId()!=null){
            statement.setInt(variableIndex,searchUniversity.getUniversityId());
            variableIndex++;
        }
        if(searchUniversity.getCity()!=null){
            statement.setString(variableIndex,searchUniversity.getCity());
            variableIndex++;
        }
        if(searchUniversity.getUniversityName()!=null){
            statement.setString(variableIndex,searchUniversity.getUniversityName());
            variableIndex++;
        }
//        if(searchUniversity.getFaculty()!=null){
//            statement.setString(variableIndex,searchUniversity.getFaculty());
//            variableIndex++;
//        }
    }

    @Override
    public void add(University entity) {

    }

    @Override
    public void delete(University entity) {

    }

    @Override
    public void update(University entity) {

    }
}
