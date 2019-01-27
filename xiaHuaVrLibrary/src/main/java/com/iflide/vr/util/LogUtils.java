package com.iflide.vr.util;

import android.util.Log;

import com.iflide.vr.BuildConfig;

/**
 * 打印日志
 * This provides methods to assist the logging job.
 */
public class LogUtils {

    public static void e(Object tag, Throwable e) {
        Log.e(tag.getClass().getName(), e.getMessage(), e);
    }

    public static void e(Object tag, String msg) {
        Log.e(tag.getClass().getName(), msg);
    }

    public static void e(Object tag, String msg, Throwable e) {
        Log.e(tag.getClass().getName(), msg, e);
    }

    public static void e(String tag, Throwable e) {
        Log.e(tag, e.getMessage(), e);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable e) {
        Log.e(tag, msg, e);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void i(Object tag, String msg) {
        Log.i(tag.getClass().getName(), msg);
    }

    public static void d(Object tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag.getClass().getName(), msg);
        }
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void v(Object tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(tag.getClass().getName(), msg);
        }
    }

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, msg);
        }
    }

}
