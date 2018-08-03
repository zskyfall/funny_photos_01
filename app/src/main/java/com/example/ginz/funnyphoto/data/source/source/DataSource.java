package com.example.ginz.funnyphoto.data.source.source;

public interface DataSource {

    interface OnCompleteListener <T>{

        void onRequestSuccess(T result);

        void onRequestError(Exception e);
    }

}
