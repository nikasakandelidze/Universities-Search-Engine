package com.projectk.requester.implementations.services.implementations.utils;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.userManager.UserManager;

public class UserServiceUtils {
    public static boolean isAuthenticated(User user, UserManager userManager) {
        try {
            return !userManager.filter(new SearchUser(user)).isEmpty();
        } catch (StorageException e) {
            return false;
        }
    }
}
