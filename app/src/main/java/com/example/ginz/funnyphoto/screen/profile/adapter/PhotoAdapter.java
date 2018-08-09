package com.example.ginz.funnyphoto.screen.profile.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.data.model.Photo;
import com.example.ginz.funnyphoto.data.model.Post;
import com.example.ginz.funnyphoto.screen.profile.UpdateProfileActivity;
import com.example.ginz.funnyphoto.screen.profile.ViewPostDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private static Context mContext;
    private List<Post> mPhotos;
    public static ViewPostDetail mViewPostDetail;

    public PhotoAdapter(Context context, List<Post> photos, ViewPostDetail viewPostDetail) {
        this.mContext = context;
        this.mPhotos = photos;
        mViewPostDetail = viewPostDetail;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_photo_manage, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post post = mPhotos.get(position);

        if(post.getImagePath() != null) {
            Picasso.with(mContext).load(post.getImagePath()).into(holder.mImagePost);
            holder.mImagePost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewPostDetail.viewPost(post);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mPhotos != null ? mPhotos.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImagePost;
        public ViewHolder(View itemView) {
            super(itemView);
            mImagePost = itemView.findViewById(R.id.image_profile_photo);
        }
    }
}
