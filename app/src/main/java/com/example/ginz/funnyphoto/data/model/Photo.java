package com.example.ginz.funnyphoto.data.model;

public class Photo {
    private String mPath;
    private boolean mIsChecked;

    public Photo(String path, boolean checked) {
        mPath = path;
        mIsChecked = checked;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public boolean isChecked() {
        return mIsChecked;
    }

    public void setChecked(boolean checked) {
        mIsChecked = checked;
    }
}
