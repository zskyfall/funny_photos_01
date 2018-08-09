package com.example.ginz.funnyphoto.data.source.source;

import android.support.annotation.NonNull;

import com.example.ginz.funnyphoto.data.model.Post;

import java.util.ArrayList;

public interface PostDataSource {

    interface GetPostsCallback {
        void onPostLoaded(ArrayList<Post> list);
        void onDataNotAvailable(Exception exception);
    }

    interface GetPostCallback {
        void onPostLoaded();
        void onDataNotAvailable(Exception exception);
    }

    interface AddPostCallback {
        void onAddPostSuccess(Post post);
        void onAddPostError(Exception exception);
    }

    interface UpdatePostCallback {
        void onUpdatePostSuccess(Post post);
        void onUpdatePostError(Exception exception);
    }

    interface RemoteDataSource {
        void getPostsByUsername(String username, GetPostsCallback callback);
        void addPost(@NonNull Post post, AddPostCallback callback);
    }

}
