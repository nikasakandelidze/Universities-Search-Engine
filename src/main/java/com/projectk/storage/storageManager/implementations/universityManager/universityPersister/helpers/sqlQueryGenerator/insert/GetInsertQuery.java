package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.sqlQueryGenerator.insert;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers.Step;

public class GetInsertQuery implements Step<University,String> {
    @Override
    public String process(University input){
        StringBuilder builder = new StringBuilder("insert into university values(?,?,?,?,?)");
        return builder.toString();
    }
}
