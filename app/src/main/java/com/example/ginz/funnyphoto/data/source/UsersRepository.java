package com.example.ginz.funnyphoto.data.source;


import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.data.model.User;
import com.example.ginz.funnyphoto.data.source.remote.UsersRemoteDataSource;

public class UsersRepository implements UsersDataSource.UserRemoteDataSource {

    private static UsersRepository sInstance = null;
    private UsersDataSource.UserRemoteDataSource mUserRemoteDataSource;

    private UsersRepository(UsersRemoteDataSource usersRemoteDataSource){
        mUserRemoteDataSource = usersRemoteDataSource;
    }

    public static UsersRepository getInstance(UsersRemoteDataSource usersRemoteDataSource){
        if(sInstance == null){
            sInstance = new UsersRepository(usersRemoteDataSource);
        }
        return sInstance;
    }

    @Override
    public void getUser(@NonNull String username, @NonNull String password,
                        @NonNull UsersDataSource.OnCompleteListener callback) {
        mUserRemoteDataSource.getUser(username, password, callback);

    }

    @Override
    public void saveUser(@NonNull User user) {
        mUserRemoteDataSource.saveUser(user);
    }

    @Override
    public void updateUser(@NonNull String oldUsername, @NonNull User user) {
        mUserRemoteDataSource.updateUser(oldUsername, user);
    }
}
