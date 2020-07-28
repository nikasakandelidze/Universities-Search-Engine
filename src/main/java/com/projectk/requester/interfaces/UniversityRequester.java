package com.projectk.requester.interfaces;

import org.springframework.web.bind.annotation.RequestParam;

public interface UniversityRequester {
	Object displayUniversityRegistration();

	Object executeUniversityRegistration(int code, String name, String city, String address,
										 String web, String description, String username);
}
