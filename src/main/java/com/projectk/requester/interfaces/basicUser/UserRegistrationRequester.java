package com.projectk.requester.interfaces.basicUser;

import com.projectk.entities.User;

public interface UserRegistrationRequester {
    Object displayRegistration();

    Object executeRegistration(String username, String password);
}
