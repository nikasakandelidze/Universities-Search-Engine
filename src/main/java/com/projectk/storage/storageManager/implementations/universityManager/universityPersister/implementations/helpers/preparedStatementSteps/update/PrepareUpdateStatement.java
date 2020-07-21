package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.preparedStatementSteps.update;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareUpdateStatement implements Step<String, Object> {
    private Connection connection;
    private University university;

    public PrepareUpdateStatement(Connection connection, University university) {
        this.connection = connection;
        this.university = university;
    }

    @Override
    public PreparedStatement process(String input) throws StepException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(input);
            int variableIndex = 1;
            if (university.getUniversityName() != null) {
                preparedStatement.setString(variableIndex, university.getUniversityName());
                variableIndex++;
            }
            if (university.getCity() != null) {
                preparedStatement.setString(variableIndex, university.getCity());
                variableIndex++;
            }
            if (university.getAddress() != null) {
                preparedStatement.setString(variableIndex, university.getAddress());
                variableIndex++;
            }
            if (university.getWebPageLink() != null) {
                preparedStatement.setString(variableIndex, university.getWebPageLink());
                variableIndex++;
            }
            if (university.getDescriptions() != null) {
                preparedStatement.setString(variableIndex, university.getDescriptions());
                variableIndex++;
            }
            preparedStatement.setInt(variableIndex, university.getId());
        } catch (SQLException throwables) {
            throw new StepException(throwables);
        }
        return preparedStatement;
    }
}
