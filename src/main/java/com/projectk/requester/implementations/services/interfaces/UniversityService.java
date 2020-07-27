package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.University;
import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;

public interface UniversityService {
	ServiceResult addUniversity(University university);

	ServiceResult updateUniversity(University university);
}
