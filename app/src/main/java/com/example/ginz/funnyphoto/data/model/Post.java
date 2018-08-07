package com.example.ginz.funnyphoto.data.model;

public class Post {
    private long mId;
    private User mUserPosted;
    private String mTitle;
    private Long mPostTime;
    private String mImagePath;
    private int mLikes;

    public Post(){}



    public Post(long id, User userPosted, String title, Long postTime, String imagePath, int likes) {
        this.mId = id;
        this.mUserPosted = userPosted;
        this.mTitle = title;
        this.mPostTime = postTime;
        this.mImagePath = imagePath;
        this.mLikes = likes;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = mId;
    }

    public User getUserPosted() {
        return mUserPosted;
    }

    public void setUserPosted(User userPosted) {
        this.mUserPosted = mUserPosted;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = mTitle;
    }

    public Long getPostTime() {
        return mPostTime;
    }

    public void setPostTime(Long postTime) {
        this.mPostTime = mPostTime;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public void setImagePath(String imagePath) {
        this.mImagePath = mImagePath;
    }

    public int getLikes() {
        return mLikes;
    }

    public void setLikes(int likes) {
        this.mLikes = mLikes;
    }
}
