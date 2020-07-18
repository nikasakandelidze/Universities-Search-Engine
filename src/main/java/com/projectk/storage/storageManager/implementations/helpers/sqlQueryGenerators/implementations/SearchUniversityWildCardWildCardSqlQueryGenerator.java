package com.projectk.storage.storageManager.implementations.helpers.sqlQueryGenerators.implementations;

import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.storageManager.implementations.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;

public class SearchUniversityWildCardWildCardSqlQueryGenerator implements WildCardSqlQueryGenerator<SearchUniversity> {
    @Override
    public String generateWildCardQueryFromSearchEntity(SearchUniversity searchUniversity) {
        StringBuilder builder = new StringBuilder("SELECT * FROM university U WHERE 1 = 1");
        if (searchUniversity.getUniversityId() != null) {
            builder.append("and U.id = ?");
        }
        if (searchUniversity.getCity() != null) {
            builder.append("and U.city = ?");
        }
        if (searchUniversity.getUniversityName() != null) {
            builder.append("and U.university_name = ?");
        }
        if (searchUniversity.getFacultyCategory() != null) {
            builder.append("and U.facultyCategory = ?");
        }
        return builder.toString();
    }
}
