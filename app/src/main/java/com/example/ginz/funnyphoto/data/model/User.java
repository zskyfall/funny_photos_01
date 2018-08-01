package com.example.ginz.funnyphoto.data.model;

public class User{

    private String mUsername;
    private String mPassword;
    private String mFullName;
    private String mAvatar;
    private String mEmail;

    public User(String username, String password, String fullName, String avatar, String email) {
        mUsername = username;
        mPassword = password;
        mFullName = fullName;
        mAvatar = avatar;
        mEmail = email;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
