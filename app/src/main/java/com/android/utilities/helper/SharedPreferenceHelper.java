package com.android.utilities.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dominic Sham on 6/3/2016.
 */
public class SharedPreferenceHelper {

    private final static String PREF_FILE = "PREF";

    private SharedPreferenceHelper() {
    }

    public static SharedPreferenceHelper getInstance() {
        return SharedPreferenceHelperHolder.sharedPreferenceHelperInstance;
    }

    // sharedPreference setter
    static void setSharedPreferenceString(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    static void setSharedPreferenceInt(Context context, String key, int value) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    static void setSharedPreferenceBoolean(Context context, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    static void setSharedPreferenceLong(Context context, String key, long value) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    static void setSharedPreferenceList(Context context, String key, List<String> stringList) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        editor.putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }

    // sharedPreference getter
    static String getSharedPreferenceString(Context context, String key, String defValue) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        String value = settings.getString(key, defValue);

        return value;
    }

    static int getSharedPreferenceInt(Context context, String key, int defValue) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        int value = settings.getInt(key, defValue);

        return value;
    }

    static boolean getSharedPreferenceBoolean(Context context, String key, boolean defValue) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        boolean value = settings.getBoolean(key, defValue);

        return value;
    }

    static long getSharedPreferenceLong(Context context, String key, long defValue) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        long value = settings.getLong(key, defValue);

        return value;
    }

    static List<String> getSharedPreferenceList(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return new ArrayList<String>(Arrays.asList(TextUtils.split(settings.getString(key, ""),
                "‚‗‚")));
    }

    private static class SharedPreferenceHelperHolder {
        public static SharedPreferenceHelper sharedPreferenceHelperInstance = new
                SharedPreferenceHelper();
    }
}
