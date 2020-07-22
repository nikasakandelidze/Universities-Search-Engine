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
}
