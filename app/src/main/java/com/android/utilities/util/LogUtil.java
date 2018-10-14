package com.android.utilities.util;

import android.util.Log;
import com.android.utilities.config.GeneralConfig;

/**
 * Created by Dominic Sham on 3/13/2016.
 */
public class LogUtil {

    //Log message color - Blue
    public static void d(String log) {
        if (GeneralConfig.enableDebugLog) {
            Log.d(GeneralConfig.LOG_TAG, log);
        }
    }

    //Log message color - Green
    public static void i(String log) {
        if (GeneralConfig.enableDebugLog) {
            Log.i(GeneralConfig.LOG_TAG, log);
        }
    }

    //Log message color - Yellow
    public static void w(String log) {
        if (GeneralConfig.enableDebugLog) {
            Log.w(GeneralConfig.LOG_TAG, log);
        }
    }

    //Log message color - Red
    public static void e(String log) {
        if (GeneralConfig.enableDebugLog) {
            Log.e(GeneralConfig.LOG_TAG, log);
        }
    }

}
