package com.iflide.vr.util;

import android.annotation.SuppressLint;
import android.util.Log;

import com.iflide.vr.UnityTheEntrance.VrApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenda on 2017/12/28.
 */
public class LogPrint {

    private static String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        return  formatter.format(curDate);
    }

    public  static  void LogI(Class cls,String text){
        if(VrApplication.IS_DEBUG){
            String tag = " "+cls.getClass().getName()+" ";
            String date = getCurrentTime();
            String printContent = "LogTime:"+ date+" "+tag+" "+text+" ";
            Log.i(tag, printContent);
        }
    }

    public  static  void LogE(Class cls,String text){
        if(VrApplication.IS_DEBUG){
            String tag = " "+cls.getClass().getName()+" ";
            String date = getCurrentTime();
            String printContent = "LogTime:"+ date+" "+tag+" "+text+" ";
            Log.i(tag, printContent);
        }
    }

    public static void print(String printContent, int i) {
        if(VrApplication.IS_DEBUG){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());
            String tag = "LogTime:"+formatter.format(curDate);
            switch (i) {
                case 0:
                    Log.v(tag, printContent);
                    break;
                case 1:
                    Log.d(tag, printContent);
                    break;
                case 2:
                    Log.i(tag, printContent);
                    break;
                case 3:
                    Log.w(tag, printContent);
                    break;
                case 4:
                    Log.e(tag, printContent);
                    break;
            }
        }
    }
    @SuppressLint("LongLogTag")
    public static void printError(String printContent) {
        int i=4;
        if(VrApplication.IS_DEBUG){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());
            String tag = "LogTime:"+formatter.format(curDate);
            String printContents="------------------------->"+printContent;
            switch (i) {
                case 0:
                    Log.v(tag, printContents);
                    break;
                case 1:
                    Log.d(tag, printContents);
                    break;
                case 2:
                    Log.i(tag, printContents);
                    break;
                case 3:
                    Log.w(tag, printContents);
                    break;
                case 4:
                    Log.e(tag, printContents);
                    break;
            }
        }
    }
}
