package com.projectk.requester.implementations.services.interfaces.loggedInUserServices;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.requester.implementations.services.ServiceResult;

public interface SubjectService {

    ServiceResult addSubject(Subject subject);

    ServiceResult updateSubject(Subject subject);

    ServiceResult filterSubjects(SearchSubject searchSubject);

}
