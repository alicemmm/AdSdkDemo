package com.perasia.mylibrary.util;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class LiSharedPreferenceUtil {
    private static final String TAG = LiSharedPreferenceUtil.class.getSimpleName();

    private static LiSharedPreferenceUtil preferenceUtil;
    private static SharedPreferences mSp;
    private static final String preference_name = "liPreference";

    private LiSharedPreferenceUtil(Context context) {
        try {
            if (mSp != null) {
                return;
            }
            mSp = context.getSharedPreferences(preference_name, Activity.MODE_PRIVATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static LiSharedPreferenceUtil getInstance(Context context) {
        if (preferenceUtil == null) {
            preferenceUtil = new LiSharedPreferenceUtil(context);
        }
        return preferenceUtil;
    }

    protected static void delete(String name) {
        try {
            SharedPreferences.Editor editor = mSp.edit();
            editor.remove(name);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static synchronized String getStringValue(String key) {
        try {
            if (null == mSp)
                return null;
            else
                return mSp.getString(key, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected static synchronized Integer getIntegerValue(String key) {
        try {
            if (null == mSp)
                return -1;
            else
                return mSp.getInt(key, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    protected static synchronized long getLongValue(String key) {
        try {
            if (null == mSp)
                return -1;
            else
                return mSp.getLong(key, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    protected static synchronized void setStringValue(String key, String value) {
        try {
            if (null != mSp) {
                SharedPreferences.Editor editor = mSp.edit();
                editor.putString(key, value);
                editor.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static synchronized void setIntegerValue(String key, Integer value) {
        try {
            if (null != mSp) {
                SharedPreferences.Editor editor = mSp.edit();
                editor.putInt(key, value);
                editor.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static synchronized void setLongValue(String key, long value) {
        try {
            if (null != mSp) {
                SharedPreferences.Editor editor = mSp.edit();
                editor.putLong(key, value);
                editor.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void clearAllConfig() {
        try {
            if (null != mSp) {
                SharedPreferences.Editor editor = mSp.edit();
                editor.clear();
                editor.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void destory() {
        mSp = null;
        Log.e(TAG, "hesine preferences xml destory.");
    }

}
