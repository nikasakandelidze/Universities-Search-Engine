package com.projectk.storage.interfaces.helpers;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;

import java.util.List;

public interface FacultyStorage {
    List<Faculty> filterFaculties(SearchFaculty searchFaculty);

    void addFaculty(Faculty faculty);

    void deleteFaculty(Faculty faculty);

    void updateFaculty(Faculty faculty);
}
