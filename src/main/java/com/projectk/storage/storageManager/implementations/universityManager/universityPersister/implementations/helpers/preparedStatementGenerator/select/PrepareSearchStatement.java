package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementGenerator.select;

import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareSearchStatement implements Step<String, Object> {
    private Connection connection;
    private SearchUniversity searchUniversity;
    public PrepareSearchStatement(Connection connection, SearchUniversity searchUniversity){
        this.connection = connection;
        this.searchUniversity = searchUniversity;
    }

    @Override
    public PreparedStatement process(String input) throws StepException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(input);
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
        } catch (SQLException throwables) {
            throw new StepException(throwables);
        }
        return statement;
    }
}
