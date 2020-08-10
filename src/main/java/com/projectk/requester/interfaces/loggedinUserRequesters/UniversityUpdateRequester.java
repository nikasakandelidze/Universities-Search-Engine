package com.projectk.requester.interfaces.loggedinUserRequesters;

import com.projectk.entities.University;

public interface UniversityUpdateRequester {
	Object displayUniversityUpdate(String universityId);

	Object executeUniversityUpdate(University university);
}
