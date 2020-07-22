package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;

public interface UserService {
    ServiceResult isUserAuthenticated(User user);

    ServiceResult updateUser(User user);

    ServiceResult deleteUser(User user);

    ServiceResult addUser(User user);

}
