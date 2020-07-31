package com.projectk.services.interfaces;

import com.projectk.entities.User;
import com.projectk.entities.ServiceResult;

public interface UserService {
    ServiceResult displayLogin(Object userAttribute);

    ServiceResult isUserAuthenticated(User user, Object userAttribute);

    ServiceResult updateUser(User user);

    ServiceResult deleteUser(User user);

    ServiceResult addUser(User user);

}
