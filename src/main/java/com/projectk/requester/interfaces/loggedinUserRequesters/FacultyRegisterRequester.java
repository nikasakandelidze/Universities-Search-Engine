package com.projectk.requester.interfaces.loggedinUserRequesters;


public interface FacultyRegisterRequester {
    Object displayFacultyRegistration(int universityId);

    Object executeFacultyRegistration(int facultyId, String  category, String name,
                                      String deanInfo, long price, String description, String webPage,int universityId);
}
