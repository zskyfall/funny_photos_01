package com.example.ginz.funnyphoto.data.source.source;

public interface DataSource {

    interface OnCompleteListener {

        void onRequestSuccess(String result);

        void onRequestError(Exception e);
    }

}
