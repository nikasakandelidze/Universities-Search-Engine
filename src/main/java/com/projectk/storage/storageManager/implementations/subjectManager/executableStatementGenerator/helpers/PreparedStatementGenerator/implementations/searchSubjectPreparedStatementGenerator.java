package com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.PreparedStatementGenerator.implementations;

import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class searchSubjectPreparedStatementGenerator implements PreparedStatementGenerator<SearchSubject> {
    private Connection connection;

    public searchSubjectPreparedStatementGenerator(Connection connection){
        this.connection = connection;
    }

    @Override
    public Object generatePreparedStatementFromSqlQuery(String sqlQuery, SearchSubject searchSubject) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        int variableIndex=1;
        if(searchSubject.getFacultyId()!=null){
            statement.setInt(variableIndex,searchSubject.getFacultyId());
            variableIndex++;
        }
        if(searchSubject.getSubjectName()!=null){
            statement.setString(variableIndex,searchSubject.getSubjectName());
            variableIndex++;
        }
        if(searchSubject.getFacultyId()!=null && searchSubject.getUniversityId()!=null){
            statement.setInt(variableIndex,searchSubject.getFacultyId());
            variableIndex++;
            statement.setInt(variableIndex,searchSubject.getUniversityId());
        }
        return statement;
    }
}
