package com.projectk.storage.storageManager.implementations.helpers.PreparedStatementGenerator.implementations;

import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.storageManager.implementations.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SearchUniversityPreparedStatementGenerator implements PreparedStatementGenerator<SearchUniversity> {
    private Connection connection;

    public SearchUniversityPreparedStatementGenerator(Connection connection){
        this.connection = connection;
    }

    @Override
    public Object generatePreparedStatementFromSqlQuery(String sqlQuery, SearchUniversity searchUniversity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
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
        return statement;
    }
}
