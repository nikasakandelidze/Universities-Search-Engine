package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.Subject;
import com.projectk.entities.ServiceResult;

public interface SubjectService {

    ServiceResult addSubject(Subject subject);

    ServiceResult updateSubject(Subject subject);
}
