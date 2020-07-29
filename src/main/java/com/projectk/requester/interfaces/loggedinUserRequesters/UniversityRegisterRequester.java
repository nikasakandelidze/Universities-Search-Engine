package com.projectk.requester.interfaces.loggedinUserRequesters;

import org.springframework.web.bind.annotation.RequestParam;

public interface UniversityRegisterRequester {
	Object displayUniversityRegistration();

	Object executeUniversityRegistration(int code, String name, String city, String address,
										 String web, String description, String username);
}
