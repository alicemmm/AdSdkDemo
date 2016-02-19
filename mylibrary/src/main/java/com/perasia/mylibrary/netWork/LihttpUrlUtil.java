package com.perasia.mylibrary.netWork;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LihttpUrlUtil {
    private static final String TAG = LihttpUrlUtil.class.getSimpleName();

    public static String getUrlResponse(String urlString) {
        HttpURLConnection httpUrlConnection = null;
        InputStream inputStream = null;
        String resultData = "";

        try {
            URL url = new URL(urlString);
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.connect();

            inputStream = httpUrlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader buffereeReader = new BufferedReader(isr);
            String inputLine = "";
            while ((inputLine = buffereeReader.readLine()) != null) {
                resultData += inputLine + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
        }

        return resultData;
    }


    public static Bitmap getImageBitmap(String url) {
        HttpURLConnection httpUrlConnection = null;
        URL imgUrl = null;
        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {
            imgUrl = new URL(url);
            httpUrlConnection = (HttpURLConnection) imgUrl.openConnection();
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.connect();
            inputStream = httpUrlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
        }

        return bitmap;
    }


}
