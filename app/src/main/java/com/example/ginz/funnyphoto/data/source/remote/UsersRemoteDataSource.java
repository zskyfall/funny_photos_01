package com.example.ginz.funnyphoto.data.source.remote;

import android.support.annotation.NonNull;
import com.example.ginz.funnyphoto.configuration.Constants;
import com.example.ginz.funnyphoto.data.model.User;
import com.example.ginz.funnyphoto.data.source.GetDataAsyncTask;
import com.example.ginz.funnyphoto.data.source.UsersDataSource;

public class UsersRemoteDataSource implements UsersDataSource.UserRemoteDataSource {

    private static UsersRemoteDataSource sInstance;

    private UsersRemoteDataSource(){}

    public static UsersRemoteDataSource getInstance(){
        if(sInstance == null){
            sInstance = new UsersRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getUser(@NonNull String username, @NonNull String password,
                        @NonNull final UsersDataSource.OnCompleteListener callback) {
        new GetDataAsyncTask.Builder()
                .setApiUrl(Constants.Server.ACTION_LOGIN)
                .addParameter(Constants.Key.USERNAME, username)
                .addParameter(Constants.Key.PASSWORD, password)
                .addOnCompleteListener(new UsersDataSource.OnCompleteListener() {
                    @Override
                    public void onRequestSusscee(@NonNull String response) {
                        callback.onRequestSusscee(response);
                    }

                    @Override
                    public void onRequestError(Exception e) {
                        callback.onRequestError(e);
                    }
                })
                .build()
                .execute();
    }

    @Override
    public void saveUser(@NonNull User user) {

    }

    @Override
    public void updateUser(@NonNull String oldUsername, @NonNull User user) {

    }
}
