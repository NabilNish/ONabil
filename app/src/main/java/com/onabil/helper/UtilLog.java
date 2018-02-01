package com.onabil.helper;

import android.util.Log;

/**
 * Created by NABIL on 29-01-2018.
 */

public class UtilLog {
    private static boolean isDebugging = true;

    public static void d(String tag, String msg) {
        if (isDebugging)
            Log.d(tag, msg);
    }

}
