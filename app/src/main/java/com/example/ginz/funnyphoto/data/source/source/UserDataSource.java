package com.example.ginz.funnyphoto.data.source.source;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.telecom.Call;

import com.example.ginz.funnyphoto.data.model.User;

public interface UserDataSource {

    interface GetUserCallback {

        void onUserLoaded(User user);

        void onDataNotAvailable();
    }

    interface UpdateUserCallback {

        void onUpdateUserStart();

        void onUpdateUserSuccess(User user);

        void onUpdateUserError(Exception message);
    }

    interface RegisterUserCallback {

        void onRegisterUserStart();

        void onRegisterUserSuccess(User user);

        void onRegisterUserError(Exception message);
    }

    interface RemoteDataSource {

        void getUser(@NonNull String username, @NonNull GetUserCallback callback);

        void saveUser(@NonNull User user, @NonNull RegisterUserCallback callback);

        void updateUser(@NonNull User user, @NonNull String bitmapAvatar,
                        @NonNull UpdateUserCallback callback);
    }
}
