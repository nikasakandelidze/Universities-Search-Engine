package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
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
        //todo: checking is now hard coded change it so that database is checked for user
        if (user.getUsername().equals("nika") && user.getEncoded_password().equals("123")) {
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
		String view = "register";
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("errorMessage", "Username or password incorrect.");
		return new ServiceResult(view, modelMap);
	}
}
