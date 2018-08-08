package com.example.ginz.funnyphoto.screen.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private static final int VISIBLE_THRESHOLD = 1;
    private LinearLayoutManager mLayoutManager;

    public EndlessScrollListener(LinearLayoutManager layoutManager) {
        mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int items = mLayoutManager.getItemCount();
        int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
        if(items <= lastVisibleItemPosition + VISIBLE_THRESHOLD){
            onLoadMore();
        }
    }

    public abstract void onLoadMore();
}
