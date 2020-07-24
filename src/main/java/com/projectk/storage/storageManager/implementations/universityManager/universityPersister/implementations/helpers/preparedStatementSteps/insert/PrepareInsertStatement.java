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
            preparedStatement.setInt(1,university.getId());
            preparedStatement.setString(2,university.getUniversityName());
            preparedStatement.setString(3,university.getCity());
            preparedStatement.setString(4,university.getAddress());
            preparedStatement.setString(5,university.getWebPageLink());
            preparedStatement.setString(6,university.getDescriptions());
            preparedStatement.setString(7,university.getUsername());
        } catch (SQLException throwables) {
            throw new StepException(throwables);
        }
        return preparedStatement;
    }
}
