package com.example.ginz.funnyphoto.screen.post;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.data.model.Post;
import com.example.ginz.funnyphoto.data.model.User;
import com.facebook.CallbackManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostDetailActivity extends AppCompatActivity implements PostDetailContract.View {

    private static final String mUrlShare = "http://haivn.com";
    private ImageView mImageAvatar;
    private ImageView mImagePost;
    private TextView mTextFullName;
    private TextView mTextPostTime;
    private TextView mTexTitle;
    private TextView mTextLikeCount;
    private PostDetailContract.Presenter mPresenter;
    private CallbackManager callbackManager;
    private ShareDialog shareDialog;
    public Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        setContentView(R.layout.activity_post_detail);
        initView();

        mPresenter = new PostDetailPresenter(this);
        mPresenter.start();

        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(mBitmap)
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();

        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse(mUrlShare))
                    .build();
        ShareButton shareButton = (ShareButton)findViewById(R.id.image_share_post_detail);
        shareButton.setShareContent(linkContent);

    }

    private void initView() {
        mImageAvatar = findViewById(R.id.image_avatar_post_detail);
        mImagePost = findViewById(R.id.image_post_detail);
        mTextFullName = findViewById(R.id.text_fullname_post_detail);
        mTexTitle = findViewById(R.id.text_content_post);
        mTextPostTime = findViewById(R.id.text_time_post_detail);
        mTextLikeCount = findViewById(R.id.text_likes_post_detail);
    }

    @Override
    public void onLoadPostSuccess() {
        updateBundleContent();
    }

    @Override
    public void onLoadPosterror(Exception exception) {

    }

    @Override
    public void onClickOption() {

    }

    @Override
    public void onClickShare() {

    }

    @Override
    public void onClickLike() {

    }

    @Override
    public void setPresenter(PostDetailContract.Presenter presenter) {

    }

    private void updateBundleContent() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String username = bundle.getString(User.Key.USERNAME);
            String fullName = bundle.getString(User.Key.FULL_NAME);
            String avatar = bundle.getString(User.Key.AVATAR);

            String title = bundle.getString(Post.Key.TITLE);
            String postTime = bundle.getString(Post.Key.POST_TIME);
            String imageUrl = bundle.getString(Post.Key.IMAGE_URL);
            int likeCount = bundle.getInt(Post.Key.LOVE);

            mTextFullName.setText(fullName);
            mTexTitle.setText(title);
            mTextLikeCount.setText(likeCount + "");
            mTextPostTime.setText(postTime);
            Picasso.with(this).load(avatar).into(mImageAvatar);
            Picasso.with(this).load(imageUrl).into(mImagePost);

        }
        else {
            Toast.makeText(this, getString(R.string.load_data_error), Toast.LENGTH_SHORT).show();
        }
    }

}
