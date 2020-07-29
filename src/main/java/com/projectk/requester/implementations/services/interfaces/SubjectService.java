package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.Subject;
import com.projectk.requester.implementations.services.ServiceResult;

public interface SubjectService {

    ServiceResult addSubject(Subject subject);

    ServiceResult updateSubject(Subject subject);
}
