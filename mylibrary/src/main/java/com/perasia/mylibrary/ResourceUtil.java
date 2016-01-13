package com.perasia.mylibrary;


import android.content.Context;

public class ResourceUtil {

    public ResourceUtil(){

    }

    public static int getLayoutId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
    }

    public static int getId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
    }

    public static int getDrawableId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    }

    public static int getStringArrayId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "array", paramContext.getPackageName());
    }

    public static int getStringId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    }

    public static int getStyleId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "style", paramContext.getPackageName());
    }

    public static int getColorId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "color", paramContext.getPackageName());
    }

    public static String[] getStringArray(Context context, String paramString) {
        try {
            return context.getResources().getStringArray(getStringArrayId(context, paramString));
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public static String getString(Context context, String paramString) {
        try {
            return context.getString(getStringId(context, paramString));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
