package com.projectk.requester.implementations.services.interfaces;

import  com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.requester.implementations.services.ServiceResult;


public interface FacultyService {
    ServiceResult addFaculty(Faculty faculty);

    ServiceResult updateFaculty(Faculty Faculty);

    ServiceResult filterFaculties(SearchFaculty searchFaculty);

    ServiceResult findFacultyById(int id);
}
