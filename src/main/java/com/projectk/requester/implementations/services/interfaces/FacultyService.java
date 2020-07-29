package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.Faculty;
import com.projectk.entities.ServiceResult;
import com.projectk.entities.ServiceResult;
import org.springframework.stereotype.Repository;

public interface FacultyService {
    ServiceResult addFaculty(Faculty faculty);

    ServiceResult updateFaculty(Faculty Faculty);
}
