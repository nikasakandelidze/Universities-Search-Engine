package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.update;

import com.projectk.entities.University;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

public class GetUpdateQuery implements Step<University, String> {
    @Override
    public String process(University input) throws StepException {
        StringBuilder builder = new StringBuilder("update university set ");
        if (input.getUniversityName() != null) {
            builder.append("university_name = ? ");
        }
        if (input.getCity() != null) {
            builder.append(",city = ? ");
        }
        if (input.getAddress() != null) {
            builder.append(", address = ? ");
        }
        if (input.getWebPageLink() != null) {
            builder.append(", web_page_link = ? ");
        }
        if (input.getDescriptions() != null) {
            builder.append(", descriptions = ? ");
        }
        builder.append("where id = ?");
        return builder.toString();
    }
}
