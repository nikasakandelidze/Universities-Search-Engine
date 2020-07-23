package com.projectk.entities;

public class User {
    private String username;
    private String encoded_password;
    private int enabled;

    public User() {}
    public int getEnabled(){ return enabled; }

    public void setEnabled(int enabled) { this.enabled=enabled; }

    public User(String username, String encoded_password) {
        this.username = username;
        this.encoded_password = encoded_password;
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
        private int enabled;


        public User.Builder username(String val) {
            username = val;
            return this;
        }

        public User.Builder encoded_password(String  val) {
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
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", encoded_password=" + encoded_password +
                ", enabled='" + enabled + '\'' +
                '}';
    }
}
