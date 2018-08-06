package com.example.ginz.funnyphoto.data.model;

public class Photo {
    private String mPath;
    private boolean mChecked;

    public Photo(String mPath) {
        this.mPath = mPath;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public boolean ismChecked() {
        return mChecked;
    }

    public void setmChecked(boolean mChecked) {
        this.mChecked = mChecked;
    }
}
