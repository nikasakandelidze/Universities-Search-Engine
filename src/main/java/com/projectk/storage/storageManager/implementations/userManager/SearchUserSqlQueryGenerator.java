package com.projectk.storage.storageManager.implementations.userManager;

import com.projectk.entities.User;

public class SearchUserSqlQueryGenerator {
    public String SearchUserSqlQueryGenerator(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * from users u ");
        if (user.getUsername() != null) {
            stringBuilder.append("where u.username=?");
        }
        if (user.getUsername() != null) {
            stringBuilder.append(" and u.password=?");
        }
        return stringBuilder.toString();
    }
}
