package com.example.ginz.funnyphoto.screen.home;

import com.example.ginz.funnyphoto.data.model.Post;

import java.util.List;

public interface PostContact {
    interface View {
        void showNewPost(List<Post> newPosts);
        void lastPost();
        void showError();
    }

    interface Presenter {
        void loadMore(int page);
        void like(String username, String postId);
    }
}
