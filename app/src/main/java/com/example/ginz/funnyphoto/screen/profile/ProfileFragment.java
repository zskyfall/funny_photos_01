package com.example.ginz.funnyphoto.screen.profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.adapter.PostAdapter;
import com.example.ginz.funnyphoto.data.model.Post;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private FragmentActivity mActivity;
    private RecyclerView mRecyclerPost;
    private List<Post> mPosts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        initView();
        setupRecycler();
    }

    private void initView(){
        mRecyclerPost = mActivity.findViewById(R.id.recycler_post_profile);
    }

    private void setupRecycler(){
        mPosts = new ArrayList<>();
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());
        mPosts.add(new Post());

        PostAdapter mPostAdapter = new PostAdapter(mActivity, mPosts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mActivity);
        mRecyclerPost.setLayoutManager(mLayoutManager);
        mRecyclerPost.setAdapter(mPostAdapter);
        mRecyclerPost.setNestedScrollingEnabled(false);
    }
}