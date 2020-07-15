package com.projectk.storage.interfaces.helpers;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;

import java.util.List;

public interface UniversityStorage {
    List<University> filterUniversity(SearchUniversity searchUniversity);

    void addUniversity(University university);

    void deleteUniversity(University university);

    void updateUniversity(University university);
}
