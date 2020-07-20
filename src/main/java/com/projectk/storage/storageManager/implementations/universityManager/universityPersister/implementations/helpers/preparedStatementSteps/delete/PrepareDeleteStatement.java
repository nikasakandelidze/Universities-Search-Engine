package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.delete;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareDeleteStatement implements Step<String, Object> {
    private Connection connection;
    private University university;

    public PrepareDeleteStatement(Connection connection, University university){
        this.connection = connection;
        this.university = university;
    }

    @Override
    public PreparedStatement process(String input) throws StepException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(input);
            preparedStatement.setInt(1,university.getId());
        } catch (SQLException throwables) {
            throw new StepException(throwables);
        }
        return preparedStatement;
    }
}
