package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.insert;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

public class GetInsertQuery implements Step<University,String> {
    @Override
    public String process(University input){
        StringBuilder builder = new StringBuilder("insert into university values(?,?,?,?,?,?,?)");
        return builder.toString();
    }
}
