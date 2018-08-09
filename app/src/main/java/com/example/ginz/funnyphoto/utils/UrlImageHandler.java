package com.example.ginz.funnyphoto.utils;

import com.example.ginz.funnyphoto.configuration.Constants;

public final class UrlImageHandler {

    public static String getAbsoluteImageUrl(String url) {
        if(!url.equals("")) {
            url = url.replace("public", "");
            url = url.replaceAll("\\\\","\\/" );
            url = Constants.Server.BASE_URL_API + url;
            return url;
        }
        return "";
    }
}
