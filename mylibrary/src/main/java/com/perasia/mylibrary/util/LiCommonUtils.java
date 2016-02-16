package com.perasia.mylibrary.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class LiCommonUtils {
    private static final String TAG = LiCommonUtils.class.getSimpleName();

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }

        boolean isOK = false;

        try {
            boolean isWifiOK;
            boolean isMobileOK;

            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connManager == null) {
                return false;
            }

            NetworkInfo.State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
            if (state == null) {
                return false;
            }
            if (NetworkInfo.State.CONNECTED == state) {
                isWifiOK = true;
            } else {
                isWifiOK = false;
            }

            state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
            if (state == null) {
                return false;
            }
            if (NetworkInfo.State.CONNECTED == state) {
                isMobileOK = true;
            } else {
                isMobileOK = false;
            }

            if (isMobileOK || isWifiOK) {
                isOK = true;
            }
        } catch (Exception e) {
            isOK = false;
        }

        return isOK;
    }

}
