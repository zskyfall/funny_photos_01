package com.example.ginz.funnyphoto.data.source;

import android.support.annotation.NonNull;

public interface OnCompleteListener {
    void onRequestSusscee(@NonNull String response);
    void onRequestError(Exception e);
}
