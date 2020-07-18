package com.projectk.storage.storageManager.implementations.helpers.sqlQueryGenerators.implementations;

import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.storageManager.implementations.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;

public class SearchFacultyWildCardWildCardSqlQueryGenerator implements WildCardSqlQueryGenerator<SearchFaculty> {
    @Override
    public String generateWildCardQueryFromSearchEntity(SearchFaculty searchFaculty) {
        StringBuilder builder = new StringBuilder("SELECT * FROM faculty  f ");
        if(searchFaculty.getUniversityID() != null ){
            builder.append("join university on f.university_id = ? ");
        }
        builder.append(" where 1 = 1 ");
        if (searchFaculty.getFacultyCategory() != null) {
            builder.append(" and f.category = ?");
        }
        if (searchFaculty.getMinPrice() != null) {
            builder.append(" and f.price >= ?");
        }

        if (searchFaculty.getMaxPrice() != null) {
            builder.append(" and f.price <= ?");
        }
        return builder.toString();
    }
}
