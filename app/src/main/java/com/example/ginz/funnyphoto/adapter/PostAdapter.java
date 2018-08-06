package com.example.ginz.funnyphoto.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.data.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context mContext;
    private List<Post> mPosts;

    public PostAdapter(Context context, List<Post> mosts) {
        this.mContext = context;
        this.mPosts = mosts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Post post = mPosts.get(position);


        holder.mImageLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mImageLike.setImageResource(R.drawable.favorite_fill_pink);
                Animation zoomIn = AnimationUtils.loadAnimation(mContext, R.anim.zoom_in_button_like);
                holder.mImageLike.startAnimation(zoomIn);
                zoomIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Animation zoomOut = AnimationUtils.loadAnimation(mContext, R.anim.zoom_out_button_like);
                        holder.mImageLike.startAnimation(zoomOut);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mPosts != null){
            return mPosts.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageAvatar;
        private ImageView mImagePost;
        private ImageView mImageLike;
        private ImageView mImageComment;
        private ImageView mImageShare;
        private TextView mTextUserName;
        private TextView mTextPostTime;
        private TextView mTextContent;
        private TextView mTextLikes;
        private TextView mTextComments;
        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);

            mImageComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(mContext, PostDetailAcitivy.class);
                    //mContext.startActivity(intent);
                }
            });
        }

        private void initView(View itemView){
            mImageAvatar = itemView.findViewById(R.id.image_avatar_post);
            mImagePost = itemView.findViewById(R.id.image_post);
            mImageLike = itemView.findViewById(R.id.image_like_post);
            mImageComment = itemView.findViewById(R.id.image_comment_post);
            mImageShare = itemView.findViewById(R.id.image_share_post);
            mTextUserName = itemView.findViewById(R.id.text_username_post);
            mTextPostTime = itemView.findViewById(R.id.text_time_post);
            mTextContent = itemView.findViewById(R.id.text_content_post);
//            mTextLikes = itemView.findViewById(R.id.text_likes_post);
//            mTextComments = itemView.findViewById(R.id.text_comments_post);
        }
    }
}
