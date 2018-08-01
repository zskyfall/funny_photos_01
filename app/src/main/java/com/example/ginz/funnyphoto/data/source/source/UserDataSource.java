package com.example.ginz.funnyphoto.data.source.source;

import android.support.annotation.NonNull;
import android.telecom.Call;

import com.example.ginz.funnyphoto.data.model.User;

public interface UserDataSource {

    interface Callback<T> {

        void onStartLoading();

        void onLoaded(T data);

        void onDataNotAvailable(Exception exception);

        void onComplete();
    }

    interface RemoteDataSource {

        void getUser(@NonNull String username, @NonNull Callback<User> callback);

        void saveUser(@NonNull User user);

        void updateUser(@NonNull String oldUsername, @NonNull User user);
    }
}
