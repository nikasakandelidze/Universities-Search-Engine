package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.sqlQueryGenerator.delete;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.Step;

import java.sql.SQLException;

public class GetDeleteQuery implements Step<University,String> {
    @Override
    public String process(University input) throws SQLException {
        StringBuilder builder = new StringBuilder("DELETE FROM university U WHERE and U.id = ?" );
        return builder.toString();
    }
}
