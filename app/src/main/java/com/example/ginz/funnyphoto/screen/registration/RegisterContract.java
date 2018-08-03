package com.example.ginz.funnyphoto.screen.registration;

import com.example.ginz.funnyphoto.BasePresenter;
import com.example.ginz.funnyphoto.BaseView;
import com.example.ginz.funnyphoto.data.model.User;

public interface RegisterContract {

    interface View extends BaseView<Presenter> {

        void onRegisterSuccess();

        void onRegisterError(String message);

        String getString(int resourceID);

    }

    interface Presenter extends BasePresenter {
        void doRegister(User user, boolean register);
    }
}
