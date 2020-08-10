package com.projectk.services.interfaces;

import  com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.ServiceResult;


public interface FacultyService {
    ServiceResult addFaculty(Faculty faculty);

    ServiceResult updateFaculty(Faculty Faculty);

    ServiceResult filterFaculties(SearchFaculty searchFaculty);

    ServiceResult findFacultyById(String id, String resultView, boolean isUpdate);
}
