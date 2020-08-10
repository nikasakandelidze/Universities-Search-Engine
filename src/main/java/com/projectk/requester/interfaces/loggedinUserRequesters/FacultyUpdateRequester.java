package com.projectk.requester.interfaces.loggedinUserRequesters;

import com.projectk.entities.Faculty;
import com.projectk.entities.University;

import javax.servlet.http.HttpSession;

public interface FacultyUpdateRequester {
	Object displayFacultyUpdate(String facultyId, HttpSession session);

	Object executeFacultyUpdate(Faculty faculty);
}
