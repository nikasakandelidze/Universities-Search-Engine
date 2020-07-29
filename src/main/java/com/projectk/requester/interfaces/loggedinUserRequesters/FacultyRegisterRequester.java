package com.projectk.requester.interfaces.loggedinUserRequesters;

import com.projectk.entities.enums.FacultyCategory;

public interface FacultyRegisterRequester {
    Object displayFacultyRegistration();

    Object executeFacultyRegistration(int facultyId, String  category, int uniId, String name,
                                      String deanInfo, long price, String description, String webPage);
}
