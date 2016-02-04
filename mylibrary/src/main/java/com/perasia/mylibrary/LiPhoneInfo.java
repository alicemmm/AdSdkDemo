package com.perasia.mylibrary;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class LiPhoneInfo {
    private static final String TAG = LiPhoneInfo.class.getSimpleName();

    public static enum NetworkType {
        NETWORK_TYPE_UNKNOWN, NETWORK_TYPE_WIFI, NETWORK_TYPE_2G, NETWORK_TYPE_3G, NETWORK_TYPE_4G
    }

    public static int getAppVersionCode(Context context) {
        int result = -1;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            result = pi.versionCode;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        return result;
    }

    public static String getAppVersionName(Context context) {
        String result = null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            result = pi.versionName;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        return result;
    }

    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    /**
     * SIM的状态信息：
     * SIM_STATE_UNKNOWN          未知状态 0
     * SIM_STATE_ABSENT           没插卡 1
     * SIM_STATE_PIN_REQUIRED     锁定状态，需要用户的PIN码解锁 2
     * SIM_STATE_PUK_REQUIRED     锁定状态，需要用户的PUK码解锁 3
     * SIM_STATE_NETWORK_LOCKED   锁定状态，需要网络的PIN码解锁 4
     * SIM_STATE_READY            就绪状态 5
     * @return
     */

    public static int getSIMState(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return tm.getSimState();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * MCC+MNC
     *
     * MCC：Mobile Country Code，移动国家码，共3位. MNC:Mobile NetworkCode，移动网络码，共2位.
     * 中国国际移动码为460. 移动的代码为00和02，联通的代码为01，电信的代码为03
     */
    public static String getNetworkOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(
                    Context.TELEPHONY_SERVICE)).getNetworkOperator(); // MCC+MNC
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取网络类型
     *
     * 联通的3G为UMTS或HSDPA，移动和联通的2G为GPRS或EGDE，电信的2G为CDMA，电信的3G为EVDO
     */
    public static NetworkType getCurrentNetworkType(Context context) {
        try {
            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (NetworkInfo.State.CONNECTED == connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()) {
                return NetworkType.NETWORK_TYPE_WIFI;
            }

            if (NetworkInfo.State.CONNECTED == connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                    .getState()) {
                int subtype = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getSubtype();
//            String name = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
//                    .getSubtypeName();
//            Log.e(TAG, "name:" + name + "=" + "subtype:" + subtype);
                return getMobileNetworkType(subtype);
            } else {
                return NetworkType.NETWORK_TYPE_UNKNOWN;
            }
        } catch (Exception e) {
            return NetworkType.NETWORK_TYPE_UNKNOWN;
        }

    }

    private static NetworkType getMobileNetworkType(int networkType) {
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:// 1
            case TelephonyManager.NETWORK_TYPE_EDGE:// 2
            case TelephonyManager.NETWORK_TYPE_CDMA:// 4
            case TelephonyManager.NETWORK_TYPE_1xRTT:// 7
            case TelephonyManager.NETWORK_TYPE_IDEN:// 11
                return NetworkType.NETWORK_TYPE_2G;
            case TelephonyManager.NETWORK_TYPE_UMTS:// 3
            case TelephonyManager.NETWORK_TYPE_EVDO_0:// 5
            case TelephonyManager.NETWORK_TYPE_EVDO_A:// 6
            case TelephonyManager.NETWORK_TYPE_HSDPA:// 8
            case TelephonyManager.NETWORK_TYPE_HSUPA:// 9
            case TelephonyManager.NETWORK_TYPE_HSPA:// 10
            case TelephonyManager.NETWORK_TYPE_EVDO_B:// 12
            case 14:// TelephonyManager.NETWORK_TYPE_EHRPD:
            case 15:// TelephonyManager.NETWORK_TYPE_HSPAP:
                return NetworkType.NETWORK_TYPE_3G;
            case 13:// TelephonyManager.NETWORK_TYPE_LTE:
                return NetworkType.NETWORK_TYPE_4G;
            default:
                return NetworkType.NETWORK_TYPE_UNKNOWN;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            return ((WindowManager) context.getSystemService(
                    Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth(); // pixel
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getScreenHeight(Context context) {
        try {
            return ((WindowManager) context.getSystemService(
                    Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();// pixel
        } catch (Exception e) {
            return -1;
        }
    }

    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getInstalledAppList(Context context) {
        String result = ""; // alist

        ArrayList<String> appLists = getInstalledAppNames(context);
        if (appLists != null && appLists.size() > 0) {
            boolean isFirst = true;
            StringBuilder sbApp = new StringBuilder();
            for (String appName : appLists) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    sbApp.append(";");
                }
                sbApp.append(appName);
            }
            result = sbApp.toString();
        }

        return result;
    }

    private static ArrayList<String> getInstalledAppNames(Context context) {
        ArrayList<String> result = null;

        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        if (packageInfos == null) {
            return null;
        }

        result = new ArrayList<String>();
        for (int i = 0; i < packageInfos.size(); i++) {
            PackageInfo packageInfo = packageInfos.get(i);
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                String pkgName = packageInfo.packageName;
                String appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                result.add(pkgName + "," + appName);
            }
        }

        return result;
    }


}
