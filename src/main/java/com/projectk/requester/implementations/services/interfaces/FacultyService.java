package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.Faculty;
import com.projectk.requester.implementations.services.ServiceResult;
import org.springframework.stereotype.Repository;

public interface FacultyService {
    ServiceResult addFaculty(Faculty faculty);

    ServiceResult updateFaculty(Faculty Faculty);
}
