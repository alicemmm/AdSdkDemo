package com.perasia.mylibrary.netWork;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LihttpUrlUtil {
    private static final String TAG = LihttpUrlUtil.class.getSimpleName();

    URL url;

    HttpURLConnection connection=new HttpURLConnection(url) {
        @Override
        public void disconnect() {

        }

        @Override
        public boolean usingProxy() {
            return false;
        }

        @Override
        public void connect() throws IOException {

        }
    };


}
