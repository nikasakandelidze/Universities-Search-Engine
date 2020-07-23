package com.projectk.storage.storageManager.implementations.userManager;

import com.projectk.entities.Subject;
import com.projectk.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersUtils {
    public static final String[] COLUMNS = {"username",
            "password",
            "enabled"};

    public static User getUser(ResultSet rs) throws SQLException {
        return new User.Builder()
                .username(rs.getString(COLUMNS[0]))
                .encoded_password((rs.getString(COLUMNS[1])))
                .enabled(rs.getInt(COLUMNS[2]))
                .build();
    }
}
