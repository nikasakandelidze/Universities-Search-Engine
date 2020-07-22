package com.projectk.storage.storageManager.implementations.userManager;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import java.sql.SQLException;
import java.util.List;

public class UserManager implements StorageManager<User, SearchUser> {

    @Override
    public List<User> filter(SearchUser searchEntity) throws SQLException, StorageException {
        return null;
    }

    @Override
    public void add(User entity) throws StorageException {

    }

    @Override
    public void delete(User entity) throws StorageException {

    }

    @Override
    public void update(User entity) throws StorageException {

    }
}
