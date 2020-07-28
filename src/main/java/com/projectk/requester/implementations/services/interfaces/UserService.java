package com.projectk.requester.implementations.services.interfaces;

import com.projectk.entities.User;
import com.projectk.entities.ServiceResult;

import javax.servlet.http.HttpSession;

public interface UserService {
    ServiceResult isUserAuthenticated(User user, HttpSession session);

    ServiceResult updateUser(User user);

    ServiceResult deleteUser(User user);

    ServiceResult addUser(User user);

}
