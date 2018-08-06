package com.example.ginz.funnyphoto.screen.profile;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.data.model.User;
import com.example.ginz.funnyphoto.data.source.source.UserDataSource;
import com.example.ginz.funnyphoto.data.source.source.UsersRepository;

public class UpdateProfilePresenter implements UpdateProfileContract.Presenter,
        UserDataSource.UpdateUserCallback {

    @NonNull
    private UsersRepository mUserRepository;

    @NonNull
    private final UpdateProfileContract.View mUpdateProfileView;

    public UpdateProfilePresenter(@NonNull UsersRepository userRepository,
                                  @NonNull UpdateProfileContract.View updateProfileView) {
        this.mUserRepository = userRepository;
        this.mUpdateProfileView = updateProfileView;
        mUpdateProfileView.setPresenter(this);
    }

    @Override
    public void updateProfile(User user, String stringBitmap) {
        if(validateUser(user)) {
            mUserRepository.updateUser(user, stringBitmap, this);
        }
    }

    @Override
    public void start() {

    }

    private boolean validateUser(User user) {

        if(user.getEmail().isEmpty()) {
            mUpdateProfileView.onUpdateProfileError(mUpdateProfileView.getString(R.string.registration_email_required));
            return false;
        }
        if(user.getPassword().isEmpty()) {
            mUpdateProfileView.onUpdateProfileError(mUpdateProfileView.getString(R.string.registration_password_required));
            return false;
        }
        if(user.getFullName().isEmpty()) {
            mUpdateProfileView.onUpdateProfileError(mUpdateProfileView.getString(R.string.registration_name_required));
            return  false;
        }
        return true;
    }

    @Override
    public void onUpdateUserStart() {
        mUpdateProfileView.onUpdateProfileStart();
    }

    @Override
    public void onUpdateUserSuccess(User user) {
        mUpdateProfileView.onUpdateProfileSuccess(user);
    }

    @Override
    public void onUpdateUserError(String messsage) {
        mUpdateProfileView.onUpdateProfileError(messsage);
    }
}
