package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.delete;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

import java.sql.SQLException;

public class GetDeleteQuery implements Step<University, String> {
    @Override
    public String process(University input) {
        StringBuilder builder = new StringBuilder("DELETE FROM university U WHERE U.id = ?;");
        return builder.toString();
    }
}
