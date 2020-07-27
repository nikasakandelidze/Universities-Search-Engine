package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.implementations.utils.UserServiceUtils;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.userManager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    private UserManager userManager;

    @Autowired
    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public ServiceResult isUserAuthenticated(User user) {
        String view = "login";
        Map<String, Object> modelMap = new HashMap<>();
        if (UserServiceUtils.isAuthenticated(user,userManager)) {
            view = "UserLoginPage";
        } else {
            modelMap.put("errorMessage", "Username or password incorrect.");
        }
        return new ServiceResult(view, modelMap);
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
