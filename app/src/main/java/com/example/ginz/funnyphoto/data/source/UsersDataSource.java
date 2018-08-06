package com.example.ginz.funnyphoto.data.source;

import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.data.model.User;

public interface UsersDataSource {

    interface OnCompleteListener {
        void onRequestSusscee(@NonNull String response);
        void onRequestError(Exception e);
    }

    interface UserRemoteDataSource {
        void getUser(@NonNull String username, @NonNull String password,
                     @NonNull OnCompleteListener callback);
        void saveUser(@NonNull User user);
        void updateUser(@NonNull String oldUsername, @NonNull User user);
    }
}
