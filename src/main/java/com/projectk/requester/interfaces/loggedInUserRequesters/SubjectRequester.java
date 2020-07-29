package com.projectk.requester.interfaces.loggedInUserRequesters;

public interface SubjectRequester {
    Object displaySubjectRegistration();

    Object executeSubjectRegistration(int subjectId, int  facultyId, String subjectName, int credits,
                                      String descriptions, int semester);

}
