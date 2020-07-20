package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.insert;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareInsertStatement implements Step<String, Object> {
    private Connection connection;
    private University university;

    public PrepareInsertStatement(Connection connection, University university){
        this.connection = connection;
        this.university = university;
    }

    @Override
    public PreparedStatement process(String input) throws StepException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(input);
            preparedStatement.setString(1,university.getUniversityName());
            preparedStatement.setString(2,university.getCity());
            preparedStatement.setString(3,university.getAddress());
            preparedStatement.setString(4,university.getWebPageLink());
            preparedStatement.setString(5,university.getDescriptions());
        } catch (SQLException throwables) {
            throw new StepException(throwables);
        }
        return preparedStatement;
    }
}
