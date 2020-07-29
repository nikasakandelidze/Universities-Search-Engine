package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.Faculty;
import com.projectk.requester.implementations.services.ServiceResult;

public interface FacultyService {
    ServiceResult addFaculty(Faculty faculty);

    ServiceResult updateFaculty(Faculty Faculty);
}
