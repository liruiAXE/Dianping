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
    private static String tempJsonStr="[{\"city_id\":\"5\",\"city_name\":\"阿哈利姆\",\"city_sortkey\":\"A\"},{\"city_id\":\"6\",\"city_name\":\"阿尔派\",\"city_sortkey\":\"A\"},{\"city_id\":\"37\",\"city_name\":\"波士顿\",\"city_sortkey\":\"B\"},{\"city_id\":\"38\",\"city_name\":\"草泥马之都\",\"city_sortkey\":\"C\"},{\"city_id\":\"39\",\"city_name\":\"曹操之墓\",\"city_sortkey\":\"C\"},{\"city_id\":\"40\",\"city_name\":\"风之谷\",\"city_sortkey\":\"F\"},{\"city_id\":\"41\",\"city_name\":\"费城\",\"city_sortkey\":\"F\"},{\"city_id\":\"3\",\"city_name\":\"故乡\",\"city_sortkey\":\"G\"},{\"city_id\":\"1\",\"city_name\":\"君临\",\"city_sortkey\":\"J\"},{\"city_id\":\"2\",\"city_name\":\"临冬城\",\"city_sortkey\":\"L\"},{\"city_id\":\"4\",\"city_name\":\"青岛\",\"city_sortkey\":\"Q\"}]";
    //开着服务器电脑太卡 现在改成在本地获取CITYLIST
    public static String getCityListJsonStr(Context context){
//        SharedPreferences preferences=context.getSharedPreferences(MY_PRE,Context.MODE_PRIVATE);
//        return preferences.getString(CITY_LIST_JSON,"[]");
        return tempJsonStr;
    }
    public static boolean isCityListAva(Context context){
        SharedPreferences preferences=context.getSharedPreferences(MY_PRE,Context.MODE_PRIVATE);
        return preferences.getBoolean(HAS_CITY_LIST_JSON,true);

    }
}
