package com.projectk.requester.interfaces;

import com.projectk.entities.enums.FacultyCategory;

public interface FacultyRequester {
    Object displayFacultyRegistration();

    Object executeFacultyRegistration(int facultyId, FacultyCategory category, int universityId, String name,
                                      String deanInfo, long price, String description, String webPageLink);
}
