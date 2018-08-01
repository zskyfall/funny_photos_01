package com.example.ginz.funnyphoto.data.source.source;

import android.support.annotation.NonNull;
import android.telecom.Call;

import com.example.ginz.funnyphoto.data.model.User;
import com.example.ginz.funnyphoto.data.source.source.remote.UsersRemoteDataSource;

public class UsersRepository implements UserDataSource.RemoteDataSource {

    private static UsersRepository sInstance = null;

    private final UserDataSource.RemoteDataSource mRemoteDataSource;

    private UsersRepository(UsersRemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static synchronized UsersRepository getInstance(UsersRemoteDataSource remoteDataSource) {
        if(sInstance == null) {
            sInstance = new UsersRepository(remoteDataSource);
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }


    @Override
    public void getUser(@NonNull String username, @NonNull UserDataSource.Callback<User> callback) {
        mRemoteDataSource.getUser(username, callback);
    }

    @Override
    public void saveUser(@NonNull User user) {
        mRemoteDataSource.saveUser(user);
    }

    @Override
    public void updateUser(@NonNull String oldUsername, @NonNull User user) {

    }
}
