package com.projectk.entities.searchEntities;

import com.projectk.entities.User;

public class SearchUser {

    private String username;

    private String password;

    public static SearchUser UserToSearchUser(User user) {
        return new SearchUser.Builder().userName(user.getUsername())
                .password(user.getEncoded_password())
                .build();
    }

    public static SearchUser selectAll(){
        return new SearchUser.Builder().build();
    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.username = password;
    }


    public static class Builder {

        private String userName;

        private String password;

        public SearchUser.Builder userName(String val) {
            userName = val;
            return this;
        }

        public SearchUser.Builder password(String val) {
            password = val;
            return this;
        }

        public SearchUser build() {
            return new SearchUser(this);
        }

    }

    public SearchUser(SearchUser.Builder builder) {
        this.username = builder.userName;
        this.password = builder.password;
    }
}
