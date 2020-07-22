package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UserLoginService implements UserService {
    @Override
    public ServiceResult isUserAuthenticated(User user) {
        return new ServiceResult("UserHomePage", new HashMap<>());
    }

    @Override
    public ServiceResult updateUser(User user) {
        return null;
    }

    @Override
    public ServiceResult deleteUser(User user) {
        return null;
    }

    @Override
    public ServiceResult addUser(User user) {
        return null;
    }
}
