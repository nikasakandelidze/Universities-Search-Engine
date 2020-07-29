package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.Faculty;
import com.projectk.entities.ServiceResult;
import com.projectk.entities.ServiceResult;
import com.projectk.entities.searchEntities.SearchFaculty;
import org.springframework.stereotype.Repository;

public interface FacultyService {
    ServiceResult addFaculty(Faculty faculty);

    ServiceResult updateFaculty(Faculty Faculty);

    ServiceResult filterFaculties(SearchFaculty searchFaculty);
}
