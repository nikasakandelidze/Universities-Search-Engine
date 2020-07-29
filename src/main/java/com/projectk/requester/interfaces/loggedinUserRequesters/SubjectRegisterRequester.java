package com.projectk.requester.interfaces.loggedinUserRequesters;

public interface SubjectRegisterRequester {
    Object displaySubjectRegistration();

    Object executeSubjectRegistration(int subjectId, int  facultyId, String subjectName, int credits,
                                      String descriptions, int semester);

}
