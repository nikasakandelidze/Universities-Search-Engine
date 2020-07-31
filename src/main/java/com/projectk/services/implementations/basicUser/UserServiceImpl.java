package com.projectk.services.implementations.basicUser;

import com.projectk.entities.University;
import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.entities.ServiceResult;
import com.projectk.services.implementations.utils.UserServiceUtils;
import com.projectk.services.interfaces.UserService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {
    private StorageManager<User, SearchUser> userManager;
    private StorageManager<University, SearchUniversity> universityManager;

    @Autowired
    public UserServiceImpl(StorageManager<User, SearchUser> userManager,StorageManager<University, SearchUniversity> universityManager) {
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
    public ServiceResult isUserAuthenticated(User user, Object userSessionAttribute) {
        String view = "";
        Map<String, Object> modelMap = new HashMap<>();
        Map<String, Object> sessionUserAttributes = new HashMap<>();
        if (userSessionAttribute != null) {
            view = "UserPage";
        } else if (UserServiceUtils.isAuthenticated(user, userManager)) {
            sessionUserAttributes.put("user",user);
            sessionUserAttributes.put("allUniversities",tryToSearchUniversitiesOfUser(user));
            view = "UserPage";
        } else {
            modelMap.put("errorMessage", "Username or password incorrect.");
            view = "login";
        }
        return new ServiceResult(view, modelMap, sessionUserAttributes);
    }

    private List<University> tryToSearchUniversitiesOfUser(User user) {
        try {
            return universityManager.filter(SearchUniversity.universitiesOfUser(user.getUsername()));
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
