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

    public long getmId() {
        return mId;
    }

    public void setmId(long id) {
        this.mId = mId;
    }

    public User getmUserPosted() {
        return mUserPosted;
    }

    public void setmUserPosted(User userPosted) {
        this.mUserPosted = mUserPosted;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String title) {
        this.mTitle = mTitle;
    }

    public Long getmPostTime() {
        return mPostTime;
    }

    public void setmPostTime(Long postTime) {
        this.mPostTime = mPostTime;
    }

    public String getmImagePath() {
        return mImagePath;
    }

    public void setmImagePath(String imagePath) {
        this.mImagePath = mImagePath;
    }

    public int getmLikes() {
        return mLikes;
    }

    public void setmLikes(int likes) {
        this.mLikes = mLikes;
    }
}
