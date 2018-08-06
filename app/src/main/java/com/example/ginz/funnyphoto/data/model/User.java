package com.example.ginz.funnyphoto.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.ginz.funnyphoto.configuration.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class User implements Parcelable{
    private String mUsername;
    private String mPassword;
    private String mFullName;
    private String mAvatar;
    private String mEmail;

    protected User(Parcel in) {
        mUsername = in.readString();
        mPassword = in.readString();
        mFullName = in.readString();
        mAvatar = in.readString();
        mEmail = in.readString();
    }

    public User(String username, String password, String fullName, String avatar, String email) {
        mUsername = username;
        mPassword = password;
        mFullName = fullName;
        mAvatar = avatar;
        mEmail = email;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return mUsername;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUsername);
        parcel.writeString(mPassword);
        parcel.writeString(mFullName);
        parcel.writeString(mAvatar);
        parcel.writeString(mEmail);
    }

    public static User parseUser(String data) throws JSONException {
        JSONObject jsonObject = new JSONObject(data);
        String message = jsonObject.getString(Constants.Authentication.KEY_MESSAGE);
        if(message.equals(Constants.Authentication.MESSAGE_OK)){
            JSONObject jsonUser = jsonObject.getJSONObject(Constants.Key.USER);
            String username = jsonUser.optString(Constants.Key.USERNAME, null);
            String password = jsonUser.optString(Constants.Key.PASSWORD, null);
            String email = jsonUser.optString(Constants.Key.EMAIL, null);
            String fullName = jsonUser.optString(Constants.Key.FULL_NAME, null);
            String avatar = jsonUser.optString(Constants.Key.AVATAR, null);
            User user = new User(username, password, fullName, email, avatar);
            return user;
        } else {
            return null;
        }
    }
}
