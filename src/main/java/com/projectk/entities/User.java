package com.projectk.entities;

import com.projectk.services.implementations.utils.EncryptionUtils;

public class User {
    private String username;
    private String encoded_password;
    private int enabled;
    private int university_id;

    public User(int university_id, String username, String encoded_password) {
        this.university_id = university_id;
        this.encoded_password = encoded_password;
        this.username = username;
        this.enabled = 1;
    }


    public User(String username, String password) {
        this.username = username;
        this.encoded_password = password;
    }

    public static User newUserWithEncryptedPass(String username, String encoded_password){
        return new User(username, EncryptionUtils.encodeSHA1(encoded_password));
    }

    public int getUniversity_id() {
        return university_id;
    }

    private void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncoded_password() {
        return encoded_password;
    }

    public void setEncoded_password(String encoded_password) {
        this.encoded_password = encoded_password;
    }

    public static class Builder {
        private String username;
        private String encoded_password;
        private int university_id;
        private int enabled;

        public User.Builder university_id(int val) {
            university_id = val;
            return this;
        }

        public User.Builder username(String val) {
            username = val;
            return this;
        }

        public User.Builder encoded_password(String val) {
            encoded_password = val;
            return this;
        }

        public User.Builder enabled(int val) {
            enabled = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(User.Builder builder) {
        this.username = builder.username;
        this.encoded_password = builder.encoded_password;
        this.enabled = builder.enabled;
        this.university_id = builder.university_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "university_id=" + university_id +
                "username=" + username +
                ", encoded_password=" + encoded_password +
                ", enabled='" + enabled + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User element = (User) obj;
            if (element != null && this.username.equals(element.getUsername()) &&
                    this.encoded_password.equals(element.getEncoded_password())) {
                return true;
            }
        }
        return false;
    }
}
