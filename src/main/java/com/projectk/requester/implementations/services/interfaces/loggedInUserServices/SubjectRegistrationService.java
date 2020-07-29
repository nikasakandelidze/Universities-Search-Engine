package com.projectk.requester.implementations.services.interfaces.loggedInUserServices;

import com.projectk.entities.Subject;
import com.projectk.requester.implementations.services.ServiceResult;

public interface SubjectRegistrationService {

    ServiceResult addSubject(Subject subject);

    ServiceResult updateSubject(Subject subject);
}
