package com.example.administrator.dianping.utils;

import android.util.Log;

import com.example.administrator.dianping.enty.Category;
import com.example.administrator.dianping.enty.City;
import com.example.administrator.dianping.enty.ResponseObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */

public class CategoryFetch {
    public static String TAG="CategoryFetch";
    public static String CAT_URI=CityFetch.BASE_URL+"category";
    private static Gson gson=new Gson();
    public static List<Category> getCatList(){
        List<Category> list=null;
        String jsonStr=CityFetch.getUrlString(CityFetch.getUrlBytes(CAT_URI));
        try {
            JSONObject jsonObject=new JSONObject(jsonStr);
            Log.i(TAG,"jsonObjecty "+jsonObject.toString());
            JSONArray dates=jsonObject.getJSONArray("dates");
            Type type=new TypeToken<List<Category>>(){}.getType();
           list=(List<Category>) gson.fromJson(dates.toString(),type);
            return  list;
        } catch (JSONException e){
            Log.i(TAG,"JSONException xxxxx");
        }
        return list;
    }


}
