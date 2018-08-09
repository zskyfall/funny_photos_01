package com.example.ginz.funnyphoto.screen.post;

import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.data.model.Post;
import com.example.ginz.funnyphoto.data.source.source.PostDataSource;
import com.example.ginz.funnyphoto.screen.home.PostContact;

public class PostDetailPresenter implements PostDetailContract.Presenter {

    @NonNull
    private PostDetailContract.View mPostDetailView;

    public PostDetailPresenter(PostDetailContract.View postDetailView) {
        mPostDetailView = postDetailView;
    }

    @Override
    public void clickOption() {

    }

    @Override
    public void clickEditPost() {

    }

    @Override
    public void clickDeletePost() {

    }

    @Override
    public void clickShare() {
        mPostDetailView.onClickShare();
    }

    @Override
    public void clickLike() {
        mPostDetailView.onClickLike();
    }

    @Override
    public void start() {
        mPostDetailView.onLoadPostSuccess();
    }

}
