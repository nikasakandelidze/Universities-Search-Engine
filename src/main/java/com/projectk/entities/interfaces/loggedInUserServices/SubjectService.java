package com.projectk.entities.interfaces.loggedInUserServices;

import com.projectk.entities.ServiceResult;
import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;

public interface SubjectService {

    ServiceResult addSubject(Subject subject);

    ServiceResult updateSubject(Subject subject);

    ServiceResult filterSubjects(SearchSubject searchSubject);

}
