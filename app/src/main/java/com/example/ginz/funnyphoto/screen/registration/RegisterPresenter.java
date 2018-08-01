package com.example.ginz.funnyphoto.screen.registration;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.configuration.Constants;
import com.example.ginz.funnyphoto.data.source.source.UserDataSource;
import com.example.ginz.funnyphoto.data.model.User;
import com.example.ginz.funnyphoto.data.source.source.UsersRepository;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.ginz.funnyphoto.utils.Preconditions.checkNotNull;

public class RegisterPresenter implements RegisterContract.Presenter,
        UserDataSource.Callback {

    @NonNull
    private UsersRepository mUserRepository;

    @NonNull
    private final RegisterContract.View mRegisterView;

    public RegisterPresenter(@NonNull UsersRepository userDataSource,
                             @NonNull RegisterContract.View registerView) {

        mUserRepository = checkNotNull(userDataSource);
        mRegisterView = checkNotNull(registerView);
        mRegisterView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onStartLoading() {

    }

    @Override
    public void onLoaded(Object data) {

    }

    @Override
    public void onDataNotAvailable(Exception exception) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void doRegister(User user, boolean isChecked) {
        if(validateUser(user, isChecked)) {
            mUserRepository.saveUser(user);
        }
    }

    private boolean validateUser(User user, boolean isChecked) {
        if(user.getUsername().isEmpty()) {
            mRegisterView.onRegisterError(mRegisterView.getString(R.string.registration_username_required));
            return false;
        }
        if(user.getEmail().isEmpty()) {
            mRegisterView.onRegisterError(mRegisterView.getString(R.string.registration_email_required));
            return false;
        }
        if(user.getPassword().isEmpty()) {
            mRegisterView.onRegisterError(mRegisterView.getString(R.string.registration_password_required));
            return false;
        }
        if(user.getUsername().isEmpty()) {
            mRegisterView.onRegisterError(mRegisterView.getString(R.string.registration_name_required));
            return  false;
        }
        if(!isChecked) {
            mRegisterView.onRegisterError(mRegisterView.getString(R.string.registration_check_policy_required));
            return false;
        }
        return true;
    }

    private boolean isRegisterSuccessful(String data) throws JSONException {
        JSONObject jsonObject = new JSONObject(data);
        String result = jsonObject.getString(Constants.Authentication.KEY_MESSAGE);
        return result.equals(Constants.Authentication.MESSAGE_OK);
    }
}
