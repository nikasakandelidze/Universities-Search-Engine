package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.implementations.utils.UserServiceUtils;
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
		if (UserServiceUtils.isAuthenticated(user,userManager)) {
			modelMap.put("user",user);
			view = "UserPage";
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
			Optional<User> found = userManager.filter(new SearchUser.Builder().userName(user.getUsername()).build())
					.stream()
					.findAny();
			if (found.isPresent()) {
				modelMap.put("errorMessage", "This username already exists!");
			} else {
				userManager.add(user);
				view = "login";
			}
		} catch (StorageException e) {
			//todo: change this error message to user friendly
			modelMap.put("errorMessage", "Ups something went wrong...");
		}
		return new ServiceResult(view, modelMap);
	}
}
