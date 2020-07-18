package com.projectk.storage.storageManager.implementations.helpers.PreparedStatementGenerator.implementations;

import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.storageManager.implementations.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SearchFacultyPreparedStatementGenerator implements PreparedStatementGenerator<SearchFaculty> {
    private Connection connection;

    public SearchFacultyPreparedStatementGenerator(Connection connection){
        this.connection = connection;
    }

    @Override
    public Object generatePreparedStatementFromSqlQuery(String sqlQuery, SearchFaculty searchFaculty) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        int variableIndex = 1;
        if(searchFaculty.getUniversityID() != null ){
            statement.setInt(variableIndex,searchFaculty.getUniversityID());
            variableIndex++;
        }
        if (searchFaculty.getFacultyCategory() != null) {
            statement.setString(variableIndex,searchFaculty.getFacultyCategory().name());
            variableIndex++;
        }
        if (searchFaculty.getMinPrice() != null) {
            statement.setLong(variableIndex,searchFaculty.getMaxPrice());
            variableIndex++;
        }
        if (searchFaculty.getMaxPrice() != null) {
            statement.setLong(variableIndex,searchFaculty.getMaxPrice());
        }
        return statement;
    }
}
