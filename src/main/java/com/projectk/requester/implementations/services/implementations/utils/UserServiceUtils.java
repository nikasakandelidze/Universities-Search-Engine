package com.projectk.requester.implementations.services.implementations.utils;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

public class UserServiceUtils {
    public static boolean isAuthenticated(User user, StorageManager<User, SearchUser> userManager) {
        try {
            return !userManager.filter(SearchUser.UserToSearchUser(user)).isEmpty();
        } catch (StorageException e) {
            return false;
        }
    }
}
