package com.example.ginz.funnyphoto.data.source;

import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.data.model.User;

public interface UsersDataSource {

    interface OnUserCompleteListener {
        void onRequestSusscee(@NonNull User user);
        void onRequestError(Exception e);
    }

    interface UserRemoteDataSource {
        void getUser(@NonNull String username, @NonNull String password,
                     @NonNull OnUserCompleteListener callback);
        void saveUser(@NonNull User user);
        void updateUser(@NonNull String oldUsername, @NonNull User user);
    }
}
