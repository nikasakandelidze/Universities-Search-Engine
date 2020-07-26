package com.projectk.storage.storageManager.implementations.userManager;

import com.projectk.entities.User;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserManager implements StorageManager<User, User> {
    private ConnectionManager connectionManager;

    public UserManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<User> filter(User searchEntity) throws StorageException {
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
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return resultList;
    }

    private void insertValuesToSelectStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        if (user.getUsername() != null) preparedStatement.setString(1, user.getUsername());
        if (user.getEncoded_password() != null) preparedStatement.setString(2, user.getEncoded_password());
    }

    @Override
    public void add(User entity) throws StorageException {
        Connection connection=null;
        try {
            connection=connectionManager.getConnection();
            String query="INSERT INTO users VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,entity.getUsername());
            preparedStatement.setString(2,entity.getEncoded_password());
            preparedStatement.setInt(3,entity.getEnabled());
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
            preparedStatement.setString(2,entity.getEncoded_password());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User entity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();

            String query = "UPDATE users SET password=? , enabled=? " +
                    "WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            updateValues(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateValues(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,entity.getEncoded_password());
        preparedStatement.setInt(2,entity.getEnabled());
        preparedStatement.setString(3,entity.getUsername());
    }
}
