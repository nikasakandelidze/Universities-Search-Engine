package com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.sqlQueryGenerators.implementations;

import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;

public class SearchSubjectWildCardSqlQueryGenerator implements WildCardSqlQueryGenerator<SearchSubject> {
    @Override
    public String generateWildCardQueryFromSearchEntity(SearchSubject searchSubject) {
        StringBuilder builder = new StringBuilder("SELECT * FROM university_subject us ");
        builder.append("join faculty f on  us.faculty_id=f.faculty_id\n" +
                "where 1=1 ");
        if (searchSubject.getFacultyId() != null) {
            builder.append("and us.faculty_id=? ");
        }
        if (searchSubject.getSubjectName() != null) {
            builder.append("and us.subject_name=? ");
        }
        if (searchSubject.getUniversityId() != null && searchSubject.getFacultyId() != null) {
            builder.append("and us.faculty_id =? and f.university_id=? ");
        }
        return builder.toString();
    }
}
