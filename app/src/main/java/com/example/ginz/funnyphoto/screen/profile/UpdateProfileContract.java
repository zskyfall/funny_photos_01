package com.example.ginz.funnyphoto.screen.profile;

import android.graphics.Bitmap;

import com.example.ginz.funnyphoto.BasePresenter;
import com.example.ginz.funnyphoto.BaseView;
import com.example.ginz.funnyphoto.data.model.User;

public interface UpdateProfileContract {
    interface View extends BaseView<UpdateProfileContract.Presenter> {

        void onUpdateProfileStart();

        void onUpdateProfileSuccess(User user);

        void onUpdateProfileError(String message);

        String getString(int resourceID);

    }

    interface Presenter extends BasePresenter {
        void updateProfile(User user, String  stringBitmap);
    }
}
