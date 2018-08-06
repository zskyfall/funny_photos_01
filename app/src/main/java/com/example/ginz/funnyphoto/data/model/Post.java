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
        mId = id;
        mUserPosted = userPosted;
        mTitle = title;
        mPostTime = postTime;
        mImagePath = imagePath;
        mLikes = likes;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public User getUserPosted() {
        return mUserPosted;
    }

    public void setUserPosted(User userPosted) {
        mUserPosted = userPosted;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getPostTime() {
        return mPostTime;
    }

    public void setPostTime(Long postTime) {
        mPostTime = postTime;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public void setImagePath(String imagePath) {
        mImagePath = imagePath;
    }

    public int getLikes() {
        return mLikes;
    }

    public void setLikes(int likes) {
        mLikes = likes;
    }
}
