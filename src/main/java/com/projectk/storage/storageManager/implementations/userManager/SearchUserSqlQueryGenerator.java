package com.projectk.storage.storageManager.implementations.userManager;

import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchUser;

public class SearchUserSqlQueryGenerator {
    public String SearchUserSqlQueryGenerator(SearchUser user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * from users u ");
        if (user.getUserName() != null) {
            stringBuilder.append("where u.username=?");
        }
        if (user.getPassword() != null) {
            stringBuilder.append(" and u.password=?");
        }
        return stringBuilder.toString();
    }
}
