package com.example.ginz.funnyphoto.data.model;

public class Photo {
    private String mPath;
    private boolean mChecked;

    public Photo(String mPath) {
        this.mPath = mPath;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String mPath) {
        this.mPath = mPath;
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void setChecked(boolean mChecked) {
        this.mChecked = mChecked;
    }
}
