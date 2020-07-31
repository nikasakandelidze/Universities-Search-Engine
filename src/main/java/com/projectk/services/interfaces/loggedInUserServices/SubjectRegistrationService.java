package com.projectk.services.interfaces.loggedInUserServices;

import com.projectk.entities.Subject;
import com.projectk.entities.ServiceResult;

public interface SubjectRegistrationService {

    ServiceResult addSubject(Subject subject);

    ServiceResult updateSubject(Subject subject);
}
