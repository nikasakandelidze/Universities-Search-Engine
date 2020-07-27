package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.sqlQuerySteps.select;

import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.Step;

public class GetSearchQuery implements Step<SearchUniversity, String> {
    @Override
    public String process(SearchUniversity input) {
        StringBuilder builder = new StringBuilder("SELECT * FROM university U WHERE 1 = 1");
        if (input.getUniversityId() != null) {
            builder.append(" and U.id = ?");
        }
        if (input.getCity() != null) {
            builder.append(" and U.city = ?");
        }
        if (input.getUniversityName() != null) {
            builder.append(" and U.university_name = ?");
        }
        if (input.getFacultyCategory() != null) {
            builder.append(" and U.facultyCategory = ?");
        }
        return builder.toString();
    }
}
