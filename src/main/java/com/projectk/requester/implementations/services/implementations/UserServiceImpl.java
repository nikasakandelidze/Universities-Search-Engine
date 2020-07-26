package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.userManager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


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
		try {
			Optional<User> found = userManager.filter(new User.Builder().username(user.getUsername()).build())
					.stream()
					.findAny();
			if (found.isPresent()) {
				modelMap.put("errorMessage", "This username already exists!");
			} else {
				userManager.add(user);
			}
		} catch (StorageException e) {
			//todo: change this error message to user friendly
			//modelMap.put("errorMessage", e.getMessage());
		}
		return new ServiceResult(view, modelMap);
	}
}
