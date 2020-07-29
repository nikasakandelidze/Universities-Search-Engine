package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.University;
import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.implementations.utils.UserServiceUtils;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.universityManager.UniversityManager;
import com.projectk.storage.storageManager.implementations.userManager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    private UserManager userManager;
    private UniversityManager universityManager;

    @Autowired
    public UserServiceImpl(UserManager userManager,UniversityManager universityManager) {
        this.userManager = userManager;
        this.universityManager = universityManager;
    }

    @Override
    public ServiceResult displayLogin(Object userAttribute) {
        String view = "";
        Map<String, Object> modelMap = new HashMap<>();
        if (userAttribute != null) {
            view = "UserPage";
            modelMap.put("warningMessage", "You are already logged in");
        } else {
            view = "/login";
        }
        return new ServiceResult(view, modelMap);
    }

    @Override
    public ServiceResult isUserAuthenticated(User user, Object userAttribute) {
        String view = "";
        Map<String, Object> modelMap = new HashMap<>();
        List<Object> listOfAttributes = new ArrayList<>();
        if (userAttribute != null) {
            view = "UserPage";
        } else if (UserServiceUtils.isAuthenticated(user, userManager)) {
            listOfAttributes.add(user);
            listOfAttributes.add(tryToSearchUniversitiesOfUser(user));
            view = "UserPage";
        } else {
            modelMap.put("errorMessage", "Username or password incorrect.");
            view = "login";
        }
        return new ServiceResult(view, modelMap, listOfAttributes);
    }

    private List<University> tryToSearchUniversitiesOfUser(User user) {
        try {
            return universityManager.filter(SearchUniversity.universitiedOfUser(user.getUsername()));
        } catch (StorageException e) {
            return new ArrayList<>();
        }
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
        String view = "";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            userManager.add(user);
            view = "login";
        } catch (StorageException e) {
            modelMap.put("errorMessage", "Ups something went wrong...");
            view = "register";
        }
        return new ServiceResult(view, modelMap);
    }
}
