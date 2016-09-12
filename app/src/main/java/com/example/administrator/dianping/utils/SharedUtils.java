package com.example.administrator.dianping.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

/**
 * Created by Administrator on 2016/9/11 0011.
 */

public class SharedUtils {
    private static String FIRST_ENTRY_FILE="first";
    private static String IS_FIRST_ENTRY="isfirstentry";
    public static boolean isFirstEntry(Context context){
        SharedPreferences preference=context.getSharedPreferences(FIRST_ENTRY_FILE,Context.MODE_PRIVATE);
        return preference.getBoolean(IS_FIRST_ENTRY,true);
    }
    public static void setFirstEntry(Context context,boolean isFirst){
        context.getSharedPreferences(FIRST_ENTRY_FILE,Context.MODE_APPEND).edit()
                .putBoolean(IS_FIRST_ENTRY,isFirst)
                .apply();
    }

}
