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
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private static Context mContext;
    private List<Post> mPhotos;

    public PhotoAdapter(Context context, List<Post> photos) {
        this.mContext = context;
        this.mPhotos = photos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_photo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = mPhotos.get(position);
        holder.bindView(post);
    }

    @Override
    public int getItemCount() {
        return mPhotos != null ? mPhotos.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImagePost;
        public ViewHolder(View itemView) {
            super(itemView);
            mImagePost = itemView.findViewById(R.id.image_profile_photo);
            mImagePost.setOnClickListener(this);
        }

        public void bindView(Post post) {
            Picasso.with(mContext).load(post.getImagePath()).into(mImagePost);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_profile_photo:

                    break;
            }
        }
    }
}
