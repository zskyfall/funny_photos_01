package com.example.ginz.funnyphoto.data.source.source.remote;

import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.configuration.Constants;
import com.example.ginz.funnyphoto.data.model.User;
import com.example.ginz.funnyphoto.data.source.source.UserDataSource;

public class UsersRemoteDataSource implements UserDataSource.RemoteDataSource{

    private static UsersRemoteDataSource sInstance;

    public static UsersRemoteDataSource getInstance() {
        if(sInstance == null) {
            sInstance = new UsersRemoteDataSource();
        }
        return sInstance;
    }

    private UsersRemoteDataSource() {}

    @Override
    public void getUser(@NonNull String username, @NonNull UserDataSource.Callback<User> callback) {
    }

    @Override
    public void saveUser(@NonNull User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String fullName = user.getFullName();

        RegistrationAsyncTask asyncTask = new RegistrationAsyncTask.Builder()
                .setApiUrl(Constants.Server.ACTION_REGISTER)
                .addParameter(Constants.Key.USERNAME, username)
                .addParameter(Constants.Key.PASSWORD, password)
                .addParameter(Constants.Key.EMAIL, email)
                .addParameter(Constants.Key.FULL_NAME, fullName)
                .build();
        asyncTask.execute();
    }

    @Override
    public void updateUser(@NonNull String oldUsername, @NonNull User user) {

    }

}
