package com.projectk.storage.storageManager.implementations.userManager;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserManager implements StorageManager<User, SearchUser> {
    private ConnectionManager connectionManager;

    @Autowired
    public UserManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<User> filter(SearchUser searchEntity) throws StorageException {
        Connection connection = null;
        List<User> resultList = new ArrayList<>();
        try {
            connection = connectionManager.getConnection();
            SearchUserSqlQueryGenerator searchUserSqlQueryGenerator = new SearchUserSqlQueryGenerator();
            String query = searchUserSqlQueryGenerator.SearchUserSqlQueryGenerator(searchEntity);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            insertValuesToSelectStatement(preparedStatement, searchEntity);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                resultList.add(UsersUtils.getUser(set));
            }
            return resultList;
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    private void insertValuesToSelectStatement(PreparedStatement preparedStatement, SearchUser user) throws  SQLException {
        String user1 = user.getUserName();
            if (user.getUserName() != null) {
                preparedStatement.setString(1, user.getUserName());
                if (user.getPassword() != null)
                    preparedStatement.setString(2, user.getPassword());
            }
    }


    @Override
    public void add(User entity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            String query = "INSERT INTO users VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getEncoded_password());
            preparedStatement.setInt(3, entity.getEnabled());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    @Override
    public void delete(User entity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE username=? and password=?");
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getEncoded_password());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    @Override
    public void update(User entity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();

            String query = "UPDATE users SET password=? , enabled=? " + "WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            updateValues(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
    }

    private void updateValues(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getEncoded_password());
        preparedStatement.setInt(2, entity.getEnabled());
        preparedStatement.setString(3, entity.getUsername());
    }
}
