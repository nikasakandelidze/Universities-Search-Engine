package com.projectk.requester.interfaces;

import com.projectk.entities.User;

public interface UserRegistrationRequester {
	Object displayRegistration();
	Object executeRegistration(User user);
}
