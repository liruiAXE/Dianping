package com.example.administrator.dianping.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaRecorder;
import android.preference.Preference;
import android.telecom.StatusHints;

/**
 * Created by Administrator on 2016/9/11 0011.
 */

public class SharedUtils {
    private static String FIRST_ENTRY_FILE="first";
    private static String IS_FIRST_ENTRY="isfirstentry";
    private static String MY_PRE="myrep";
    private static String CITY_LIST_JSON="city_list_json";
    private static String HAS_CITY_LIST_JSON="has city list json";

    private static String CITY_NAME="cityName";
    public static boolean isFirstEntry(Context context){
        SharedPreferences preference=context.getSharedPreferences(FIRST_ENTRY_FILE,Context.MODE_PRIVATE);
        return preference.getBoolean(IS_FIRST_ENTRY,true);
    }
    public static void setFirstEntry(Context context,boolean isFirst){
        context.getSharedPreferences(FIRST_ENTRY_FILE,Context.MODE_APPEND).edit()
                .putBoolean(IS_FIRST_ENTRY,isFirst)
                .apply();
    }
    public static String getCityLocation(Context context){
        SharedPreferences preference=context.getSharedPreferences(FIRST_ENTRY_FILE,Context.MODE_PRIVATE);
        return preference.getString(CITY_NAME,"null");
    }
    public static void setCityLocation(Context context,String cityName){
        context.getSharedPreferences(FIRST_ENTRY_FILE,Context.MODE_APPEND).edit()
                .putString(CITY_NAME,cityName)
                .apply();
    }
    public static void upDateCitylist(Context context,String josnStr ){
        SharedPreferences preferences=context.getSharedPreferences(MY_PRE,Context.MODE_APPEND);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(CITY_LIST_JSON,josnStr);
        editor.putBoolean(HAS_CITY_LIST_JSON,true);
        editor.apply();
    }
    public static String getCityListJsonStr(Context context){
        SharedPreferences preferences=context.getSharedPreferences(MY_PRE,Context.MODE_PRIVATE);
        return preferences.getString(CITY_LIST_JSON,"[]");
    }
    public static boolean isCityListAva(Context context){
        SharedPreferences preferences=context.getSharedPreferences(MY_PRE,Context.MODE_PRIVATE);
        return preferences.getBoolean(HAS_CITY_LIST_JSON,false);

    }
}
