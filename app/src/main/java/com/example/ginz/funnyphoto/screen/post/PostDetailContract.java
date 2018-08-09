package com.example.ginz.funnyphoto.screen.post;

import com.example.ginz.funnyphoto.BasePresenter;
import com.example.ginz.funnyphoto.BaseView;

public interface PostDetailContract {

    interface View extends BaseView<Presenter> {
        void onLoadPostSuccess();
        void onLoadPosterror(Exception exception);
        void onClickOption();
        void onClickShare();
        void onClickLike();
    }

    interface Presenter extends BasePresenter {
        void clickOption();
        void clickEditPost();
        void clickDeletePost();
        void clickShare();
        void clickLike();
    }
}

